package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NroCustomerPage {
    private WebDriver driver;
    private WebDriverWait wait;

    protected static String orden;

    @FindBy(tagName = "h3") private WebElement lbl_Orden;
    @FindBy(xpath = "//*[@id=\"main\"]/div/div/ul/li/a") private WebElement btn_Home;

    public NroCustomerPage(WebDriver d) {
        driver=d;
        wait= new WebDriverWait(driver,30);
        PageFactory.initElements(driver,this);
    }

    public void CapturarOrden(){
        wait.until(ExpectedConditions.visibilityOf(lbl_Orden));
        orden=lbl_Orden.getText();
        System.out.println("El numero de Orden de cliente es: "+orden);
    }

    public void VolverHome(){
        btn_Home.click();
    }
}
