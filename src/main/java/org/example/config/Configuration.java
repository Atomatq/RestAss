package org.example.config;

import org.aeonbits.owner.Config;

import static org.aeonbits.owner.Config.*;

@Sources("classpath:api.properties")
public interface Configuration extends Config {
    @Key("api.base.uri")
    String baseUri();

    @Key("api.base.path")
    String basePath();
}
