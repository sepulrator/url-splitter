package com.playtech.assignment.service;

import com.playtech.assignment.model.URLModel;
import com.playtech.assignment.state.URLState;

import java.net.URL;

public class StateMachineURLSplitter implements URLSplitter {

    @Override
    public URLModel splitUrl(String urlString) {
        URLModel.URLModelBuilder urlModelBuilder = URLModel.builder();
        try {
            URLState state = URLState.START;
            URL url = new URL(urlString);

            while(!state.equals(URLState.END)) {
                state = state.next(url,urlModelBuilder);
            }

            } catch (Throwable t) {
                t.printStackTrace();
            }
        return urlModelBuilder.build();
    }
}
