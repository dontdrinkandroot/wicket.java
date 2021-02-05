package net.dontdrinkandroot.wicket.test

import org.apache.wicket.Component

class InputTestPage(component: Component, private val type: String) : FormComponentTestPage(component) {

    override val formComponentMarkup: String
        get() = String.format("""<input wicket:id="%s" type="%s"/>""", component!!.id, type)
}