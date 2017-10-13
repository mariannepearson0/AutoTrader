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

    @FindBy(css = "[href = '/content/car-reviews/skoda-rapid-review-hatchback-2017']")
    private WebElement skodaReview;

    @FindBy(css="#js-channel-nav > ul.other-vehicles__list > li:nth-child(4) > a")
    private WebElement bikes;

    @FindBy(css = "body > main > div > section.is-non-critical > section.alt-search__nav.t-row > a:nth-child(3) > figure")
    private WebElement localDealers;

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

    public void clickBikes(){
        bikes.click();
    }

    public void clickDealers(){
        localDealers.click();
    }
}

