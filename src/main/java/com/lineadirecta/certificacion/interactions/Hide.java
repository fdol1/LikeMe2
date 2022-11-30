package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.utils.GetDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.conditions.Check;

public class Hide implements Interaction {

    public Hide(){}

    public static Hide Keyboard(){

        return new Hide();
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        if(ComandosCapabilities.isiOS(actor)){
            actor.attemptsTo(new Performable[]{Check.whether(BotonesiOS.BTN_ACEPTAR.resolveFor(actor).isCurrentlyVisible())
                    .andIfSo(
                            new Performable[]{Tap.on(BotonesiOS.BTN_ACEPTAR)}
            )});
        }else{
            GetDriver.as(actor).androidDriver().hideKeyboard();
        }
    }
}
