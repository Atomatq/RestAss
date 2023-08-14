package org.example.spec;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.example.config.ConfigManager;
import org.example.config.Configuration;

public class InitSpecs {

    public static RequestSpecification set() {
        Configuration config = ConfigManager.getConfiguration();

        return new RequestSpecBuilder()
                .setBaseUri(config.baseUri())
                .setBasePath(config.basePath())
                .setContentType(ContentType.JSON)
                .build();
    }
}
