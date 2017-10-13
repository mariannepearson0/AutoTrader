import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 13/10/2017.
 */
public class Dealers {

    @FindBy(id = "postcode")
    private WebElement postcode;

    @FindBy(css = "#submit")
    private WebElement seeDealers;



    public void sendPostcode(){
        postcode.sendKeys("OX281QT");
    }

    public void dealerSearch(){
        seeDealers.click();
    }


}
