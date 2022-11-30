package com.lineadirecta.certificacion.interactions.tap;

import com.lineadirecta.certificacion.exceptions.ObjetosException;
import com.lineadirecta.certificacion.interactions.Scroll;
import com.lineadirecta.certificacion.utils.GetDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.Step;

public class TapByTarget implements Interaction {
	private final Target target;

	public TapByTarget(Target target) {
		this.target = target;
	}

	@Step("{0} taps on #target")
	public <T extends Actor> void performAs(T actor) {
		actor.attemptsTo(new Performable[]{Scroll.on(this.target)});
		try {
			(new TouchAction(GetDriver.as(actor).appiumDriver()))
					.tap((TapOptions)(new TapOptions()).withElement((new ElementOption()).withElement(this.target.resolveFor(actor)
							.getWrappedElement()))).perform().release();
		} catch (RuntimeException var3) {
			throw new ObjetosException(ObjetosException.errorSeleccionandoObjeto() + this.target.toString());
		}
	}
}