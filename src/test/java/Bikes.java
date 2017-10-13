import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 13/10/2017.
 */
public class Bikes {

    @FindBy(css = "#js-header-nav > ul > li:nth-child(3) > a")
    private WebElement bikeReviews;

    @FindBy(css = "#top-nav__reviews > li:nth-child(2) > a")
    private WebElement bestBike;

    public WebElement getBikeReviews(){
        return bikeReviews;
    }
    public WebElement getBestBike(){
        return bestBike;
    }
}
