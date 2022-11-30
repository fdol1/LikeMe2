package com.lineadirecta.certificacion.utils;

public class ComandosScroll {

    private ComandosScroll() {
        throw new IllegalStateException("Error en ComandosScroll");
    }

    public static String uiSelectorTextoHorizontal() {
        return "new UiScrollable(new UiSelector().scrollable(true).className(\"androidx.recyclerview.widget.RecyclerView\")).setAsHorizontalList().scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))";
    }

    public static String uiSelectorTextoVerticalScrollView() {
        return "new UiScrollable(new UiSelector().scrollable(true).className(\"android.widget.ScrollView\").instance(0)).scrollIntoView(new UiSelector().textContains(\"%s\").instance(0))";
    }
}
