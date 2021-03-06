package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public String getAssertUrl(){
        return driver.getCurrentUrl();
    }

    public void waitOfElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitVisibilityOfElement(WebElement element){
        (new WebDriverWait(driver, 15))
                .until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * Method moves mouse over element
     */
    public void moveToElementAndClick(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).click().perform();
    }

    public void moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).build().perform();
    }

    public void clickOnElemenByJS(WebElement element){
        JavascriptExecutor executor = (JavascriptExecutor)driver;
        executor.executeScript("arguments[0].click();", element);
    }

    /**
     * Method scrolls down on 250 pixels.
     */
    public void scrollDown(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 700);");
    }

    public String getWindowWidth(){
        int widwowWidth = driver.manage().window().getSize().getWidth();
        String width = Integer.toString(widwowWidth);
        return width;
    }

    public String getWindowHeight(){
        int widwowHeight = driver.manage().window().getSize().getHeight();
        String height = Integer.toString(widwowHeight);
        return height;
    }

    public String getBrowserName(){
        Capabilities caps = ((RemoteWebDriver)driver).getCapabilities();
        String browserName = caps.getBrowserName();
        return browserName;
    }

    public String getBrowserVersion(){
        Capabilities caps = ((RemoteWebDriver)driver).getCapabilities();
        String browserVersion = caps.getVersion();
        return browserVersion;
    }

    public int random(){
        Random rand = new Random();
        int n =rand.nextInt();
        return n;

    }
    public static String Data() {
        Date cal = Calendar.getInstance().getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        return sdf.format(cal.getTime());
    }

    public WebDriver getDriver() {
        return driver;
    }
}
