package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.exceptions.SeleccionarTallaException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

public class SeleccionarTalla implements Interaction {

    private final Target elemento;

    public SeleccionarTalla(Target elemento) {
        this.elemento = elemento;
    }

    public static SeleccionarTalla paraLaPrendaAComprar(Target elemento) {
        return Tasks.instrumented(SeleccionarTalla.class, elemento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    WaitUntil.the(elemento, WebElementStateMatchers.isVisible()).forNoMoreThan(7).seconds(),
                    Click.on(elemento)
            );
        }catch (RuntimeException ex){
            throw new SeleccionarTallaException(SeleccionarTallaException.Error(), ex);
        }
    }
}
