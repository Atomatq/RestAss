import io.restassured.path.json.JsonPath;
import org.example.data.UserDataFactory;
import org.example.steps.Steps;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ApiTests {

    Steps steps = new Steps();
    UserDataFactory userDataFactory = new UserDataFactory();

    @Test
    @DisplayName("Получить список пользователей. ")
    public void correctUserList() {
        var response = steps.queryUsersList(1);
        assertEquals(response.jsonPath().get("page").toString(), "1", "Wrong page");
    }

    @Test
    @DisplayName("Создание нового пользователя. ")
    public void createNewUser() {
        Map<String, String> userInfo = new HashMap<>(userDataFactory.getValidUserJob());
        var response = steps.createUser(userInfo);
        JsonPath jsonPath = response.jsonPath();

        assertEquals(jsonPath.get("name").toString(), userInfo.get("name"), "Name is not valid");
        assertEquals(jsonPath.get("job").toString(), userInfo.get("job"), "Job is not valid");
    }

    @Test
    @DisplayName("Успешная регистрация. ")
    public void successfulReg() {
        var emailPswrd = userDataFactory.getValidEmailPswrd();
        var response = steps.registerSuccessful(emailPswrd);
        JsonPath jsonPath = response.jsonPath();

        assertEquals(jsonPath.get("id").toString(), "4", "Id is wrong");
        assertEquals(jsonPath.get("token"),"QpwL5tke4Pnpja7X4",  "Token is wrong");
    }
}
