package com.playtech.assignment.state;

import com.playtech.assignment.model.URLModel;

import java.net.URL;

public interface State {

    URLState next(URL url, URLModel.URLModelBuilder urlModelBuilder);


}
