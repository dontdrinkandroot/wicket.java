package net.dontdrinkandroot.wicket.example.page.form

import net.dontdrinkandroot.wicket.bootstrap.behavior.active
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormStyleBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.item.ajaxLink
import net.dontdrinkandroot.wicket.bootstrap.component.nav.repeatingNavTabs
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeStack
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class FormGroupPage(parameters: PageParameters) : FormPage(parameters) {

    private var formStyleBehavior = FormStyleBehavior().setHorizontal(ColumnSizeStack.FORM_DEFAULT)

    override fun createPageHeadingModel() = Model("Form Groups and Form Styles")

    override fun onInitialize() {
        super.onInitialize()

        val styleNav = repeatingNavTabs("styleNav")
        {
            ajaxLink("Default",
                active { !formStyleBehavior.isInline && !formStyleBehavior.isHorizontal }) {
                formStyleBehavior.reset()
                this.setResponsePage(this.page)
            }
            ajaxLink("Horizontal",
                active { formStyleBehavior.isHorizontal }) {
                formStyleBehavior.setHorizontal(ColumnSizeStack.FORM_DEFAULT)
                this.setResponsePage(this.page)
            }
            ajaxLink("Inline",
                active { formStyleBehavior.isInline }) {
                formStyleBehavior.isInline = true
                this.setResponsePage(this.page)
            }
        }
        this.add(styleNav)

        val form = Form<Void>("form")
        form.add(formStyleBehavior)
        this.add(form)

        val formGroupView = RepeatingView("formGroup")
        populateFormGroups(form, formGroupView)
        form.add(formGroupView)
    }
}