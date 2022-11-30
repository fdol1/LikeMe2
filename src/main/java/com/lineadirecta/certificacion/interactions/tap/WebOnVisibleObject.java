package com.lineadirecta.certificacion.interactions.tap;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.conditions.Check;
import net.serenitybdd.screenplay.targets.Target;

public class WebOnVisibleObject implements Interaction {

    private final Target target;

    public WebOnVisibleObject(Target target){
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(new Performable[]{
                Check.whether(this.target.resolveFor(actor).isCurrentlyVisible()).andIfSo(new Performable[]{Click.on(this.target)})
        });
    }
}
