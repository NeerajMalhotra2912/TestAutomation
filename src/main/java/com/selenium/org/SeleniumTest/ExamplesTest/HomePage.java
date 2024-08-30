package com.selenium.org.SeleniumTest.ExamplesTest;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import javax.swing.*;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage {

    static WebDriver driver;

    void doSetUp(){
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().timeouts().implicitlyWait(2000, TimeUnit.MILLISECONDS);

    }

    void countLinks(){
        int linksCount = 0;
        List<WebElement> totalLinks = driver.findElements(By.xpath("//a"));
        System.out.println("Total links available are : " + totalLinks);
        for(WebElement element: totalLinks){

            System.out.println(element.getText());
            linksCount++;
        }
        System.out.println("Total link count is : " + linksCount );
    }

    void closeConnection(){
        driver.manage().timeouts().implicitlyWait(2000,TimeUnit.MILLISECONDS);
        driver.close();
    }

    void swipDown(){
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollBy(0,700)", "");
        driver.manage().timeouts().implicitlyWait(3000,TimeUnit.MILLISECONDS);

    }
    public static void main(String[] args) {

        driver = new ChromeDriver();
        HomePage homePage = new HomePage();
        homePage.doSetUp();
//        homePage.swipDown();
        homePage.countLinks();

        homePage.closeConnection();
    }
}
