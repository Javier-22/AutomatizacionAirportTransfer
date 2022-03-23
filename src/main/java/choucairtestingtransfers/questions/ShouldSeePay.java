package choucairtestingtransfers.questions;

import choucairtestingtransfers.userinterface.PaymentPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

public class ShouldSeePay implements Question<Boolean> {
    @Override
    public Boolean answeredBy(Actor actor) {
        boolean res;
        if (PaymentPage.PAY_CONFIRM.resolveFor(actor).isClickable()){
            res = true;
        }else{
            res = false;
        }
        return res;
    }
    public static ShouldSeePay ButtonReady(){
        return new ShouldSeePay();
    }
}
