package com.lineadirecta.certificacion.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static com.lineadirecta.certificacion.ui.UiResumenCompra.LBL_TOTAL_COMPRA;


public class VerificarProducto implements Question<Boolean> {

    private final String totalCompra;

    public VerificarProducto(String totalCompra) {
        this.totalCompra = totalCompra;
    }

    public static VerificarProducto enElCarrito(String totalCompra){
        return new VerificarProducto(totalCompra);
    }

    @Override
    public Boolean answeredBy(Actor actor) {

        actor.attemptsTo(
                WaitUntil.the(LBL_TOTAL_COMPRA, WebElementStateMatchers.isVisible()).forNoMoreThan(10).seconds()
        );
        System.out.println(totalCompra + " *** " + Text.of(LBL_TOTAL_COMPRA).viewedBy(actor).asString());

        return totalCompra.equals(Text.of(LBL_TOTAL_COMPRA).viewedBy(actor).asString());
    }
}