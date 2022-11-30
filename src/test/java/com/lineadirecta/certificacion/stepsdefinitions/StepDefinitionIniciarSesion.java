package com.lineadirecta.certificacion.stepsdefinitions;

import com.lineadirecta.certificacion.models.InicioDeSesionModel;
import com.lineadirecta.certificacion.questions.VerificarMensajeClaveInvalida;
import com.lineadirecta.certificacion.questions.VerificarMensajeFormatoErrado;
import com.lineadirecta.certificacion.questions.VerificarMensajeInicioDeSesion;
import com.lineadirecta.certificacion.tasks.AbrirElNavegador;
import com.lineadirecta.certificacion.tasks.IniciarSesion;
import com.lineadirecta.certificacion.tasks.IntentoDeInicioDeSesion;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class StepDefinitionIniciarSesion {

    @Given("^que el (.*) quiere iniciar sesion$")
    public void queElUsuarioQuiereIniciarSesion(String actor) {
        theActorCalled(actor).wasAbleTo(AbrirElNavegador.enLikeMe());
    }

    @When("^Ingresa sus credenciales de autenticacion$")
    public void ingresaSusCredencialesDeAutenticacion(List<InicioDeSesionModel> inicioDeSesionModels) {
        theActorInTheSpotlight().attemptsTo(IniciarSesion.conLasCredenciasDelUsuario(inicioDeSesionModels.get(0)));
    }

    @When("^Intenta iniciar sesion sin datos$")
    public void ingresaSusCredencialesDeAutenticacion() {
        theActorInTheSpotlight().attemptsTo(IntentoDeInicioDeSesion.sinCredenciales());
    }

    @Then("^Podra verificar datos sobre: (.*)$")
    public void podraVerificarDatosSobre(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarMensajeInicioDeSesion.exitoso(mensaje)));
    }

    @Then("^Podra verificar el mensaje: (.*)$")
    public void podraVerificarElMensaje(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarMensajeFormatoErrado.alIntentarIniciarSesion(mensaje)));
    }

    @Then("^Podra verificar el mensaje de error:(.*)$")
    public void podraVerificarElMensajeDeError(String mensaje) {
        theActorInTheSpotlight().should(seeThat(VerificarMensajeClaveInvalida.alIntentarIniciarSesion(mensaje)));
    }
}