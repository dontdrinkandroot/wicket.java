package net.dontdrinkandroot.wicket.test

import org.apache.wicket.Component
import org.apache.wicket.MarkupContainer
import org.apache.wicket.markup.IMarkupResourceStreamProvider
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.util.resource.IResourceStream
import org.apache.wicket.util.resource.StringResourceStream

abstract class FormComponentTestPage(component: Component) : WebPage(), IMarkupResourceStreamProvider {

    private var form: Form<Void>? = null

    protected var component: Component? = null

    override fun getMarkupResourceStream(container: MarkupContainer, containerClass: Class<*>?): IResourceStream {
        val markup = """<html><body><form wicket:id="form">$formComponentMarkup</form></body></html>"""
        return StringResourceStream(markup)
    }

    abstract val formComponentMarkup: String

    init {
        form = Form<Void>("form")
        this.add(form)
        form!!.add(component.also { this.component = it })
    }
}