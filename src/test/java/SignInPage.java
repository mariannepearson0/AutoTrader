import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Administrator on 13/10/2017.
 */
public class SignInPage {

    private Spreadsheet spreadsheet;

    @FindBy(id = "js-social__signup-tab")
    private WebElement signUpButton;

    @FindBy(css = "#email")
    private WebElement signUpemail;

    @FindBy(css = "#password")
    private WebElement signUpPW;

    @FindBy(id = "social--signup--submit")
    private WebElement signUpSubmit;

    @FindBy(id = "signin-email")
    private WebElement signInemail;

    @FindBy(id = "signin-password")
    private WebElement signInPW;

    @FindBy(id = "signInSubmit")
    private WebElement signInSubmit;


    public void clickSignUp(){
        signUpButton.click();
    }

    public void loginInfo(){
        spreadsheet = new Spreadsheet("src/test/inputDataAutoTrader.xlsx");
        List<String> rowstuff = spreadsheet.readRow(1,"Sheet1");
        signUpemail.sendKeys(rowstuff.get(0) + "@hotmail.com");
        signUpPW.sendKeys(rowstuff.get(1));
    }

    public void submitSignUp(){
        signUpSubmit.click();
        spreadsheet.writeRow(1,"Sheet1",0, "src/test/inputDataAutoTrader.xlsx");
    }

    public void enterDetails(){
        signInemail.sendKeys("00000@hotmail.com");
        signInPW.sendKeys("password1");
    }

    public void submitSignIn(){
        signInSubmit.click();
    }

}
