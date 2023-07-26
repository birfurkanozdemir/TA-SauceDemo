import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LoginProcess {
    public static void main(String[] args){

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

        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("demo"); //username: standard_user
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("demo123"); //password: secret_sauce
        driver.findElement(By.xpath("//input[@value='Login']")).click();
        driver.findElement(By.xpath("//h3[text()='Epic sadface: Username and password do not match any user in this service']"));

        driver.close();
    }
}
