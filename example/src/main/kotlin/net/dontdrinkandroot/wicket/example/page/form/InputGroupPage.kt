package net.dontdrinkandroot.wicket.example.page.form

import net.dontdrinkandroot.wicket.bootstrap.component.button.buttonLink
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupText
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupTextLabel
import org.apache.wicket.Component
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class InputGroupPage(parameters: PageParameters) : FormPage(parameters) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(object : InputGroupText<String>("texts", Model.of("")) {
            override fun createAddonPrepend(id: String): Component = InputGroupTextLabel(id, Model.of("Before"))

            override fun createAddonAppend(id: String): Component = InputGroupTextLabel(id, Model.of("After"))
        })

        this.add(object : InputGroupText<String>("buttons", Model.of("")) {
            override fun createAddonPrepend(id: String): Component =
                buttonLink<Void>(id, bodyModel = Model("Prepend")) {}

            override fun createAddonAppend(id: String): Component =
                buttonLink<Void>(id, bodyModel = Model("Append")) {}
        })
    }

    override fun createPageHeadingModel() = Model("Input Groups")
}