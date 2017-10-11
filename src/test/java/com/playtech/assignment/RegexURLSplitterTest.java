package com.playtech.assignment;

import com.playtech.assignment.model.URLModel;
import com.playtech.assignment.service.RegexURLSplitter;
import static org.junit.Assert.assertEquals;

import com.playtech.assignment.service.URLSplitter;
import org.junit.Test;

public class RegexURLSplitterTest {

    URLSplitter urlSplitter = new RegexURLSplitter();

    @Test
    public void testURLSplitReturnHttpsScheme() {
        URLModel urlModel = urlSplitter.splitUrl("https://www.playtech.com");
        assertEquals("https",urlModel.getScheme());
    }

    @Test
    public void testURLSplitReturnPlaytechScheme() {
        URLModel urlModel = urlSplitter.splitUrl("https://www.playtech.com");
        assertEquals("www.playtech.com",urlModel.getHost());
    }


    @Test
    public void testURLSplitReturnPortNull() {
        URLModel urlModel = urlSplitter.splitUrl("https://www.playtech.com");
        assertEquals(null,urlModel.getPort());
    }

    @Test
    public void testURLSplitReturnPort443() {
        URLModel urlModel = urlSplitter.splitUrl("https://www.playtech.com:443");
        assertEquals(new Integer(443),urlModel.getPort());
    }

    @Test
    public void testURLSplitReturnPathServices() {
        URLModel urlModel = urlSplitter.splitUrl("https://www.playtech.com:443/services");
        assertEquals("services",urlModel.getPath());
    }

    @Test
    public void testURLSplitReturnParamsMarketingServices() {
        URLModel urlModel = urlSplitter.splitUrl("https://www.playtech.com:443/services?marketing_services");
        assertEquals("marketing_services",urlModel.getParameters());
    }

    @Test
    public void testURLSplitReturnParamsNull() {
        URLModel urlModel = urlSplitter.splitUrl("https://www.playtech.com:443/services");
        assertEquals(null,urlModel.getParameters());
    }

}
