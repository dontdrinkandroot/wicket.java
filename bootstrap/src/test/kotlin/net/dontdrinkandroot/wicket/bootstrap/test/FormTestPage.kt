package net.dontdrinkandroot.wicket.bootstrap.test

import org.apache.wicket.MarkupContainer
import org.apache.wicket.markup.IMarkupResourceStreamProvider
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.util.resource.IResourceStream
import org.apache.wicket.util.resource.StringResourceStream

class FormTestPage(form: Form<*>?) : WebPage(), IMarkupResourceStreamProvider {

    override fun getMarkupResourceStream(container: MarkupContainer, containerClass: Class<*>?): IResourceStream {
        val markup = "<html><body><form wicket:id=\"id\"></form></body></html>"
        return StringResourceStream(markup)
    }

    companion object {

        const val COMPONENT_ID = "id"
    }

    init {
        this.add(form)
    }
}