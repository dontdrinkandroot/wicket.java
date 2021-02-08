package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.LoadableDetachableModel
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ConcatenatingStringModelTest {

    @Test
    fun testConstruction() {
        var concatenatingStringModel: ConcatenatingStringModel

//        concatenatingStringModel = ConcatenatingStringModel(null.kModel(), null as String)
//        Assertions.assertEquals("", concatenatingStringModel.getObject())

        concatenatingStringModel = ConcatenatingStringModel("Parent".kModel(), null as String?)
        Assertions.assertEquals("Parent", concatenatingStringModel.getObject())

        concatenatingStringModel = ConcatenatingStringModel("Parent".kModel(), null.kModel())
        Assertions.assertEquals("Parent", concatenatingStringModel.getObject())

        concatenatingStringModel = ConcatenatingStringModel("Parent".kModel(), "Child")
        Assertions.assertEquals("ParentChild", concatenatingStringModel.getObject())

        concatenatingStringModel = ConcatenatingStringModel("Parent".kModel(), "Child".kModel())
        Assertions.assertEquals("ParentChild", concatenatingStringModel.getObject())

        concatenatingStringModel = ConcatenatingStringModel("Parent".kModel(), "Child")
        Assertions.assertEquals("ParentChild", concatenatingStringModel.getObject())

        concatenatingStringModel = ConcatenatingStringModel("Parent".kModel(), "Child".kModel())
        Assertions.assertEquals("ParentChild", concatenatingStringModel.getObject())

        concatenatingStringModel = ConcatenatingStringModel("Parent".kModel(), "-", "Child".kModel())
        Assertions.assertEquals("Parent-Child", concatenatingStringModel.getObject())
    }

    @Test
    fun testDetach() {
        val parentModel: LoadableDetachableModel<String> = object : LoadableDetachableModel<String>() {
            override fun load(): String {
                return "Parent"
            }
        }
        val childModel: LoadableDetachableModel<String> = object : LoadableDetachableModel<String>() {
            override fun load(): String {
                return "Child"
            }
        }
        val concatenatingStringModel = ConcatenatingStringModel(parentModel.toKModel(), childModel.toKModel())
        Assertions.assertEquals("ParentChild", concatenatingStringModel.getObject())
        concatenatingStringModel.detach()
        Assertions.assertFalse(parentModel.isAttached)
        Assertions.assertFalse(childModel.isAttached)
    }
}

