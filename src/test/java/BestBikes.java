import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 13/10/2017.
 */
public class BestBikes {
    @FindBy(css = "body > div.winning-bike.outer.outer2 > div > div:nth-child(2) > p > a")
    private WebElement theBestBike;

    public String getBestBike(){
        return theBestBike.getText();
    }
}

