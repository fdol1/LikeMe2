package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.utils.GetDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

import java.time.Duration;

public class SwipeByCoordinates implements Interaction {

    private int inicialX;
    private int inicialY;
    private int endX;
    private int endY;

    public SwipeByCoordinates(int inicialX, int inicialY, int endX, int endY) {
        this.inicialX = inicialX;
        this.inicialY = inicialY;
        this.endX = endX;
        this.endY = endY;
    }

    public static SwipeByCoordinates onScreem(int inicialX, int inicialY, int endX, int endY) {
        return Tasks.instrumented(SwipeByCoordinates.class, inicialX, inicialY, endX, endY);
    }

    @Override
    @SuppressWarnings("rawtypes")
    @Step("{0} swiped from (#inicialX, #inicialY) to (#endX, #endY)")
    public <T extends Actor> void performAs(T actor) {

		TouchAction t = new TouchAction(GetDriver.as(actor).appiumDriver());
		t.press(PointOption.point(inicialX,inicialY))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000)))
				.moveTo(PointOption.point(endX,endY))
				.release()
				.perform();
    }
}