package choucairtestingtransfers.tasks;

import choucairtestingtransfers.model.TransfersData;
import choucairtestingtransfers.utils.Wait;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Hit;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import static choucairtestingtransfers.userinterface.TransferSearchPage.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;



public class SearchTransfer implements Task {
    private List<TransfersData> ct;
    public SearchTransfer (List<TransfersData> data ){
        this.ct = data;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Enter.theValue(ct.get(0).getPick_up_location() + Keys.DOWN).into(PICK_UP_LOCATION),
                WaitUntil.the(SELECT_UP_LOCATION, isVisible()).forNoMoreThan(15).seconds(),
                Hit.the(Keys.ARROW_DOWN, Keys.ENTER).into(PICK_UP_LOCATION),
                Enter.theValue(ct.get(0).getPick_up_destination() + Keys.DOWN).into(PICK_UP_DESTINATION),
                WaitUntil.the(SELECT_UP_DESTINATION, isVisible()).forNoMoreThan(15).seconds(),
                Hit.the(Keys.ARROW_DOWN, Keys.ENTER).into(PICK_UP_DESTINATION),
                WaitUntil.the(PICK_UP_CALENDAR, isVisible()).forNoMoreThan(15).seconds(),
                Click.on(PICK_UP_CALENDAR)
        );
        String[] date = ct.get(0).getPick_up_date().split("/");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        Calendar today = Calendar.getInstance();
        int d,m,a;
        a= Integer.parseInt(now.toString().substring(0,4));
        m= Integer.parseInt(now.toString().substring(5,7));
        d= Integer.parseInt(now.toString().substring(8,10));
        today.set(a,m-1,d);
        Calendar pickUpDate = Calendar.getInstance();
        pickUpDate.set(Integer.parseInt(date[2]),Integer.parseInt(date[1])-1,Integer.parseInt(date[0]));
        int dias= pickUpDate.get(Calendar.DAY_OF_YEAR) - today.get(Calendar.DAY_OF_YEAR);
        Wait.Time(1000);
        Robot r = null;
        try {
            r = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        for (int i=0; i<dias;i++){
            Wait.Time(100);
            r.keyPress(KeyEvent.VK_RIGHT);
        }
        r.keyPress(KeyEvent.VK_ENTER);
        actor.attemptsTo(
                Click.on(SELECT_TIME_PICK_UP.of(ct.get(0).getPick_up_time()))
        );
        date = ct.get(0).getReturn_date().split("/");
        today.set(Integer.parseInt(date[2]),Integer.parseInt(date[1])-1, Integer.parseInt(date[0]));
        dias= today.get(Calendar.DAY_OF_YEAR) - pickUpDate.get(Calendar.DAY_OF_YEAR);

        for (int i=0; i<dias-1;i++){
            Wait.Time(100);
            r.keyPress(KeyEvent.VK_RIGHT);
        }
        r.keyPress(KeyEvent.VK_ENTER);
        int p = Integer.parseInt(ct.get(0).getPassenger());
        actor.attemptsTo(
                Click.on(RETURN_TIME.of(ct.get(0).getReturn_time()))
        );
        actor.attemptsTo(
                Click.on(PASSENGER.of(((p==1)? " "+p+" pasenger ":" "+p +" passengers "))),
                Click.on(SEARCH)
        );
    }
    public static SearchTransfer CTT(List<TransfersData> td){
        return Tasks.instrumented(SearchTransfer.class, td);
    }



}
