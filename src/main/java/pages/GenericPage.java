package pages;

import java.io.File;

import org.openqa.selenium.WebDriver;

public class GenericPage extends BasePageImpl {

	public GenericPage() {
		url = "genericPage";
	}

	public GenericPage(WebDriver driver) {
		super(driver);
	}

	public static final String UPLOAD_DIRECTORY_PATH = System.getProperty("user.dir") + File.separator + "src"
			+ File.separator + "test" + File.separator + "resources" + File.separator + "DataFiles" + File.separator;
}
