package experiments;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class CssSelectors {
    WebDriver driver = new ChromeDriver();

    @Test
    public void selectorsHomePage(){
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        pause(3000);
        hideFooter();
        pause(3000);
        WebElement divElements = driver
                .findElement(By.cssSelector("div[class='card-body']"));
        divElements.click();
        driver.navigate().back();
        pause(3000);
        WebElement imgTools = driver
                .findElement(By.cssSelector("img[src='/assets/Toolsqa-DZdwt2ul.jpg']"));
        System.out.println(imgTools.getTagName());
        System.out.println(imgTools.getAttribute("src"));
        pause(3000);
        driver.navigate().forward();
        pause(3000);
//        WebElement btnTextBox = driver.findElement(By.cssSelector("#item-0"));
        WebElement btnTextBox = driver
                .findElement(By.cssSelector("a[href='/text-box']"));
        btnTextBox.click();

        WebElement btnRadioButton = driver.findElement(By.linkText("Radio Button"));
        btnRadioButton.click();
        driver.navigate().back();
        driver.navigate().back();
        driver.navigate().back();
        scrollActions();

        WebElement btnBookStore = driver
                .findElement(By.cssSelector("div.category-cards a:last-child"));
        btnBookStore.click();
        pause(2000);
        driver.navigate().back();

        WebElement btnBookForms = driver
                .findElement(By.cssSelector("div.category-cards a:nth-child(2)"));
        btnBookForms.click();
        driver.navigate().back();
        WebElement textInForms = driver.findElement(By
                .cssSelector("div.category-cards a:nth-child(2) div div  div.card-body h5"));
        System.out.println(textInForms.getText());

        pause(3000);
        driver.quit();
    }

    public void pause(int milliseconds){
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void scrollActions() {
        Actions actions = new Actions(driver);
        for (int i = 0; i < 5; i++) {
            actions.scrollByAmount(0, 700).perform();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void hideFooter() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("document.querySelector('footer').style.display='none'");
    }
}
