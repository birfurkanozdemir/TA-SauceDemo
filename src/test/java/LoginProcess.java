import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginProcess {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        String mainUrl = "https://www.saucedemo.com/";

        driver.get(mainUrl);
        driver.close();
    }
}
