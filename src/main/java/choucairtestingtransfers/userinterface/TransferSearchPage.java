package choucairtestingtransfers.userinterface;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TransferSearchPage {
    //public  static final Target ONE_WAY =             Target.the("").located(By.cssSelector("//span[.='One way']/parent::label[@class='ct-radio-option']"));
    public static  final Target PICK_UP_LOCATION = Target.the("Lugar de recogida").locatedBy("#input-pickup");
    public static  final Target SELECT_UP_LOCATION =Target.the("Seleccionar lugar").locatedBy("//strong[.=' Airport ']");
    public static  final Target PICK_UP_DESTINATION=   Target.the("Lugar de destino").located(By.id("input-dropoff"));
    public static  final Target SELECT_UP_DESTINATION = Target.the("Seleccionar lugar").locatedBy("//input[@id='input-dropoff']/parent::div//strong[text()=' Airport ']");
    public static  final Target PICK_UP_CALENDAR = Target.the("Calendario").located(By.cssSelector("#ct-pickup-calendar"));
    public static final Target SELECT_DATE = Target.the("").locatedBy("#{0}");
    public static  final Target PICK_UP_TIME=Target.the("").located(By.id("#ct-time-picker-pick-up-input"));
    public static final Target SELECT_TIME_PICK_UP = Target.the("Seleccionar hora recogida").locatedBy("//ul[@id='ct-time-picker-pick-up-option-container']//li[@aria-label='{0}']");




    public static  final Target SEARCH=           Target.the("Buscar").located(By.cssSelector("button[type='submit']"));
    public static  final Target RETURN_TIME=           Target.the("Seleccionar hora de dejada").locatedBy("//ul[@id='ct-time-picker-drop-off-option-container']//li[@aria-label='{0}']");
    public static  final Target PASSENGER= Target.the("").locatedBy("//li[.='{0}']");


}
