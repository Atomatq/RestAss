package org.example.spec;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;
import org.hamcrest.Matcher;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class GenSpecs {
    public static ResponseSpecification statusOkAndMatchesSchemaIn(int status, String classpath) {
        return new ResponseSpecBuilder().
                expectStatusCode(status).
                expectBody(matchesJsonSchemaInClasspath(classpath)).
                build();
    }
}
