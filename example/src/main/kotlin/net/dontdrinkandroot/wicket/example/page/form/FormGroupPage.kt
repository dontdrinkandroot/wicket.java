package net.dontdrinkandroot.wicket.example.page.form

import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormStyleBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.item.AjaxLinkItem
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeStack
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class FormGroupPage(parameters: PageParameters) : FormPage(parameters) {

    protected var formStyleBehavior = FormStyleBehavior().setHorizontal(ColumnSizeStack.FORM_DEFAULT)
    override fun createPageHeadingModel() = "Form Groups and Form Styles".model()

    override fun onInitialize() {
        super.onInitialize()
        val styleItemView = RepeatingView("styleItem")
        this.add(styleItemView)
        styleItemView.add(object : AjaxLinkItem<Void?>(styleItemView.newChildId(), Model.of("Default")) {
            override fun onClick(target: AjaxRequestTarget) {
                formStyleBehavior.reset()
                this.setResponsePage(this.page)
            }

            override val active: Boolean
                get() = (!formStyleBehavior.isInline && !formStyleBehavior.isHorizontal)
        })
        styleItemView.add(object : AjaxLinkItem<Void?>(styleItemView.newChildId(), Model.of("Horizontal")) {
            override fun onClick(target: AjaxRequestTarget) {
                formStyleBehavior.setHorizontal(ColumnSizeStack.FORM_DEFAULT)
                this.setResponsePage(this.page)
            }

            override val active: Boolean
                get() = formStyleBehavior.isHorizontal
        })
        styleItemView.add(object : AjaxLinkItem<Void?>(styleItemView.newChildId(), Model.of("Inline")) {
            override fun onClick(target: AjaxRequestTarget) {
                formStyleBehavior.isInline = true
                this.setResponsePage(this.page)
            }

            override val active: Boolean
                get() = formStyleBehavior.isInline
        })
        val form = Form<Void>("form")
        form.add(formStyleBehavior)
        this.add(form)
        val formGroupView = RepeatingView("formGroup")
        populateFormGroups(form, formGroupView)
        form.add(formGroupView)
    }
}