package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.edge.EdgeDriver;

public class Heading {
    public static void main(String[] args) {
        // I am using Microsoft edge for Webdriver and I provided Driver path
        System.setProperty("webdriver.edge.driver", "H:\\GOKUL\\Testing\\gok\\automation\\lib\\msedgedriver.exe");

        // Chrome does not have latest version of Chrome driver so I am using Microsoft edge 
        WebDriver driver = new EdgeDriver();
        
        // We need get Heading tag from multiple website but it getting error while executing it shows an error on Stale element like StaleElementReferenceException 
        // so I am using Try and catch block DOM Relocating Website
        try {
            // first 
            driver.get("https://freedom.press/?gad_source=1&gclid=CjwKCAjw3NyxBhBmEiwAyofDYSZ9NNpl8Q4j14grv4U2pDwIRU_fSk_GXZuFnubCEGW1FLOgxW7IjRoCbsoQAvD_BwE");
            WebElement heading1 = driver.findElement(By.xpath("/html/body/div[1]/h1"));
            String headingText1 = heading1.getText();
            System.out.println("Heading of the first website: " + headingText1);
        } catch (StaleElementReferenceException e) {
            // StaleElementReferenceException
            System.out.println("Element is stale on first and Relocating");
            WebElement heading1 = driver.findElement(By.xpath("/html/body/div[1]/h1"));
            String headingText1 = heading1.getText();
            System.out.println("Heading ofthe first website (relocated): " + headingText1);
        }

        try {
            // second 
            driver.get("https://en.wikipedia.org/wiki/Dailyhunt");
            WebElement heading2 = driver.findElement(By.id("firstHeading"));
            String headingText2 = heading2.getText();
            System.out.println("Heading of the second website:" + headingText2);
        } catch (StaleElementReferenceException e) {
            //  StaleElementReferenceException
            System.out.println("Element is stale on first and Relocating");
            WebElement heading2 = driver.findElement(By.id("firstHeading"));
            String headingText2 = heading2.getText();
            System.out.println("Heading of the second website (relocated): " + headingText2);
        }

        try {
            // third 
            driver.get("https://hig-ai-automation.in/");
            WebElement heading3 = driver.findElement(By.xpath("//*[@id=\"HIG Welcome's HIG\"]/h1"));
            String headingText3 = heading3.getText();
            System.out.println("Heading of the third website: " + headingText3);
        } catch (StaleElementReferenceException e) {
            // StaleElementReferenceException
            System.out.println("Element is stale on Third and Relocating");
            WebElement heading3 = driver.findElement(By.xpath("//*[@id=\"HIG Welcome's HIG\"]/h1"));
            String headingText3 = heading3.getText();
            System.out.println("Heading of the third website (relocated): " + headingText3);
        }

        try {
            // fourth 
            driver.get("https://www.browserstack.com/guide/api-automation-testing");
            WebElement heading4 = driver.findElement(By.xpath("//*[@id=\"singlePageArticle\"]/div[1]/div/div/div[1]/h1"));
            String headingText4 = heading4.getText();
            System.out.println("Heading of the fourth website: " + headingText4);
        } catch (StaleElementReferenceException e) {
            // StaleElementReferenceException
            System.out.println("Element is stale on fourth and Relocating");
            WebElement heading4 = driver.findElement(By.tagName("h1"));
            String headingText4 = heading4.getText();
            System.out.println("Heading of the fourth website (relocated): " + headingText4);
        }

        // Close the browser
        driver.quit();
    }
}
