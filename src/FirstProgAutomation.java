
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class FirstProgAutomation {

    static protected WebDriver driver;//creating a variable called driver instance veriable
    public static void main(String[] args){

        int random = (int)(Math.random()*10000+1);/*generate a random number, to create a unique email address
                                                   every time when you run the program*/

        String email = "emailtest" + random +"@yahoo.com";


        System.setProperty("webdriver.chrome.driver","src\\BrowserDriver\\chromedriver.exe");//call the web driver
        driver= new ChromeDriver();//call the web driver

        driver.manage().window().maximize();
        driver.get("http://demo.nopcommerce.com/");
        driver.findElement(By.linkText("Register")).click();
        driver.findElement(By.id("gender-female")).click();
        driver.findElement(By.id("FirstName")).sendKeys("Dana");

        driver.findElement(By.id("LastName")).sendKeys("Ciutulin");

        Select droplist = new Select(driver.findElement(By.name("DateOfBirthDay")));//create an object for dropdown
        droplist.selectByVisibleText("1");//select from dropdown 23 value

        Select droplist1 = new Select(driver.findElement(By.name("DateOfBirthMonth")));//create an object for dropdown
        droplist1.selectByVisibleText("January");//select from dropdown 23 value

        Select droplist2 = new Select(driver.findElement(By.name("DateOfBirthYear")));//create an object for dropdown
        droplist2.selectByVisibleText("1913");//select from dropdown 23 value


        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Company")).sendKeys("Companytest");

        driver.findElement(By.id("Newsletter")).click();

        driver.findElement(By.id("Password")).sendKeys("123456");
        driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");

        driver.findElement(By.id("register-button")).click();
        driver.findElement(By.name("register-continue")).click();

        String expectedMsg = "My account";
        String actualMsg = driver.findElement(By.xpath("//*[@class='ico-account']")).getText();

        if (actualMsg.equals(expectedMsg)){
            System.out.println("Test case is passed");
        }
            else {
            System.out.println("Test case is failed");
        }
        driver.close();


    }
}
