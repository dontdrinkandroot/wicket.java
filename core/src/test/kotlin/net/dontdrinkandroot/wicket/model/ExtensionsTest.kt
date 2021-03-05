package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class ExtensionsTest {

    fun textModelExtension() {
        val nonNullable: IModel<String> = Model("value")
        nonNullable.setObject(null)
        // val nonNullableWithNull: IModel<String> = null.model() Expected not to work
        val nullable: IModel<String?> = Model("value")
        nullable.setObject(null)
        val nullableWithNull: IModel<String?> = Model(null)
    }
}