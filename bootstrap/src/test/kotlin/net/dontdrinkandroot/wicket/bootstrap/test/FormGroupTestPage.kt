package net.dontdrinkandroot.wicket.bootstrap.test

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroup
import org.apache.wicket.markup.html.WebPage
import org.apache.wicket.markup.html.form.Form

abstract class FormGroupTestPage<T : FormGroup<*>> : WebPage() {

    lateinit var formGroup: T

    override fun onInitialize() {
        super.onInitialize()
        val form: Form<*> = Form<Any?>("form")
        this.add(form)
        formGroup = createFormGroup("formGroup")
        form.add(formGroup)
    }

    protected abstract fun createFormGroup(id: String): T
}