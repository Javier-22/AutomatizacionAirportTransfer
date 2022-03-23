package choucairtestingtransfers.stepDefinitions;

import choucairtestingtransfers.model.DetailsData;
import choucairtestingtransfers.model.PaymentData;
import choucairtestingtransfers.model.TransfersData;
import choucairtestingtransfers.questions.ShouldSeePay;
import choucairtestingtransfers.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class TransferStepDefinitions {
    @Before
     public  void sedStage(){
        OnStage.setTheStage(new OnlineCast());
    }
    @Given("the user has entered the emirates page airport transfer section")
    public  void theUserHasEnteredTheEmiratesPageAirportTransferSection() {
        OnStage.theActorCalled("user").
                wasAbleTo(OpenUp.theUrl());
    }
    @Then("the user enters a pick-up location and a destination location")
    public  void theUserEntersAPick_upLocationAndaDestinationLocation(List<TransfersData> transfersData){
        theActorInTheSpotlight().attemptsTo(SearchTransfer.CTT(transfersData));
    }
    @And("the user chooses any car")
    public void selectCar(){
        theActorInTheSpotlight().attemptsTo(Book.AnyCar());
    }

    @And("the user fill data in details and click into go to checkout with next data")
    public void theUserFillDataInDetailsAndClickIntoGoToCheckout(List<DetailsData> dd) {
        theActorInTheSpotlight().attemptsTo(Details.FillData(dd));

    }
    @And("the user fill data in payment with next data")
    public void theUserFillDataInPayment(List<PaymentData> pd) {
        theActorInTheSpotlight().attemptsTo(Payment.FillData(pd));
    }

    @When("the user must see the pay secured button ready")
    public void theUserMustSeeThePaySecuredButtonReady() {
    theActorInTheSpotlight().should(seeThat(ShouldSeePay.ButtonReady()));
    }
}
