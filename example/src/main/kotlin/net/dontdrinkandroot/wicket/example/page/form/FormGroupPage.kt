package net.dontdrinkandroot.wicket.example.page.form

import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormStyleBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.item.AjaxLinkItem
import net.dontdrinkandroot.wicket.bootstrap.component.nav.repeatingNavTabs
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeStack
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.request.mapper.parameter.PageParameters

class FormGroupPage(parameters: PageParameters) : FormPage(parameters) {

    private var formStyleBehavior = FormStyleBehavior().setHorizontal(ColumnSizeStack.FORM_DEFAULT)

    override fun createPageHeadingModel() = "Form Groups and Form Styles".model()

    override fun onInitialize() {
        super.onInitialize()

        val styleNav = repeatingNavTabs("styleNav")
        { itemView ->
            itemView.add(object : AjaxLinkItem<Void>(itemView.newChildId(), labelModel = "Default".model()) {
                override fun onClick(target: AjaxRequestTarget?) {
                    formStyleBehavior.reset()
                    this.setResponsePage(this.page)
                }

                override val active: Boolean
                    get() = (!formStyleBehavior.isInline && !formStyleBehavior.isHorizontal)
            })
            itemView.add(object : AjaxLinkItem<Void>(itemView.newChildId(), labelModel = "Horizontal".model()) {
                override fun onClick(target: AjaxRequestTarget?) {
                    formStyleBehavior.setHorizontal(ColumnSizeStack.FORM_DEFAULT)
                    this.setResponsePage(this.page)
                }

                override val active: Boolean
                    get() = formStyleBehavior.isHorizontal
            })
            itemView.add(object : AjaxLinkItem<Void>(itemView.newChildId(), labelModel = "Inline".model()) {
                override fun onClick(target: AjaxRequestTarget?) {
                    formStyleBehavior.isInline = true
                    this.setResponsePage(this.page)
                }

                override val active: Boolean
                    get() = formStyleBehavior.isInline
            })
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