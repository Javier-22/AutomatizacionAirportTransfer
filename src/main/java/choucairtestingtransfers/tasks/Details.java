package choucairtestingtransfers.tasks;

import choucairtestingtransfers.model.DetailsData;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import java.util.List;

import static choucairtestingtransfers.userinterface.DetailsPage.*;

public class Details implements Task {
    private List<DetailsData> dd;

    public Details(List<DetailsData> dd){
        this.dd = dd;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Enter.theValue(dd.get(0).getName()).into(NAME),
                Enter.theValue(dd.get(0).getEmail()).into(EMAIL),
                Enter.theValue(dd.get(0).getConfirm_email()).into(CONFIRM_EMAIL),
                Click.on(COUNTRY_CODE),
                Click.on(SELECT_CODE.of(dd.get(0).getCountry_code())),
                Enter.theValue(dd.get(0).getPhone()).into(PHONE),
                Enter.theValue(dd.get(0).getPick_up_number()).into(PICK_UP_NUMBER),
                Enter.theValue(dd.get(0).getReturn_number()).into(RETURN_NUMBER),
                Click.on(GO_TO_CHECKOUT)
        );
    }
    public static Details FillData(List<DetailsData> dd){
        return Tasks.instrumented(Details.class, dd);
    }
}
