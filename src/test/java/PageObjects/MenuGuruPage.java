package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuGuruPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(linkText = "Telecom Project") private WebElement lnk_Telecom;

    public MenuGuruPage(WebDriver d) {
        driver=d;
        wait= new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }
    public void ClickTelecom(){
        wait.until(ExpectedConditions.elementToBeClickable(lnk_Telecom));
        lnk_Telecom.click();
    }
}
