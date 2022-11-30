package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.exceptions.AgregarCantidadException;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;

import static com.lineadirecta.certificacion.ui.UiCarrito.BTN_MAS;

public class AgregarCantidad implements Interaction {

    private final String cantidad;

    public AgregarCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public static AgregarCantidad delProductoSeleccionado(String cantidad) {
        return Tasks.instrumented(AgregarCantidad.class, cantidad);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        try {
            if(!cantidad.equals("1")){

                for (int i = 1; i<Integer.parseInt(cantidad); i++){
                    actor.attemptsTo(
                            Click.on(BTN_MAS)
                    );
                }
            }
        }catch (RuntimeException ex){
            throw new AgregarCantidadException(AgregarCantidadException.Error(), ex);
        }
    }
}
