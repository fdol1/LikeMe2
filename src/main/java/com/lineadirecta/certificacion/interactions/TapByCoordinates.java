package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.utils.GetDriver;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.PointOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Tasks;
import net.thucydides.core.annotations.Step;

public class TapByCoordinates implements Interaction {

    private int x;
    private int y;

    public TapByCoordinates(int x, int y) {
        this.x = x;
        this.y = y;
    }

	public static TapByCoordinates onScreen(int x, int y){
		return Tasks.instrumented(TapByCoordinates.class, x,y);
	}

    @Override
    @SuppressWarnings("rawtypes")
    @Step("{0} taps on coordinate (#x, #y)")
    public <T extends Actor> void performAs(T actor) {
        new TouchAction((PerformsTouchActions) GetDriver.as(actor).appiumDriver())
                .tap(new TapOptions().withPosition(new PointOption<>().withCoordinates(x, y)))
                .perform()
                .release();

    }

}
