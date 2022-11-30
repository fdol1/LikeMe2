package com.lineadirecta.certificacion.interactions.tap;

import com.lineadirecta.certificacion.exceptions.ObjetosException;
import com.lineadirecta.certificacion.utils.GetDriver;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;

public class BuscarElementoWebByTarget implements Interaction {
    private final By by;
    private final Target target;

    public BuscarElementoWebByTarget(By by, Target target) {
        this.by = by;
        this.target = target;
    }

    @Step("{0} taps on #target")
    public <T extends Actor> void performAs(T actor) {
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);",
                    GetDriver.as(actor).webDriver().findElement(by));
            target.resolveFor(actor).click();
        } catch (RuntimeException var3) {
            throw new ObjetosException(ObjetosException.errorSeleccionandoObjeto() + this.target.toString());
        }
    }
}
