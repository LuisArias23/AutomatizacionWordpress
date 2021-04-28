package com.automatizacion.Post;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;

public class quickEdit_Post {

    By UserLocator = By.id("user_login");
    By PassLocator = By.id("user_pass");
    By LoginLocator = By.id("wp-submit");
    By PostLocator = By.xpath("//li[@id='menu-posts']");
    By AllPostLocator = By.linkText("All Posts");
    By QuickEditLocator = By.xpath("//button[@class='button-link editinline']");
    By TitleLocator = By.xpath("//div[@class='inline-edit-col']/label/span[2]/input");
    By UpdateLocator = By.xpath("//div[@class='submit inline-edit-save']/button[2]");
    WebDriver driver;

    public static void failed(WebDriver driver, String fileName) throws IOException {
        File screenchotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenchotFile, new File("C:\\evidencia\\Post\\quickEdit\\" + fileName + ".png"));
    }

    @Test
    public void webdriverNavegador() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
        Thread.sleep(2000);
        this.failed(driver, "Login");
        driver.manage().window().maximize();
        driver.findElement(UserLocator).sendKeys("opensourcecms");
        driver.findElement(PassLocator).sendKeys("opensourcecms");
        this.failed(driver, "Datos");
        driver.findElement(LoginLocator).click();
        Thread.sleep(2000);
        this.failed(driver, "DashBoard");
        driver.findElement(PostLocator).click();
        Thread.sleep(2000);
        this.failed(driver, "opciones");
        driver.findElement(AllPostLocator).click();
        Thread.sleep(2000);
        this.failed(driver, "pagina principal de All Pages");
        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.xpath("//tbody[@id='the-list']/tr[1]/td[@data-colname='Title']"));
        action.moveToElement(we).perform();
        Thread.sleep(2000);
        this.failed(driver, "opciones de el Post");
        driver.findElement(QuickEditLocator).click();
        Thread.sleep(2000);
        this.failed(driver, "pagina principal QuickEdit");
        driver.findElement(TitleLocator).clear();
        driver.findElement(TitleLocator).sendKeys("editando2");
        driver.findElement(UpdateLocator).click();
        this.failed(driver, "pagina editada");
    }
}
