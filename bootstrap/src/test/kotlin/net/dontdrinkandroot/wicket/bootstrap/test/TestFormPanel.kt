package net.dontdrinkandroot.wicket.bootstrap.test

import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.html.panel.Panel

class TestFormPanel(id: String) : Panel(id) {

    val form: Form<Void> = Form("form")

    init {
        this.add(form)
    }
}