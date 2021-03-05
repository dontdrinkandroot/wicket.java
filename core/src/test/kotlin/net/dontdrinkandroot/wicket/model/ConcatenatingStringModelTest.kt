package net.dontdrinkandroot.wicket.model

import org.apache.wicket.model.LoadableDetachableModel
import org.apache.wicket.model.Model
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ConcatenatingStringModelTest {

    @Test
    fun testConstruction() {
        var concatenatingStringModel: ConcatenatingStringModel

//        concatenatingStringModel = ConcatenatingStringModel(null.kModel(), null as String)
//        Assertions.assertEquals("", concatenatingStringModel.getObject())

        concatenatingStringModel = ConcatenatingStringModel(Model("Parent"), null)
        Assertions.assertEquals("Parent", concatenatingStringModel.getObject())

        concatenatingStringModel = ConcatenatingStringModel(Model("Parent"), Model(null))
        Assertions.assertEquals("Parent", concatenatingStringModel.getObject())

        concatenatingStringModel = ConcatenatingStringModel(Model("Parent"), "Child")
        Assertions.assertEquals("ParentChild", concatenatingStringModel.getObject())

        concatenatingStringModel = ConcatenatingStringModel(Model("Parent"), Model("Child"))
        Assertions.assertEquals("ParentChild", concatenatingStringModel.getObject())

        concatenatingStringModel = ConcatenatingStringModel(Model("Parent"), "Child")
        Assertions.assertEquals("ParentChild", concatenatingStringModel.getObject())

        concatenatingStringModel = ConcatenatingStringModel(Model("Parent"), Model("Child"))
        Assertions.assertEquals("ParentChild", concatenatingStringModel.getObject())

        concatenatingStringModel = ConcatenatingStringModel(Model("Parent"), "-", Model("Child"))
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
        val concatenatingStringModel = ConcatenatingStringModel(parentModel, childModel)
        Assertions.assertEquals("ParentChild", concatenatingStringModel.getObject())
        concatenatingStringModel.detach()
        Assertions.assertFalse(parentModel.isAttached)
        Assertions.assertFalse(childModel.isAttached)
    }
}

