package com.lineadirecta.certificacion.tasks;

import com.lineadirecta.certificacion.exceptions.IntentoDeInicioDeSesionException;
import com.lineadirecta.certificacion.interactions.CerrarPublicidad;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.ui.UiInicioSesion.*;

public class IntentoDeInicioDeSesion implements Task {

    public IntentoDeInicioDeSesion() {
    }

    public static IntentoDeInicioDeSesion sinCredenciales(){
        return Tasks.instrumented(IntentoDeInicioDeSesion.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            actor.attemptsTo(
                    //CerrarPublicidad.enLaPantalla(BTN_CERRAR_PUBLICIDAD),
                    //CerrarPublicidad.enLaPantalla(BTN_ACEPTAR_USO_DE_COOKIES),
                    WaitUntil.the(TXT_USUARIO, WebElementStateMatchers.isEnabled()).forNoMoreThan(7).seconds(),
                    Click.on(BTN_INICIAR_SESION)
            );
        }catch (RuntimeException ex){
            throw new IntentoDeInicioDeSesionException(IntentoDeInicioDeSesionException.Error(),ex);
        }
    }
}