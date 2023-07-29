import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class LoginProcess {
    public static void main(String[] args) throws IOException {

        System.setProperty("webdriver.chrome.driver", ".\\src\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String mainUrl = "https://www.saucedemo.com/";
        driver.manage().window().maximize();
        driver.get(mainUrl);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        String originTitle = "Swag Labs";
        String currentTitle = driver.getTitle();;
        if (currentTitle.contentEquals(originTitle)){

            System.out.println("Title verified");
        }
        else
            System.out.println("Title not verified");

        String username = UUID.randomUUID().toString();
        System.out.println("Random username: " + username);

        String password = UUID.randomUUID().toString();
        System.out.println("Random password: " + password);

        driver.findElement(By.id("user-name")).sendKeys(username); //username: standard_user
        driver.findElement(By.cssSelector("#password")).sendKeys(password); //password: secret_sauce
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.findElement(By.xpath("//h3[contains(text(),'Username and password do not match')]"));

        File screenShot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        File img = new File(".\\src\\images\\ss.png");
        FileUtils.copyFile(screenShot, img);

        //driver.close();
        driver.quit();
    }
}
