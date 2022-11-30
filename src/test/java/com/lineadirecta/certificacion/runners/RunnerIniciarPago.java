package com.lineadirecta.certificacion.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@CucumberOptions(
        features = {"src/test/resources/features/IniciarPago.feature"},
        tags = {"@RealizarPagoConEfectivo"},
        glue = {"com.lineadirecta.certificacion.stepsdefinitions"},
        snippets = SnippetType.CAMELCASE
)
@RunWith(CucumberWithSerenity.class)
public class RunnerIniciarPago {
}