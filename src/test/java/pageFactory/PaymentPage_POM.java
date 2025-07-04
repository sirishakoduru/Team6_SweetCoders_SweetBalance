package pageFactory;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import driver.DriverFactory;
import utilities.CommonMethods;

public class PaymentPage_POM {

	private WebDriver driver = null;
	@FindBy(xpath = "//*[contains(@class,'inline-flex items-center justify')]") private WebElement submitbttn;
	@FindBy(xpath = "//*[contains(@class,'text-xs text-red-500 mt-1')]") private List<WebElement> listValidationMsgs;
	//@FindBy(xpath = "//*[contains(text(),'Please correct the errors')]") private WebElement errorMsg;
	//@FindBy(xpath = "//*[@aria-label='Credit or debit card number']") private WebElement cardNumberDetail;
	@FindBy(xpath = "//*[@placeholder='4242 4242 4242 4242']") private WebElement cardNumberDetail;
	@FindBy(xpath = "//*[contains(@class,'flex items-center text-red-500 text-sm mt-2')]") private WebElement errorMsg;
	@FindBy(xpath = "//*[@aria-label='Credit or debit card expiration date']") private WebElement expiryDateDetail;
	@FindBy(xpath = "//*[@placeholder='CVC']") private WebElement CVCdetail;
//	@FindBy(xpath = "") private WebElement ;
	
	public PaymentPage_POM() {
		this.driver = DriverFactory.getDriver();
		PageFactory.initElements(driver, this);
	}
	
	public void clicksubmitbttn() {
		submitbttn.click();
	}
	
	public List<String> getListValidationMsg() {
		List<String> itemTexts = new ArrayList<String>();
		for (WebElement item : listValidationMsgs) {
			itemTexts.add(item.getText());
		}
		return itemTexts;
	}
	
	public String geterrorMsgText() {
		return errorMsg.getText();
	}
	public void enterCardNumber(String cardNumber) {
		CommonMethods.waitForElementVisibilityOf(cardNumberDetail);
		cardNumberDetail.sendKeys(cardNumber);
	}
	public void enterExpiryDate(String expiryDate) {
		CommonMethods.waitForElementVisibilityOf(expiryDateDetail);
		expiryDateDetail.sendKeys(expiryDate);
	}
	public void enterCVCdetail(String cvc) {
		CommonMethods.waitForElementVisibilityOf(CVCdetail);
		CVCdetail.sendKeys(cvc);
	}
}
