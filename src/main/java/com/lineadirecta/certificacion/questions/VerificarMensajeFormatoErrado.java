package com.lineadirecta.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.ui.UiInicioSesion.LBL_MENSAJE_FORMATO_ARRADO;
public class VerificarMensajeFormatoErrado implements Question<Boolean> {

    private final String mensaje;

    public VerificarMensajeFormatoErrado(String mensaje) {
        this.mensaje = mensaje;
    }

    public static VerificarMensajeFormatoErrado alIntentarIniciarSesion(String mensaje){
        return new VerificarMensajeFormatoErrado(mensaje);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_MENSAJE_FORMATO_ARRADO, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds()
        );
        return mensaje.equals(Text.of(LBL_MENSAJE_FORMATO_ARRADO).viewedBy(actor).asString());
    }
}