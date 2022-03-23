package choucairtestingtransfers.tasks;

import choucairtestingtransfers.userinterface.ResultsPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

public class Book implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(ResultsPage.BOOK_ANY_CAR)
        );
    }
    public static Book AnyCar(){
        return Tasks.instrumented(Book.class);
    }
}
