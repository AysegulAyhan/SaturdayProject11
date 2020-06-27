import com.google.common.annotations.VisibleForTesting;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;
import org.junit.Assert;

public class Account {
    public static void main(String[] args) throws InterruptedException {


        System.setProperty("webdriver.chrome.driver","C:\\Selenium dependency\\drivers\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.navigate().to(" http://a.testaddressbook.com/sign_in");
        WebElement session_email = driver.findElement(By.id("session_email"));
        session_email.sendKeys("aa@gmail.com");
        WebElement session_password = driver.findElement(By.id("session_password"));
        session_password.sendKeys("333286589");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.linkText("Addresses")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@data-test='create']")).click();
        Thread.sleep(3000);
        driver.findElement(By.id("address_first_name")).sendKeys("Fernando");
        driver.findElement(By.id("address_last_name")).sendKeys("Torres");
        driver.findElement(By.id("address_street_address")).sendKeys("Anfield Rd");
        driver.findElement(By.id("address_secondary_address")).sendKeys("Anfield");
        driver.findElement(By.cssSelector("input[id='address_city']")).sendKeys("Liverpool");
        Select select=new Select(driver.findElement(By.id("address_state")));
        List<WebElement> options = select.getOptions();
        Random random= new Random();
        int i=random.nextInt(options.size()+1);
       // int a = new Random().nextInt(options.size());
        select.selectByIndex(i);
        Thread.sleep(1000);
        driver.findElement(By.id("address_zip_code")).sendKeys("L4 0TH");
       // driver.findElement(By.xpath("//a[@data-test='create']")).click();
        driver.findElement(By.id("address_country_us")).click();
        driver.findElement(By.id("address_birthday")).sendKeys("03/20/1984");
        driver.findElement(By.id("address_age")).sendKeys("36");
        driver.findElement(By.id("address_website")).sendKeys("https://www.google.com/");
        driver.findElement(By.id("address_phone")).sendKeys("8625747878");
        driver.findElement(By.id("address_interest_climb")).click();
        driver.findElement(By.id("address_interest_dance")).click();
        driver.findElement(By.id("address_note")).sendKeys("Never Back Down");
        driver.findElement(By.xpath("//input[@value='Create Address']")).click();
        try{
        WebElement actualName = driver.findElement(By.xpath("//*[contains(text(),'Fernando')]"));
        Assert.assertEquals("Fernando",actualName.getText());
        }catch (NoSuchElementException e){
            System.out.println("There is no name such as Fernando");
        }
        try{
            WebElement actualLastName = driver.findElement(By.xpath("//*[contains(text(),'Torres')]"));
            Assert.assertEquals("Torres",actualLastName.getText());
        }catch (NoSuchElementException e){
        System.out.println("There is no last name such as Torres");
        }

        driver.findElement(By.xpath("//a[@data-test='addresses']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[contains(text(),'Edit')]")).click();
        Thread.sleep(1000);
        WebElement address_first_name = driver.findElement(By.id("address_first_name"));
        address_first_name.clear();
        address_first_name.sendKeys("Peter");
        WebElement address_last_name = driver.findElement(By.id("address_last_name"));
        address_last_name.clear();
        address_last_name.sendKeys("Crouch");
        driver.findElement(By.xpath("//input[@value='Update Address']")).click();
        driver.findElement(By.partialLinkText("Addresses")).click();
        Thread.sleep(1000);
        driver.findElement(By.partialLinkText("Destroy")).click();
        driver.switchTo().alert().accept();


    }}
