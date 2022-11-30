package com.lineadirecta.certificacion.stepsdefinitions;

import com.lineadirecta.certificacion.models.DatosCompraModel;
import com.lineadirecta.certificacion.tasks.IniciarPago;
import com.lineadirecta.certificacion.tasks.LlenarDatosDeCompra;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;

import java.util.List;

import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepDefinitionIniciarPago {

    @Given("^que el usuario ingresa hasta el formulario de pagos$")
    public void queElUsuarioIngresaHastaElFormularioDePagos() {
        theActorInTheSpotlight().attemptsTo(IniciarPago.deLosProductos());
    }


    @When("^ingresa los datos de compra$")
    public void ingresasLosDatosDeCompra(List<DatosCompraModel> datosCompraModelList) {
        theActorInTheSpotlight().attemptsTo(LlenarDatosDeCompra.paraPagar(datosCompraModelList.get(0)));
    }
}
