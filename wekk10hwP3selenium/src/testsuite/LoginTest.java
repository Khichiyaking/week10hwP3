package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    String baseUrl= "http://the-internet.herokuapp.com/login";
     @Before
    public void setupTest(){openBrowser(baseUrl);}

    @Test
    public void UserSholdLoginSuccessfullyWithValidCredentials (){
         driver.findElement(By.id("username")).sendKeys("tomsmith");
         driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
         driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
        Assert.assertEquals(driver.findElement(By.xpath("//h2[contains(text(),'Secure Area')]")).getText(), "Secure Area");
    }
    @Test
    public void verifyTheUsernameErrorMessage(){
        driver.findElement(By.id("username")).sendKeys("tomsmith1");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
    }
    @Test
    public void verifyThePasswordErrorMessage(){
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
        driver.findElement(By.xpath("//i[contains(text(),'Login')]")).click();
    }


}
