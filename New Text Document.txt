package selenium;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class ChatGPT {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ASUS\\Downloads\\chromedriver-win64\\chromedriver.exe");
        ChromeOptions co = new ChromeOptions();
        co.setBinary("C:\\Users\\ASUS\\Downloads\\chrome-win64\\chrome.exe");
        WebDriver driver = new ChromeDriver(co);

        try {
            driver.get("https://chatgpt.com/");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
            WebElement inputBox = wait.until(
                    ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"prompt-textarea\"]")));

            // Send
            String query = "basic of selenium";
            inputBox.sendKeys(query);
            inputBox.sendKeys(Keys.RETURN);

            boolean responseReceived = false;
            long startTime = System.currentTimeMillis();
            long timeout = 6000; 

            while (System.currentTimeMillis() - startTime < timeout) {
                try {
                    // Wait
                    WebElement response = wait.until(
                            ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@id=\"__next\"]/div[1]/div/main/div[1]/div[1]/div/div/div/div/div[3]/div/div/div[2]/div/div[1]/div")));
                    if (response != null) {
                        String responseText = response.getText();
                        System.out.println("Response received from ChatGPT: " + responseText);
                        responseReceived = true;
                        break;
                    }
                } catch (Exception e) {
                    
                }
            }

            if (!responseReceived) {
                System.out.println("No response received within the timeout period.");
            }

        } finally {
            //System.err.println("hi");
            driver.quit();
        }
    }
}