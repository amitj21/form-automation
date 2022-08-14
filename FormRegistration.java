import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Form {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "/Users/Win 10/Downloads/chromedriver.exe");

        //create driver object
        WebDriver driver = new ChromeDriver();
        driver.get("https://formy-project.herokuapp.com/form");

        submitForm(driver);

        waitForBanner(driver);

        assertEquals("The form was successfully submitted", getMessage(driver));

        //driver.quit();
    }

    public static void submitForm(WebDriver driver) {
        //FIRST NAME INPUT
        WebElement firstname = driver.findElement(By.id("first-name"));
        firstname.sendKeys("John");

        //LAST NAME INPUT
        WebElement lastname = driver.findElement(By.id("last-name"));
        lastname.sendKeys("Smith");

        //JOB INPUT
        WebElement job = driver.findElement(By.id("job-title"));
        job.sendKeys("Tester");

        //EDUCATION RADIO BUTTON
        WebElement radioButton = driver.findElement(By.cssSelector("input[value=radio-button-2]"));
        radioButton.click();

        //GENDER CHECKBOX
        WebElement gender = driver.findElement(By.xpath("//*[@id=\"checkbox-1\"]"));
        gender.click();

        //EXPERIENCE DROPDOWN
        WebElement experience= driver.findElement(By.id("select-menu"));
        experience.click();
        WebElement option = driver.findElement(By.cssSelector("select > option:nth-child(2)"));
        option.click();

        //DATE PICKER
        WebElement datepicker = driver.findElement(By.id("datepicker"));
        datepicker.click();
        WebElement date = driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[5]/td[4]"));
        date.click();

        //SUBMIT
        WebElement submit = driver.findElement(By.cssSelector(".btn.btn-lg.btn-primary"));
        submit.click();
    }

    public static void waitForBanner(WebDriver driver) {
        //CONFIRM SUCCESS
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("alert")));

    }

    public static String getMessage(WebDriver driver) {
        //COMPARE MESSAGE
        String alertText = driver.findElement(By.className("alert")).getText();
        return alertText;
    }
}
