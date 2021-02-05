package net.dontdrinkandroot.wicket.test

import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.repeater.RepeatingView

open class TestPage : WebPage() {

    override fun onInitialize() {
        super.onInitialize()
        val componentView = RepeatingView("component")
        populateComponents(componentView)
        this.add(componentView)
    }

    protected open fun populateComponents(componentView: RepeatingView) {
        /* Hook */
    }
}