package net.dontdrinkandroot.wicket.example.page.form

import net.dontdrinkandroot.wicket.bootstrap.component.button.Button
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupText
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupTextLabel
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.Component
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class InputGroupPage(parameters: PageParameters) : FormPage(parameters) {

    override fun onInitialize() {
        super.onInitialize()
        val texts: InputGroupText = object : InputGroupText("texts", Model.of("")) {
            override fun createAddonPrepend(id: String): Component = InputGroupTextLabel(id, Model.of("Before"))

            override fun createAddonAppend(id: String): Component = InputGroupTextLabel(id, Model.of("After"))
        }
        this.add(texts)

        val buttons: InputGroupText = object : InputGroupText("buttons", Model.of("")) {
            override fun createAddonPrepend(id: String): Component =
                Button<Void>(id, bodyModel = Model("Prepend"), onClickHandler = {})

            override fun createAddonAppend(id: String): Component =
                Button<Void>(id, bodyModel = Model("Append"), onClickHandler = {})
        }
        this.add(buttons)
    }

    override fun createPageHeadingModel() = "Input Groups".model()
}