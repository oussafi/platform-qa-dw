package pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import org.openqa.selenium.WebDriver;

public class GenericPage extends BasePageImpl {

	public GenericPage() {
		url = "genericPage";
	}

	public GenericPage(WebDriver driver) {
		super(driver);
	}

}
