package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static io.qameta.allure.Allure.*;

public class PracticeFormPage {
    private final SelenideElement formWrapper = $(".practice-form-wrapper");

    public void openPage(String url) {
        step("Открыть страницу: " + url, () -> Selenide.open(url));
    }

    public void formWrapperIsVisible() {
        step("Рендер формы выполнен успешно", () -> formWrapper.shouldBe(Condition.visible));
    }

    public void enterName(String name) {
        step("Ввести имя: " + name, () -> $("#firstName").setValue(name));
    }

    public void enterLastName(String lastName) {
        step("Ввести фамилию: " + lastName, () -> $("#lastName").setValue(lastName));
    }

    public void enterEmail(String email) {
        step("Ввести email: " + email, () -> $("#userEmail").setValue(email));
    }

    public void selectGender(String gender) {
        step("Выбрать пол: " + gender, () -> $("[value='" + gender + "']").click());
    }

    public void enterPhone(String phone) {
        step("Ввести номер телефона: " + phone, () -> {
            $("#userNumber").setValue(phone);
            $x("//h1[.='Practice Form']").click();
        });
    }

    public void clickOnSubmitButton() {
        step("Нажать кнопку: Submit", () ->
                $("#submit").press(Keys.PAGE_DOWN).hover().shouldBe(Condition.visible).shouldBe(Condition.enabled).click()
        );
    }

    public void assertThatSubmitIsSuccessful() {
        step("Убедиться, что форма отправлена успешно", () -> {
            $("#example-modal-sizes-title-lg").shouldBe(Condition.visible).shouldHave(
                    Condition.text("Thanks for submitting the form")
            );
            $(".table-responsive").shouldBe(Condition.visible);
        });
    }
}
