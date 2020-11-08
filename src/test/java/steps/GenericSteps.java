package steps;

import net.serenitybdd.core.Serenity;

import java.util.ArrayList;

public class GenericSteps {

    public static void switchToTabByIndex(int index){
        ArrayList<String> newTab = new ArrayList<String>(Serenity.getWebdriverManager().getCurrentDriver().getWindowHandles());
        Serenity.getWebdriverManager().getCurrentDriver().switchTo().window(newTab.get(index));
    }
}
