package net.dontdrinkandroot.wicket.example.page.form

import net.dontdrinkandroot.wicket.bootstrap.behavior.active
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormStyleBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.form.addForm
import net.dontdrinkandroot.wicket.bootstrap.component.item.addAjaxLink
import net.dontdrinkandroot.wicket.bootstrap.component.nav.addNavTabs
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeStack
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class FormGroupPage(parameters: PageParameters) : FormPage(parameters) {

    private var formStyleBehavior = FormStyleBehavior().setHorizontal(ColumnSizeStack.FORM_DEFAULT)

    override fun createPageHeadingModel() = Model("Form Groups and Form Styles")

    override fun onInitialize() {
        super.onInitialize()

        addNavTabs("styleNav")
        {
            addAjaxLink("Default",
                active { !formStyleBehavior.inline && !formStyleBehavior.horizontal }) {
                formStyleBehavior.reset()
                setResponsePage(page)
            }
            addAjaxLink("Horizontal",
                active { formStyleBehavior.horizontal }) {
                formStyleBehavior.setHorizontal(ColumnSizeStack.FORM_DEFAULT)
                setResponsePage(page)
            }
            addAjaxLink("Inline",
                active { formStyleBehavior.inline }) {
                formStyleBehavior.inline = true
                setResponsePage(page)
            }
        }

        addForm(
            "form",
            { component -> populateFormGroups(component, this) },
            formStyleBehavior
        ) {
            success("Form is valid")
        }
    }
}