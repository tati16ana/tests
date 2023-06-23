import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class testing {
    WebDriver webDriver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.navigate().to("http://autoriz/index.php");
    }

    //Тестирование перехода на страницу "Типы планировок"
    @Test
    public void headerToTypes(){
        WebElement webElement =
                webDriver.findElement(By.xpath("//*[@id=\"nav552082494\"]/div/div[3]/nav/ul/li[2]/a"));
        webElement.click();
        var expectedResult = "Типы планировок";
        var actualResult =
                webDriver.findElement(By.xpath("//*[@id=\"rec557836400\"]/div/div/div/div[1]/div")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    //Тестирование перехода на страницу "Акции"
    @Test
    public void headerToPromotions(){
        WebElement webElement =
                webDriver.findElement(By.xpath("//*[@id=\"nav552082494\"]/div/div[3]/nav/ul/li[5]/a"));
        webElement.click();
        var expectedResult = "Акции";
        var actualResult =
                webDriver.findElement(By.xpath("//*[@id=\"rec534727726\"]/div/div/div/div[1]/div")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    //Тестирование перехода на страницу "Выбрать квартиру"
    @Test
    public void headerToSelectFlat(){
        var actualResult = false;
        WebElement webElement =
                webDriver.findElement(By.xpath("//*[@id=\"nav552082494\"]/div/div[3]/nav/ul/li[4]/a"));
        webElement.click();
        var expectedResult = true;
        if(webDriver.findElement(By.xpath("//*[@id=\"rec557804295\"]/div/div/div/div[1]/div/div/div/div[2]")).isDisplayed()){
            actualResult = true;
        }else {
            actualResult = false;
        }
        Assert.assertEquals(expectedResult, actualResult);
    }

    //Тестирование перехода на страницу "Документы"
    @Test
    public void footerToDocuments(){
        WebElement webElement =
                webDriver.findElement(By.xpath("//*[@id=\"rec569562484\"]/div/div/div[2]/div[2]/ul/li[2]/a"));
        webElement.click();
        var expectedResult = "Документы";
        var actualResult =
                webDriver.findElement(By.xpath("//*[@id=\"rec539474081\"]/div/div/div/div[1]/div")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    //Тестирование перехода на страницу "Политика конфиденциальности"
    @Test
    public void footerToPolicy(){
        WebElement webElement =
                webDriver.findElement(By.xpath("//*[@id=\"rec569562484\"]/div/div/div[2]/div[2]/ul/li[3]/a"));
        webElement.click();
        var expectedResult = "Политика конфиденциальности";
        var actualResult =
                webDriver.findElement(By.xpath("//*[@id=\"rec539474539\"]/div/div/div/div[1]/div")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    //Тестирование авторизации
    @Test
    public void authorization(){
        WebElement enterBtn =
                webDriver.findElement(By.xpath("//*[@id=\"nav552082494\"]/div/div[4]/div/div[2]/div/div/a"));
        enterBtn.click();
        WebElement loginField =
                webDriver.findElement(By.xpath("/html/body/form/input[1]"));
        loginField.sendKeys("ivan");
        WebElement passwordField =
                webDriver.findElement(By.xpath("/html/body/form/input[2]"));
        passwordField.sendKeys("Ivan123!");
        WebElement submitBtn =
                webDriver.findElement(By.xpath("/html/body/form/button[1]"));
        submitBtn.click();
        var expectedResult = "Ваши данные";
        var actualResult =
                webDriver.findElement(By.xpath("/html/body/div/div/div/div/div[1]/h1")).getText();
        Assert.assertEquals(expectedResult, actualResult);
    }

    @After
    public  void close(){
        webDriver.close();
    }
}
