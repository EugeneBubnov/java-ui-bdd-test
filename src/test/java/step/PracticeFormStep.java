package step;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.PracticeFormPage;

public class PracticeFormStep {
    PracticeFormPage practiceFormPage = new PracticeFormPage();

    @Given("Открыть страницу {string}")
    public void openPage(String url) {
        practiceFormPage.openPage(url);
    }

    @When("Рендер формы выполнен успешно")
    public void renderSuccess() {
        practiceFormPage.formWrapperIsVisible();
    }

    @And("Ввести имя: {string}")
    public void setName(String name) {
        practiceFormPage.enterName(name);
    }

    @And("Ввести фамилию: {string}")
    public void setLastName(String lastName) {
        practiceFormPage.enterLastName(lastName);
    }

    @And("Ввести email: {string}")
    public void setEmail(String email) {
        practiceFormPage.enterEmail(email);
    }

    @And("Выбрать пол: {string}")
    public void viewGender(String gender) {
        practiceFormPage.selectGender(gender);
    }

    @And("Ввести номер телефона: {string}")
    public void setPhoneNumber(String phoneNumber) {
        practiceFormPage.enterPhone(phoneNumber);
    }

    @And("Нажать кнопку: Submit")
    public void clickSubmit() {
        practiceFormPage.clickOnSubmitButton();
    }

    @Then("Убедиться, что форма отправлена успешно")
    public void sentIsSuccessful() {
        practiceFormPage.assertThatSubmitIsSuccessful();
    }
}