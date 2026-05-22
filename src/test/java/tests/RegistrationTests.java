package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class RegistrationTests {

    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    }

    @Test
    void successfulRegistrationTest() {
        new RegistrationPage()
                .openPage()
                .setFirstName("Aikerim")
                .setLastName("Testova")
                .setEmail("aikerim@test.com")
                .setGender("Female")
                .setPhone("1234567890")
                .clickSubmit();
    }
}