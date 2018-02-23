import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class GoogleSearch {

    WebDriver driver;
    @BeforeMethod
    public void SetUp(){
        driver = new ChromeDriver();
        driver.get("http://www.google.com");
        driver.manage().window().maximize();
    }

    @Test
    public void SearchTest(){
        driver.findElement(By.xpath("//input[@role='combobox']")).sendKeys("testing");

        List<WebElement> suggestionsList = driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbqs_c']"));

        //System.out.println(suggestionsList.size());

        for(int i=0;i<=suggestionsList.size();i++){
            if(suggestionsList.get(i).getText().contains("testing engineers")){
                suggestionsList.get(i).click();
                break;
            }

        }


    }
}
