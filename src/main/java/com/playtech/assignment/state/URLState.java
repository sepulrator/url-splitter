package com.playtech.assignment.state;

import com.playtech.assignment.model.URLModel;

import java.net.URL;

public enum URLState implements State {
    START {
        @Override
        public URLState next(URL url, URLModel.URLModelBuilder urlModelBuilder)
        {
            return SCHEME;
        }
    },
    SCHEME {
        @Override
        public URLState next(URL url, URLModel.URLModelBuilder urlModelBuilder)
        {
            urlModelBuilder.scheme(url.getProtocol());
            return HOST;
        }
    },
    HOST {
        @Override
        public URLState next(URL url, URLModel.URLModelBuilder urlModelBuilder)
        {
            urlModelBuilder.host(url.getHost());
            return PORT;
        }
    },
    PORT {
        @Override
        public URLState next(URL url, URLModel.URLModelBuilder urlModelBuilder)
        {
            urlModelBuilder.port(url.getPort() == -1 ? null : new Integer(url.getPort()));
            return PATH;
        }
    },
    PATH {
        @Override
        public URLState next(URL url, URLModel.URLModelBuilder urlModelBuilder)
        {
            urlModelBuilder.path(url.getPath().length() > 1 ? url.getPath().substring(1) : null);
            return PARAMETERS;
        }
    },
    PARAMETERS {
        @Override
        public URLState next(URL url, URLModel.URLModelBuilder urlModelBuilder)
        {
            urlModelBuilder.parameters(url.getQuery());
            return END;
        }
    },
    END {
        @Override
        public URLState next(URL url, URLModel.URLModelBuilder urlModelBuilder)
        {
            return this;
        }
    };
}
