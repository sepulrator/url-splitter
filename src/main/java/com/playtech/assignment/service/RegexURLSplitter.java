package com.playtech.assignment.service;

import com.playtech.assignment.model.URLModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexURLSplitter implements URLSplitter {

    private static final Pattern URL_SPLIT_PATTERN = Pattern.compile("^(([^:/?#]+):)?(//([^/?#]*)/?)?([^?#]*)(\\?([^#]*)?)?");
    private static final String COLON = ":";

    public URLModel splitUrl(String url) {
        Matcher matcher = URL_SPLIT_PATTERN.matcher(url);
        matcher.find();

        String socketAddress = matcher.group(4);
        String host = "";
        Integer port = null;
        if (socketAddress.contains(COLON)) {
            host =  socketAddress.split(COLON)[0];
            port = Integer.valueOf(socketAddress.split(COLON)[1]);
        } else {
            host = socketAddress;
        }

        return URLModel.builder()
                .scheme(matcher.group(2))
                .host(host)
                .port(port)
                .path(matcher.group(5))
                .parameters(matcher.group(7))
                .build();

    }
}
