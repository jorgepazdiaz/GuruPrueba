package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomeTelecomPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Add Customer") private WebElement lnk_AddCustomer;
    @FindBy(linkText = "Add Tariff Plan to Customer") private WebElement lnk_AddTarifa;


    public HomeTelecomPage(WebDriver d) {
        driver=d;
        wait= new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void ClickAddCustomer(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_AddCustomer));
        lnk_AddCustomer.click();
    }

    public void ClickAddTarifa(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_AddTarifa));
        lnk_AddTarifa.click();
    }
}
