package starter.steps;

import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import starter.dao.ZIdUser;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleContains;

public class ZIdUserLoginIntoApplication {

    private String actor;

    private ZIdUser user;

    @Step("#actor is a registered zeiss id user")
    public void user_is_a_register_zeiss_id_user(String username, String password){
            user = new ZIdUser(username,password);
    }

   @Step("#actor logs into zeiss id app")
    public void user_log_in_into_zeiss_id_app(WebDriver driver){
       driver.navigate().to("https://zeissid-claimsapp-test.azurewebsites.net/");

       driver.findElement(By.name("q")).sendKeys("firefly", Keys.ENTER);

       new WebDriverWait(driver,5).until(titleContains("firefly - Google"));

       assertThat(driver.getTitle()).contains("firefly - Google");
    }
}
