package choucairtestingtransfers.userinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ResultsPage {
    public static final Target BOOK_ANY_CAR = Target.the("Escojer carro").located(By.xpath("//button[.='Book Now']"));
}
