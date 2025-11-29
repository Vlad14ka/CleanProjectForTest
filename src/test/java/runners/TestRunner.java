package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test; // Убедитесь, что TestNG импортирован

@CucumberOptions(
        // Путь к .feature файлам
        features = "src/test/resources/features",
        // Путь к классам Step Definitions
        glue = "stepDefinitions",
        // Формат отчетов
        plugin = {"pretty", "html:target/cucumber-reports/cucumber-html-report.html"},
        // Метки, которые нужно запустить (например, @Smoke, @Regression)
        tags = "@MyBookingTest",
        // Установка в true предотвращает фактический запуск кода,
        // используется для генерации шаблонов Step Definitions
        dryRun = false
)
public class TestRunner extends AbstractTestNGCucumberTests {

    // Этот метод необходим для параллельного выполнения сценариев в TestNG
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}