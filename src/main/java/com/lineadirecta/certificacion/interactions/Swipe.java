package com.lineadirecta.certificacion.interactions;

import com.lineadirecta.certificacion.interactions.swipe.SwipeBuilderFrom;
import net.serenitybdd.screenplay.Actor;

public class Swipe {
	
	public static SwipeBuilderFrom as (Actor actor) {
		return new SwipeBuilderFrom(actor);
	}
}
