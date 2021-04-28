package com.automatizacion.Post;

import org.apache.commons.io.FileUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class addNew_Post {
    By UserLocator = By.id("user_login");
    By PassLocator = By.id("user_pass");
    By LoginLocator = By.id("wp-submit");
    By PostLocator = By.xpath("//li[@id='menu-posts']");
    By AddNewLocator = By.linkText("Add New");
    By CloseLocator = By.xpath("//button[@aria-label='Close dialog']");
    By TitleLocator = By.xpath("//div[@class='block-editor-writing-flow']//div[1]//div/textarea");
    By PublishLocator = By.xpath("//div[@class='edit-post-header__settings']/button");
    WebDriver driver;
    public static void failed(WebDriver driver, String fileName) throws IOException {
        File screenchotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenchotFile, new File("C:\\evidencia\\Post\\addNew\\" + fileName + ".png"));
    }
    @Test
    public void addNewPost() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://s1.demo.opensourcecms.com/wordpress/wp-login.php");
        Thread.sleep(2000);
        driver.manage().window().maximize();
        this.failed(driver, "Login");
        driver.findElement(UserLocator).sendKeys("opensourcecms");
        driver.findElement(PassLocator).sendKeys("opensourcecms");
        this.failed(driver, "Datos");
        driver.findElement(LoginLocator).click();
        Thread.sleep(2000);
        this.failed(driver, "DashBoard");
        driver.findElement(PostLocator).click();
        Thread.sleep(2000);
        this.failed(driver, "opciones");
        driver.findElement(AddNewLocator).click();
        Thread.sleep(2000);
        driver.findElement(CloseLocator).click();
        this.failed(driver, "pagina principal de Add Post");
        driver.findElement(TitleLocator).sendKeys("prueba4");
        driver.findElement(PublishLocator).click();
        Thread.sleep(3000);
        this.failed(driver, "Post publicado");

    }
}
