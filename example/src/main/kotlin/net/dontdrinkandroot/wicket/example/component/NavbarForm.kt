package net.dontdrinkandroot.wicket.example.component

import net.dontdrinkandroot.wicket.bootstrap.behavior.form.inlineForm
import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxSubmitButton
import net.dontdrinkandroot.wicket.bootstrap.component.form.RepeatingForm
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model

class NavbarForm(id: String) : RepeatingForm<Void>(id) {

    override fun onInitialize() {
        super.onInitialize()
        add(inlineForm())
    }

    override fun populateFormGroups(formGroupView: RepeatingView) {
        super.populateFormGroups(formGroupView)
        val searchGroup = FormGroupInputText(formGroupView.newChildId(), Model(), Model("Search"))
        searchGroup.setLabelScreenReaderOnly(true)
        formGroupView.add(searchGroup)
    }

    override fun populateActions(buttonView: RepeatingView)
    {
        buttonView.add(AjaxSubmitButton(buttonView.newChildId(), labelModel = Model("Search")))
    }
}