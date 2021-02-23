package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel

class ExtensionsTest {

    fun textModelExtension() {
        val nonNullable: IModel<String> = "value".model()
        nonNullable.setObject(null)
        // val nonNullableWithNull: IModel<String> = null.model() Expected not to work
        val nullable: IModel<String?> = "value".model()
        nullable.setObject(null)
        val nullableWithNull: IModel<String?> = null.model()
    }
}