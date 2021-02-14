package net.dontdrinkandroot.wicket.bootstrap.component.modal

import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class SimpleModal(id: String) : Modal<Void>(id) {

    override fun createHeadingModel(): IModel<String> {
        return Model.of("Modal Heading")
    }
}