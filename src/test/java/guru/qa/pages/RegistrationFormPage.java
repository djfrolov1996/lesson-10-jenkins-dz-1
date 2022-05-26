package guru.qa.pages;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Arrays;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    //locators:
    SelenideElement firstNameInput = $("#firstName");
    SelenideElement lastNameInput = $("#lastName");
    SelenideElement dateOfBirth = $("#dateOfBirthInput");
    SelenideElement dateOfBirthMonth = $(".react-datepicker__month-select");
    SelenideElement dateOfBirthDay = $(".react-datepicker__month-container");
    SelenideElement dateOfBirthYear = $(".react-datepicker__year-select");
    SelenideElement emailInput = $("#userEmail");
    SelenideElement genderInput = $("#genterWrapper");
    SelenideElement phoneNumberInput = $("#userNumber");
    SelenideElement addressInput = $("#currentAddress");
    SelenideElement subjectsClick = $("#subjectsContainer");
    SelenideElement subjectsInput = $("#subjectsInput");
    SelenideElement stateClick = $("#state");
    SelenideElement stateInput = $("#react-select-3-input");
    SelenideElement cityClick = $("#city");
    SelenideElement cityInput = $("#react-select-4-input");
    SelenideElement uploadPictureInput = $("#uploadPicture");
    SelenideElement submitClick = $("#submit");
    SelenideElement checkFinalForm = $(".modal-body");


    //actions:

    //открытие браузера
    @Step("Open Testing Page")
    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("Entering a firstname {value}")
    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Entering a lastname {value}")
    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Entering a email {value}")
    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);
        return this;
    }

    @Step("Entering date of birth {day} {month} {year}")
    public RegistrationFormPage setDateOfBirth(String month, String year, String day) {
        dateOfBirth.click();
        dateOfBirthMonth.selectOption(month);
        dateOfBirthYear.selectOption(year);
        dateOfBirthDay.$(byText(day)).click();
        return this;
    }

    @Step("Gender choice {value}")
    public RegistrationFormPage setGender(String value) {
        genderInput.$(byText(value)).click();
        return this;
    }

    @Step("Entering phone number {value}")
    public RegistrationFormPage setPhoneNumber(String value) {
        phoneNumberInput.setValue(value);
        return  this;
    }

    @Step("Entering address{value}")
    public RegistrationFormPage setAddress(String value) {
        addressInput.setValue(value);
        return  this;
    }

    @Step("Subjects choice {value}")
    public RegistrationFormPage setSubjects(String value) {
        subjectsClick.click();
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Hobbies choice")
    public RegistrationFormPage setHobbies() {
        for (String s : Arrays.asList("label[for='hobbies-checkbox-1']",
                "label[for='hobbies-checkbox-2']",
                "label[for='hobbies-checkbox-3']")) {
            $(s).click();
        }
        return this;
    }

    @Step("State choice {value}")
    public RegistrationFormPage setState(String value) {
        stateClick.click();
        stateInput.setValue(value).pressEnter();
        return this;
    }

    @Step("City choice {value}")
    public RegistrationFormPage setCity(String value) {
        cityClick.click();
        cityInput.setValue(value).pressEnter();
        return this;
    }

    @Step("File upload {value}")
    public RegistrationFormPage setFileUpload(String value) {
        uploadPictureInput.uploadFromClasspath(value);
        return this;

    }

    @Step("Submit image")
    public RegistrationFormPage clickSubmit() {
        submitClick.click();
        return this;

    }

    //итоговая форма
    public RegistrationFormPage checkFinalFormTest(String key, String value) {
        checkFinalForm.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }

}
