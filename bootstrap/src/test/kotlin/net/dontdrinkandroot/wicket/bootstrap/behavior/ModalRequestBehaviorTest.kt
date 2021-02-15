package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.bootstrap.component.modal.ModalPage
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ModalRequestBehaviorTest : AbstractWicketTest() {

    @Test
    fun testOpenModalRequest() {
        tester.startPage(ModalPage())
        tester.clickLink("openModalLink", true)
        val pageResponse = tester.lastResponseAsString
        var tagTester = TagTester.createTagByAttribute(pageResponse, "wicket:id", "modal")
        Assertions.assertTrue(tagTester.getAttributeContains("class", "modal"))
        Assertions.assertTrue(tagTester.getAttributeContains("class", "fade"))
        tagTester = TagTester.createTagByAttribute(pageResponse, "wicket:id", "heading")
        Assertions.assertEquals("Modal Heading", tagTester.value)
    }

    @Test
    fun testCreateAndOpenModalRequest() {
        tester.startPage(ModalPage())
        tester.clickLink("createAndOpenModalLink", true)
        val pageResponse = tester.lastResponseAsString
        var tagTester = TagTester.createTagByAttribute(pageResponse, "wicket:id", "modal")
        Assertions.assertTrue(tagTester.getAttributeContains("class", "modal"))
        Assertions.assertTrue(tagTester.getAttributeContains("class", "fade"))
        tagTester = TagTester.createTagByAttribute(pageResponse, "wicket:id", "heading")
        Assertions.assertEquals("Modal Heading", tagTester.value)
    }
}