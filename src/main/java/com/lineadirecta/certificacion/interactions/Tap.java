package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.interactions.tap.TapByElement;
import com.lineadirecta.certificacion.interactions.tap.TapByTarget;
import com.lineadirecta.certificacion.interactions.tap.TapByText;
import com.lineadirecta.certificacion.interactions.tap.TapOnVisibleObject;
import com.lineadirecta.certificacion.utils.ComandosScroll;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.WebElement;

public class Tap {
	private Tap() {
		throw new IllegalStateException("Error en tap");
	}

	public static Performable on(Target target) {
		return Tasks.instrumented(TapByTarget.class, target);
	}
	
	public static TapByCoordinates on(int x, int y) {
		return Tasks.instrumented(TapByCoordinates.class, x, y);
	}

	public static TapOnVisibleObject siElElementoEsVisible(Target target){
		return (TapOnVisibleObject) Tasks.instrumented(TapOnVisibleObject.class, new Object[]{target});
	}

	public static TapByElement on(WebElement element) {
		return (TapByElement)Tasks.instrumented(TapByElement.class, new Object[]{element});
	}

	public static TapByText onVerticalTextScrollView(String text) {
		return (TapByText)Tasks.instrumented(TapByText.class, new Object[]{ComandosScroll.uiSelectorTextoVerticalScrollView(), text});
	}
}