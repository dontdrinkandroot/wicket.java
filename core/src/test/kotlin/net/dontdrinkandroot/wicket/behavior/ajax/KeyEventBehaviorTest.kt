package net.dontdrinkandroot.wicket.behavior.ajax

import net.dontdrinkandroot.wicket.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.test.TestPage
import org.apache.wicket.ajax.AjaxRequestTarget
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class KeyEventBehaviorTest : AbstractWicketTest() {

    @Test
    fun testKeyup() {
        val page: TestPage = object : TestPage() {
            override fun onInitialize() {
                super.onInitialize()
                this.add(object : KeyEventBehavior() {
                    override fun onEvent(target: AjaxRequestTarget, keyPressResponse: KeyEventResponse) {
                        Assertions.assertEquals(-1, keyPressResponse.charCode)
                        Assertions.assertEquals(-1, keyPressResponse.keyCode)
                        Assertions.assertEquals(-1, keyPressResponse.which)
                        Assertions.assertFalse(keyPressResponse.isAltKey)
                        Assertions.assertFalse(keyPressResponse.isCtrlKey)
                        Assertions.assertFalse(keyPressResponse.isMetaKey)
                        Assertions.assertFalse(keyPressResponse.isShiftKey)
                    }
                })
            }
        }
        tester.startPage(page)
        tester.debugComponentTrees()
        tester.executeAjaxEvent(page, "keyup")
    }
}