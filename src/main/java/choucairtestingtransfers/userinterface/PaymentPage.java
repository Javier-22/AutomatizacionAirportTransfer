package choucairtestingtransfers.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PaymentPage {
    public static final Target CARD_NUMBER = Target.the("Número de tarjeta").located(By.id("cardNumber"));
    public static final Target NAME = Target.the("Nombre").located(By.id("cardName"));
    public static final Target MONTH = Target.the("mes").located(By.id("expiryDateMonth"));
    public static final Target YEAR = Target.the("Año").located(By.id("expiryDateYear"));
    public static final Target CVC = Target.the("CVC").located(By.id("seriesCode"));
    public static final Target TERMS = Target.the("Terminos").located(By.cssSelector("label[for='gt-terms-checkbox']"));
    public static final Target PAY_CONFIRM = Target.the("boton de pago").located(By.cssSelector("button.ctc-button.ctc-button--large.ctc-button--primary"));
}
