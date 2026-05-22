package tests;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    @Step("Открыть форму регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("Ввести имя: {firstName}")
    public RegistrationPage setFirstName(String firstName) {
        $("#firstName").setValue(firstName);
        return this;
    }

    @Step("Ввести фамилию: {lastName}")
    public RegistrationPage setLastName(String lastName) {
        $("#lastName").setValue(lastName);
        return this;
    }

    @Step("Ввести email: {email}")
    public RegistrationPage setEmail(String email) {
        $("#userEmail").setValue(email);
        return this;
    }

    @Step("Выбрать пол: {gender}")
    public RegistrationPage setGender(String gender) {
        $(byText(gender)).click();
        return this;
    }

    @Step("Ввести номер телефона: {phone}")
    public RegistrationPage setPhone(String phone) {
        $("#userNumber").setValue(phone);
        return this;
    }

    @Step("Нажать кнопку Submit")
    public RegistrationPage clickSubmit() {
        $("#submit").click();
        return this;
    }
}