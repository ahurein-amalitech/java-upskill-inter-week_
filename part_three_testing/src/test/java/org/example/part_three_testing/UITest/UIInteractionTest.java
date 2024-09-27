package org.example.part_three_testing.UITest;

import org.example.part_three_testing.webdriver.CustomWebDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(properties = "spring.profiles.active=test")
class UIInteractionTest {
    private WebDriver driver;
    private final String baseUrl = "http://localhost:8080";

    public UIInteractionTest() {
        driver = CustomWebDriver.getDriver();
    }

    @BeforeAll
    static void setUp() {
        CustomWebDriver.getDriver().manage().window().maximize();
        CustomWebDriver.getDriver().get("http://localhost:8080");
    }

    @Test
    void testProductBrowsing() {
        this.driver.get(baseUrl);
        WebElement linkElement = driver.findElement(By.cssSelector("a.btn.btn-primary.my-2"));
        String url = linkElement.getAttribute("href");
        driver.navigate().to(url);

    }

    @Test
    void getFirstProductDetails() {
        driver.navigate().to(this.baseUrl + "/products");
        List<WebElement> products = driver.findElements(By.cssSelector("div.card.mb-4.box-shadow"));
        if (!products.isEmpty()) {
            WebElement firstProduct = products.getFirst();
            WebElement viewButton = firstProduct.findElement(By.cssSelector("a.btn.btn-sm.btn-outline-secondary"));
            if (viewButton.isDisplayed()) {
                viewButton.click();
            }
        }

    }

//    @AfterAll
//    static void tearDown() {
//        CustomWebDriver.getDriver().quit();
//    }
}
