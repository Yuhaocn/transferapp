package com.transfer.transfer;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TransferApplicationTests {

    private WebDriver driver;
    private static final String BASE_URL = "http://localhost:8080"; 

    @Before
    public void setUp() {
        // Set up WebDriver
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        // Close the WebDriver after each test
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void testLoginAndTransaction() {
        // Navigate to the login page
        driver.get(BASE_URL);

        // Enter a valid username in the login form
        WebElement usernameInput = driver.findElement(By.id("username"));
        usernameInput.sendKeys("user3");

        // Click the login button
        WebElement loginButton = driver.findElement(By.xpath("//button[text()='Login']"));
        loginButton.click();

        // Wait for the user to be logged in 
        // Perform assertions based on the application behavior
        assertTrue(driver.getCurrentUrl().startsWith(BASE_URL + "/dashboard"));

        // Navigate to the transaction page
        driver.get(BASE_URL + "/transaction");

        // Perform a transaction (replace these with your actual UI elements)
        WebElement receiverInput = driver.findElement(By.id("receiver"));
        receiverInput.sendKeys("user2");

        WebElement amountInput = driver.findElement(By.id("amount"));
        amountInput.sendKeys("255");

        WebElement sendButton = driver.findElement(By.xpath("//button[text()='Send Money']"));
        sendButton.click();

        // Wait for the transaction to complete
        // Perform assertions based on the application behavior
        WebElement successMessage = driver.findElement(By.id("transactionSuccess"));
        assertEquals("Transaction successful", successMessage.getText());
    }
}

