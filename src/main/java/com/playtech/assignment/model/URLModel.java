package com.playtech.assignment.model;


import lombok.*;

@Builder
@Getter
@Setter
public class URLModel {
    private String scheme;
    private String host;
    private Integer port;
    private String path;
    private String parameters;

    @Override
    public String toString() {
        final String newline = System.getProperty("line.separator");

        return new StringBuilder()
                .append(scheme)
                .append(newline)
                .append(host)
                .append(newline)
                .append(port)
                .append(newline)
                .append(path)
                .append(newline)
                .append(parameters)
                .toString();
    }
}
