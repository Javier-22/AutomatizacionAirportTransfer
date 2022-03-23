package choucairtestingtransfers.tasks;

import choucairtestingtransfers.model.PaymentData;
import choucairtestingtransfers.utils.Wait;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.actions.Switch;
import org.openqa.selenium.Keys;

import java.util.List;

import static choucairtestingtransfers.userinterface.PaymentPage.*;

public class Payment implements Task {

    private List<PaymentData> pd;

    public Payment(List<PaymentData> pd){
        this.pd = pd;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Switch.toFrame("ct-secure-payment"),
                Enter.theValue(pd.get(0).getCard_number()).into(CARD_NUMBER),
                Enter.theValue(pd.get(0).getName()).into(NAME).thenHit(Keys.TAB)
        );
        Wait.Time(1000);
        for (int i =0 ; i< Integer.parseInt(pd.get(0).getMonth()); i++){
            Wait.Time(200);
            actor.attemptsTo(
                    Hit.the(Keys.ARROW_DOWN).into(MONTH)
            );
        }
        Wait.Time(500);
        int year = Integer.parseInt(pd.get(0).getYear().substring(2,4));
        for (int i =21 ; i< year; i++){
            Wait.Time(200);
            actor.attemptsTo(
                    Hit.the(Keys.ARROW_DOWN).into(YEAR)
            );
        }
        actor.attemptsTo(
                Enter.theValue(pd.get(0).getCvc()).into(CVC)
        );
        Serenity.getWebdriverManager().getWebdriver().switchTo().defaultContent();
        actor.attemptsTo(
                Click.on(TERMS)
        );

    }
    public static Payment FillData(List<PaymentData> pd){
        return Tasks.instrumented(Payment.class, pd);
    }
}
