package com.playtech.assignment;

import com.playtech.assignment.model.URLModel;
import com.playtech.assignment.service.RegexURLSplitter;
import com.playtech.assignment.service.StateMachineURLSplitter;
import com.playtech.assignment.service.URLSplitter;

import java.util.Optional;
import java.util.stream.IntStream;

public class URLSplitterApplication {

    private static final Integer LIMIT = 10000;

    public static void main(String[] args) {
        String urlString = args[0];

        URLSplitter regexURLSplitter = new RegexURLSplitter();
        URLSplitter stateMachineURLSplitter = new StateMachineURLSplitter();

        long start = System.currentTimeMillis();
        Optional<URLModel> regexUrlModel = IntStream.range(0, LIMIT).mapToObj($ -> regexURLSplitter.splitUrl(urlString)).findFirst();
        long regexElapsedTime = System.currentTimeMillis() - start;


        start = System.currentTimeMillis();
        Optional<URLModel> stateMachineURLResult = IntStream.range(0, LIMIT).mapToObj($ -> stateMachineURLSplitter.splitUrl(urlString)).findFirst();
        long stateMachineElapsedTime = System.currentTimeMillis() - start;

        System.out.println(stateMachineURLResult.get());
        System.out.println("Regex: " + regexElapsedTime+"msec");
        System.out.println("State: " + stateMachineElapsedTime+"msec");


    }
}
