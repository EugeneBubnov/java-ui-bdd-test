package step;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.After;

public class Hooks {
    @After
    public void tearDown() {
        //System.out.println("hook detected");
        Selenide.closeWebDriver();
    }
}
