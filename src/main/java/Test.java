import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();

        // Open URL
        driver.get("https://www.tpointtech.com/");

        // Maximize the browser window
        driver.manage().window().maximize();
        Thread.sleep(2000);

        // Click on dark mode toggle (if present)
        driver.findElement(By.id("dark-mode-icon")).click();
        Thread.sleep(1000);

        // Click on the first menu link under "link" div
        driver.findElement(By.xpath("//*[@id='link']/div/ul/li[1]/a")).click();
        Thread.sleep(2000);

        // Quit browser
        driver.quit();
    }
}
