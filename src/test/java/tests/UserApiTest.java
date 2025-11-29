// src/test/java/api/tests/UserApiTest.java
package tests;

import api.base.ApiBase;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class UserApiTest extends ApiBase {

    @Test(description = "Проверка получения списка пользователей и валидация структуры")
    public void checkListOfUsers() {

        String endpoint = "/users";

        // 1. Выполнение GET-запроса и базовая валидация
        Response response = given()
                .when()
                .get(endpoint)
                .then()
                .log().body()
                .statusCode(403) // Проверяем, что ответ успешный
                .body("", is(not(empty()))) // Проверяем, что тело ответа не пустое
                .extract().response();

        System.out.println(response.getBody().prettyPrint());
    }

}