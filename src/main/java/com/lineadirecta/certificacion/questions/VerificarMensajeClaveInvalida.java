package com.lineadirecta.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.ui.UiInicioSesion.LBL_CLAVE_INVALIDA;

public class VerificarMensajeClaveInvalida implements Question<Boolean> {

    private final String mensaje;

    public VerificarMensajeClaveInvalida(String mensaje) {
        this.mensaje = mensaje;
    }

    public static VerificarMensajeClaveInvalida alIntentarIniciarSesion(String mensaje){
        return new VerificarMensajeClaveInvalida(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_CLAVE_INVALIDA, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds()
        );
        return mensaje.equals(Text.of(LBL_CLAVE_INVALIDA).viewedBy(actor).asString());
    }
}