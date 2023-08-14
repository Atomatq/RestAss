package org.example.steps;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.example.paths.Endpoints;
import org.example.spec.GenSpecs;
import org.example.spec.InitSpecs;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class Steps {

    @Step
    public Response queryUsersList(int page) {
        return given().
                spec(InitSpecs.set()).
                pathParam("page", page).
                when().
                get(Endpoints.GET_USERS).
                then().
                log().all().
                spec(GenSpecs.statusOkAndMatchesSchemaIn(HttpStatus.SC_OK, "schemas/getUserList.json")).
                extract().
                response();
    }

    @Step
    public Response createUser(Map<String, String> userJob) {
        return given().
                spec(InitSpecs.set()).
                body(userJob).
                when().
                post(Endpoints.POST_CREATE).
                then().
                log().all().
                spec(GenSpecs.statusOkAndMatchesSchemaIn(HttpStatus.SC_CREATED, "schemas/createUser.json")).
                extract().
                response();
    }

    @Step
    public Response registerSuccessful(Map<String, String> emailPswrd) {
        return given().
                spec(InitSpecs.set()).
                body(emailPswrd).
                when().
                post(Endpoints.POST_REGISTER).
                then().
                log().all().
                spec(GenSpecs.statusOkAndMatchesSchemaIn(HttpStatus.SC_OK, "schemas/register.json")).
                extract().
                response();
    }
}
