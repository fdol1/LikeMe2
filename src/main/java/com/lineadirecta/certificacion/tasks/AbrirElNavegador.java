package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.interactions.TakeScreenshot;
import com.lineadirecta.certificacion.utils.GetDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import java.util.logging.Logger;

public class AbrirElNavegador implements Task {

    public AbrirElNavegador() {
    }

    public static AbrirElNavegador enLikeMe(){
        return Tasks.instrumented(AbrirElNavegador.class);
    }

    @Override
    @Step("Ktronix")
    public <T extends Actor> void performAs(T actor) {
        Logger.getAnonymousLogger().info("Se abre app de LIKE ME");
        //GetDriver.as(actor).webDriver().get("https://mcstaging.likeme.com.co/customer/account/login/");
        GetDriver.as(actor).webDriver().get("https://lineadirecta-site-dev.dev.summasolutions.com.ar/customer/account/login/");
        actor.attemptsTo(
                TakeScreenshot.asEvidence()
        );
    }
}