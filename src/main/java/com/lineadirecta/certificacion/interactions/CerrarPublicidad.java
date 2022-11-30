package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.exceptions.CerrarPublicidadException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.targets.Target;

import java.util.logging.Logger;

import static com.lineadirecta.certificacion.ui.UiInicioSesion.BTN_CERRAR_PUBLICIDAD;

public class CerrarPublicidad implements Interaction {

    private final Target elemento;

    public CerrarPublicidad(Target elemento) {
        this.elemento = elemento;
    }

    public static CerrarPublicidad enLaPantalla(Target elemento) {
        return Tasks.instrumented(CerrarPublicidad.class, elemento);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            do {
                actor.attemptsTo(
                        Click.on(elemento)
                );
                break;
            }while (!elemento.resolveFor(actor).isClickable());
            Logger.getAnonymousLogger().info("Elemento de publicidad cerrado");
        }catch (RuntimeException ex){
            throw new CerrarPublicidadException(CerrarPublicidadException.Error(), ex);
        }
    }
}
