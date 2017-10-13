import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 13/10/2017.
 */
public class DealerSearch {

    @FindBy(css = "body > section.dealerResults.js-results.dealerResults--formHidden > section.js-dealer-search-results.dealerList > ul > li:nth-child(1) > article > a > div")
    private WebElement dealerInfo;

    public String getDealerInfo(){
        return dealerInfo.getText();
    }
}
