package net.dontdrinkandroot.wicket.model

import net.dontdrinkandroot.wicket.css.StringCssClass
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class CssClassToggleModelTest {

    @Test
    fun testByModelActive() {
        val activeModel = false.model()
        val activeClass = StringCssClass("active")
        val model = CssClassToggleModel(activeClass, activeModel)
        Assertions.assertNull(model.getObject())
        activeModel.setObject(java.lang.Boolean.TRUE)
        Assertions.assertEquals(activeClass, model.getObject())
    }

    @Test
    fun testByModelActiveInactive() {
        val activeModel = false.model()
        val activeClass = StringCssClass("active")
        val inactiveClass = StringCssClass("inactive")
        val model = CssClassToggleModel(activeClass, activeModel, inactiveClass)
        Assertions.assertEquals(inactiveClass, model.getObject())
        activeModel.setObject(java.lang.Boolean.TRUE)
        Assertions.assertEquals(activeClass, model.getObject())
    }

    @Test
    fun testWithoutModel() {
        val activeClass = StringCssClass("active")
        val model = CssClassToggleModel(activeClass)
        Assertions.assertEquals(activeClass, model.getObject())
    }
}