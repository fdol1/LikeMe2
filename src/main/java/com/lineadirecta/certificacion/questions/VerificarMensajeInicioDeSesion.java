package com.lineadirecta.certificacion.questions;

import com.lineadirecta.certificacion.interactions.CerrarPublicidad;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.ui.UiInicioSesion.BTN_CERRAR_PUBLICIDAD;
import static com.lineadirecta.certificacion.ui.UiPerfilUsuario.LBL_INFO_USUARIO;
public class VerificarMensajeInicioDeSesion implements Question<Boolean> {

    private final String mensaje;

    public VerificarMensajeInicioDeSesion(String mensaje) {
        this.mensaje = mensaje;
    }

    public static VerificarMensajeInicioDeSesion exitoso(String mensaje){
        return new VerificarMensajeInicioDeSesion(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                //CerrarPublicidad.enLaPantalla(BTN_CERRAR_PUBLICIDAD),
                WaitUntil.the(LBL_INFO_USUARIO, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds()
        );
        return mensaje.equals(Text.of(LBL_INFO_USUARIO).viewedBy(actor).asString());
    }
}