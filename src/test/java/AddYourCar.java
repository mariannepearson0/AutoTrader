import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 13/10/2017.
 */
public class AddYourCar {

    @FindBy(css = "#js-header-nav > ul > li.test-header__nav-listing.u-float-right > div.is-signed-in > a > i > svg")
    private WebElement signInIcon;

    public Boolean doesIconExist(){
        return signInIcon.isDisplayed();
    }
}
