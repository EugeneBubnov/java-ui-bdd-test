package step;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.qameta.allure.Allure;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PracticeFormStep {
    private final SelenideElement formWrapper = $(".practice-form-wrapper");

    @Given("Открыть страницу {string}")
    public void openPage(String url) {
        Allure.step("Открыть страницу: " + url, () -> {
            Configuration.timeout = 30_000;
            Selenide.open(url);
        });
    }

    @When("Рендер формы выполнен успешно")
    public void checkFormRendered() {
        if (!formWrapper.is(Condition.visible)) {
            throw new RuntimeException("Form wrapper is not found");
        }
    }

    @And("Ввести имя: {string}")
    public void enterName(String name) {
        $("#firstName").setValue(name);
    }

    @And("Ввести фамилию: {string}")
    public void enterLastName(String lastName) {
        $("#lastName").setValue(lastName);
    }

    @And("Ввести почту: {string}")
    public void enterEmail(String email) {
        $("#userEmail").setValue(email);
    }

    @And("Выбрать пол: {string}")
    public void selectGender(String gender) {
        $("[value='" + gender + "']").click();
    }

    @And("Ввести номер телефона: {string}")
    public void enterPhone(String phone) {
        $("#userNumber").setValue(phone);
        $x("//h1[.='Practice Form']").click();
    }

    @And("Нажать кнопку: Submit")
    public void clickOnButton() {
        $("#submit").press(Keys.PAGE_DOWN)
                .hover()
                .shouldBe(Condition.visible).shouldBe(Condition.enabled).click();
    }

    @Then("Убедиться, что форма отправлена успешно")
    public void assertThatSubmitIsSuccessful() {
        $("#example-modal-sizes-title-lg")
                .shouldBe(Condition.visible)
                .shouldHave(Condition.text("Thanks for submitting the form"));

        $(".table-responsive").shouldBe(Condition.visible);
    }
}