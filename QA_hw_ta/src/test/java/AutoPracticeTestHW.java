import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.core.Is.is;
import static org.junit.matchers.JUnitMatchers.containsString;

public class AutoPracticeTestHW {
    public static WebDriver driver;
//Зайти на сайт, открыть категорию (каждый студент выбирает себе свою категорию и товар)
// и проверить, что данная категория открылась.
    @Test
    public void verifyThatOpenedRightCategory() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\drivers\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://automationpractice.com");

        String expectedURL = "http://automationpractice.com";
        String actualURL = driver.getCurrentUrl();

        Assert.assertThat("The page is not " + expectedURL,
                actualURL, containsString(expectedURL));

        String xpath = "//ul[@class='sf-menu clearfix menu-content sf-js-enabled sf-arrows']/li[2]/a";
        WebElement category = driver.findElement(By.xpath(xpath));
        Assert.assertThat("Category is not enable", category.isDisplayed(), is(true));

        category.click();

        String expectedURLCategory = "http://automationpractice.com/index.php?id_category=8&controller=category";
        String actualURLCategory = driver.getCurrentUrl();

        Assert.assertThat("This page is not: " + expectedURLCategory,
                actualURLCategory, containsString(expectedURLCategory));

    }
}
