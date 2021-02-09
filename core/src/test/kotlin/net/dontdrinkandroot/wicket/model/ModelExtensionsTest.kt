package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel

class ModelExtensionsTest {

    fun testModel() {
        val notNullModel: IModel<String?> = "test".model()
        val nullModel: IModel<String?> = null.model()
    }
}
