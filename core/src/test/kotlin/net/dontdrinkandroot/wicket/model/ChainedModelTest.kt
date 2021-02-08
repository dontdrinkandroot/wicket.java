package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.IModel

class ChainedModelTest {

    fun testBla() {
        val notNullableStringModel: IModel<String> = IModel<String> { "notnull" }
        val nullableStringModel: IModel<String> = IModel<String> { null }

        val notNullableStringKModel: KModel<String> = KModel { "notnull" }
        val nullableStringKModel: KModel<String?> = KModel { null }
    }
}