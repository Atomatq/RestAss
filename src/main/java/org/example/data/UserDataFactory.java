package org.example.data;

import net.datafaker.Faker;

import java.util.Map;

public class UserDataFactory {
    Faker faker = new Faker();

    public Map<String, String> getValidUserJob() {
        return Map.of("name", faker.name().firstName(),
                "job", faker.job().position());
    }

    public Map<String, String> getValidEmailPswrd() {
        return Map.of("email", "eve.holt@reqres.in",
                "password", "pistol");
    }

}
