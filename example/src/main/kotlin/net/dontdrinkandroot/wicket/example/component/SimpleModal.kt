package net.dontdrinkandroot.wicket.example.component

import net.dontdrinkandroot.wicket.bootstrap.component.modal.Modal
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class SimpleModal(id: String) : Modal<Void>(id) {

    override fun createHeadingModel(): IModel<String> = Model("This is a simple Modal")
}