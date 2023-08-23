package webdriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Topic_11_Selenium_Location {
    WebDriver driver;
    String projectPath = System.getProperty("user.dir");
    String osName = System.getProperty("os.name");

    @BeforeClass
    public void beforeClass() {
        if (osName.contains("Windows")) {
            System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
        } else {
            System.setProperty("webdriver.gecko.driver", projectPath + "/browserDrivers/geckodriver");
        }

        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/register");
    }
    @Test
    public void TC_01_ID() {
        driver.findElement(By.id("FirstName")).sendKeys("Dang");
    }

    @Test
    public void TC_02_Class() {
        driver.findElement(By.className("header-logo"));
    }

    @Test
    public void TC_03_Name() {
        driver.findElement(By.name("DateOfBirthDay"));

    }

    @Test
    public void TC_04_Tagname() {
        driver.findElement(By.tagName("input"));
    }

    @Test
    public void TC_05_Linktext() {
        driver.findElement(By.linkText("New products"));
    }

    @Test
    public void TC_06_Partial_LinkText() {
        driver.findElement(By.partialLinkText("products"));
    }

    @Test
    public void TC_07_Css() {
        //Css voi ID
        driver.findElement(By.cssSelector("input[id='FirstName']"));
        driver.findElement(By.cssSelector("input#FirstName"));
        driver.findElement(By.cssSelector("#FirstName"));

        //Css voi class
        driver.findElement(By.cssSelector("div[class='page-title']"));
        driver.findElement(By.cssSelector("div.page-title"));
        driver.findElement(By.cssSelector(".page-title"));

        //Css voi name
        driver.findElement(By.cssSelector("input[name='FirstName']"));

        //Css voi tagname
        driver.findElement(By.cssSelector("input"));

        //Css voi link
        driver.findElement(By.cssSelector("a[href='/vendor/apply']"));

        //Css voi Partiallink
        driver.findElement(By.cssSelector("a[href*='/vendor/apply']"));

    }

    @Test
    public void TC_08_Xpath() {
        //Css voi ID
        driver.findElement(By.xpath("//input[@id='FirstName']"));

        //Css voi class
        driver.findElement(By.xpath("//div[@class='page-title']"));

        //Css voi name
        driver.findElement(By.xpath("//input[@name='FirstName']"));

        //Css voi tagname
        driver.findElement(By.xpath("//input"));

        //Css voi link
        driver.findElement(By.xpath("//a[@href='/vendor/apply']"));
        driver.findElement(By.xpath("//a[text()='New products']"));


        //Css voi Partiallink
        driver.findElement(By.xpath("//a[contains(@href, 'addresses')]"));
        driver.findElement(By.xpath("//a[contains(text(), 'Addresses')]"));

    }

    @AfterClass
    public void afterClass() {
        driver.quit();
    }
}
