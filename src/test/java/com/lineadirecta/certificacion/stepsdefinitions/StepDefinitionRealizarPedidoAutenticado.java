package com.lineadirecta.certificacion.stepsdefinitions;

import com.lineadirecta.certificacion.models.RealizarCompraModel;
import com.lineadirecta.certificacion.questions.VerificarProducto;
import com.lineadirecta.certificacion.tasks.AgregarAlCarrito;
import com.lineadirecta.certificacion.tasks.RealizarPedido;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepDefinitionRealizarPedidoAutenticado {

    @Given("^que requiero seleccionar mis productos$")
    public void queRequieroSeleccionarMisProductos(List<RealizarCompraModel> realizarCompraModelList) {
        theActorInTheSpotlight().attemptsTo(RealizarPedido.autenticadoEnLaApp(realizarCompraModelList.get(0)));
    }

    @When("^selecciono detalles de la compra$")
    public void seleccionoDetallesDeLaCompra(List<RealizarCompraModel> realizarCompraModelList) {
        theActorInTheSpotlight().attemptsTo(AgregarAlCarrito.elProductoEnPantalla(realizarCompraModelList.get(0)));
    }

    @Then("^podra verificar que el precio total de la compra sea:(.*)$")
    public void podraVerificarQueElProductoSeEncuentreEnElCarrito(String totalCompra) {
        theActorInTheSpotlight().should(seeThat(VerificarProducto.enElCarrito(totalCompra)));
    }
}