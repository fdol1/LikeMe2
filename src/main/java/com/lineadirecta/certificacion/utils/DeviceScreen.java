package com.lineadirecta.certificacion.utils;

import net.serenitybdd.screenplay.Actor;
import org.openqa.selenium.Dimension;

public class DeviceScreen {

	private Dimension dim;
	
	public DeviceScreen(Actor actor) {
		this.dim = GetDriver.as(actor).appiumDriver().manage().window().getSize();
	}
	
	public static DeviceScreen as(Actor actor) {
		return new DeviceScreen(actor);
	}
	
	public int getWidth() {
		return dim.getWidth();
	}
	
	public int getHeight() {
		return dim.getHeight();
	}
	
	public int getMiddleHeight() {
		return dim.getHeight() / 2;
	}
	
	public int getMiddleWidth() {
		return dim.getWidth() / 2;
	}
}
