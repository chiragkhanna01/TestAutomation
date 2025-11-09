import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TestWeb {
    public static void main(String[] args) throws InterruptedException {
        // Launch Chrome browser
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://bookcart.azurewebsites.net/");
        Thread.sleep(2000);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Optional: toggle dark mode
        try {
            driver.findElement(By.xpath("/html/body/app-root/app-nav-bar/mat-toolbar/mat-toolbar-row/div[3]/button[2]/span[2]")).click();
            Thread.sleep(2000);
        } catch (Exception e) {
            System.out.println("Dark mode toggle not found, continuing...");
        }

        // Click Register button
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Register']"))).click();
        Thread.sleep(2000);

        // Fill registration form
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='firstName']"))).sendKeys("Chirag");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@formcontrolname='lastName']")).sendKeys("Khanna");
        Thread.sleep(2000);

        String username = "uniqueusername" + System.currentTimeMillis(); // unique username each run
        driver.findElement(By.xpath("//input[@formcontrolname='userName']")).sendKeys(username);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("StrongPassword1");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//input[@formcontrolname='confirmPassword']")).sendKeys("StrongPassword1");
        Thread.sleep(2000);

        // Select Male radio button
        driver.findElement(By.xpath("//mat-radio-button[@value='Male']")).click();
        Thread.sleep(2000);

        // Submit form
        driver.findElement(By.xpath("//span[text()='Register']")).click();
        Thread.sleep(3000);

        // Wait for login form to appear
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='username']")));

        // Fill login form
        driver.findElement(By.xpath("//input[@formcontrolname='username']")).sendKeys(username);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@formcontrolname='password']")).sendKeys("StrongPassword1");
        Thread.sleep(2000);

        // Click Login button
        driver.findElement(By.xpath("//span[text()='Login']")).click();
        Thread.sleep(3000);

        // Quit browser
        driver.quit();
    }
}
