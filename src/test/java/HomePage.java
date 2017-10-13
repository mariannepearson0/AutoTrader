import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Administrator on 13/10/2017.
 */
public class HomePage {

    @FindBy(css = "#js-header-nav > ul > li.header__nav-listing.header__nav-my-at > div > a")
    private WebElement signInButton;

    @FindBy(css = "#js-header-nav > ul > li.header__nav-listing.header__nav-my-at > a > svg")
    private WebElement signInIcon;

    @FindBy(linkText="Careers")
    private WebElement careersClick;

    @FindBy(css = "#js-editorial-placeholder > div > div > div.editorial__nav-main-image")
    private WebElement skodaReview;

    public void clickSignIn(){
        signInButton.click();
    }

    public Boolean doesIconExist(){
        return signInIcon.isDisplayed();
    }

    public WebElement clickCareers(){
        return careersClick;
    }

    public void clickSkoda(){
        skodaReview.click();
    }
}

