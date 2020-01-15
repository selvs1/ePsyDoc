package ch.bfh.btx8081.w2019.white.ePsyDoc;


import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest {

    /**
     * Vaadin sucks.
     *
     * @throws InterruptedException
     * @deprecated This methode is used as a template for tests with solenium but unfortunately it doesn't work yet.
     */
    @Test
    public void openWithChrome() throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "C:\\pathto\\my\\chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\sugeelan\\Downloads\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        System.out.println(driver.getCurrentUrl());
        driver.get("localhost:8080");
        Thread.sleep(2000);
        driver.get("localhost:8080");
        Thread.sleep(2000);

        WebElement btn = driver.findElement(By.name("button"));
        btn.submit();
        System.out.println("done");
        driver.findElement(By.id("input")).sendKeys("pund3");

        Thread.sleep(500);

//        Thread.sleep(1000);  // Let the user actually see something!
//        WebElement searchBox = driver.findElement(By.name("q"));
//        searchBox.sendKeys("ChromeDriver");
//        searchBox.submit();
//        Thread.sleep(5000);  // Let the user actually see something!
        driver.quit();
    }

}
