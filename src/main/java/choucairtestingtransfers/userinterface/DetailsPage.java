package choucairtestingtransfers.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class DetailsPage {
    public static final Target NAME = Target.the("Nombre").located(By.id("gt-customer-name"));
    public static final Target EMAIL = Target.the("Email").located(By.id("gt-customer-email"));
    public static final Target CONFIRM_EMAIL = Target.the("Confirmar email").located(By.id("gt-customer-confirm-email"));
    public static final Target COUNTRY_CODE = Target.the("Código de país").located(By.id("gt-customer-country-code"));
    public static final Target SELECT_CODE = Target.the("Código de país").locatedBy(("//option[contains(text(),'{0}')]"));
    public static final Target PHONE = Target.the("Teléfono").located(By.id("gt-customer-mobile-number"));
    public static final Target PICK_UP_NUMBER = Target.the("numero de vuelo de ida").located(By.id("gt-pickup-flight-number"));
    public static final Target RETURN_NUMBER = Target.the("numero de vuelo de ida").located(By.id("gt-return-pickup-flight-number"));
    public static final Target GO_TO_CHECKOUT= Target.the("numero de vuelo de vuelta").located(By.cssSelector("button.ctc-button.ctc-button--full.ctc-button--primary"));

}
