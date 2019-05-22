package starter.math;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import starter.steps.ZIdUserLoginIntoApplication;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;


@RunWith(SerenityRunner.class)
public class smallSeleniumTest {

    @Managed
    WebDriver driver;

    @Steps(actor = "Juan Perez")
    ZIdUserLoginIntoApplication juan;

    @Test
    public void googleSearch(){
        driver.navigate().to("http://www.google.com");

        driver.findElement(By.name("q")).sendKeys("firefly", Keys.ENTER);

        new WebDriverWait(driver,5).until(titleContains("firefly - Google"));

        assertThat(driver.getTitle()).contains("firefly - Google");
    }
}
