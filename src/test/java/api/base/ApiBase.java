package api.base;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;

public class ApiBase {

    // Вставьте здесь базовый URL вашего API (например, API Air Canada или тестовый API)
    protected static final String BASE_URL = "https://api.aircanada.com/v1/";
    // Если у вас есть тестовый API, используйте его, например, "https://jsonplaceholder.typicode.com/"

    @BeforeClass
    public void setup() {
        // Установка Base URI для всех запросов Rest Assured
        RestAssured.baseURI = BASE_URL;

        // Добавление общих заголовков (например, Content-Type)
        RestAssured.requestSpecification = RestAssured.given()
                .header("Content-Type", "application/json")
                // Если нужен токен авторизации: .header("Authorization", "Bearer your_token_here")
                .log().all(); // Логирование запросов в консоль
    }
}