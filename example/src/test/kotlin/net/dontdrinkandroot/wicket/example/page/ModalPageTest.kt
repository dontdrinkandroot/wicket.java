package net.dontdrinkandroot.wicket.example.page

import net.dontdrinkandroot.wicket.example.AbstractWicketTest
import net.dontdrinkandroot.wicket.example.page.component.ModalPage
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ModalPageTest : AbstractWicketTest()
{
    @Test
    fun testOpenStandardModal()
    {
        tester.startPage(ModalPage::class.java)
        tester.assertRenderedPage(ModalPage::class.java)
        tester.clickLink("openStandardModalButton", true)
        val response = tester.lastResponseAsString
        val modalTester = TagTester.createTagByAttribute(tester.lastResponseAsString, "wicket:id", "modal")
        Assertions.assertTrue(modalTester.getAttributeContains("class", "modal"))
    }

    @Test
    fun testOpenFormModal()
    {
        tester.startPage(ModalPage::class.java)
        tester.assertRenderedPage(ModalPage::class.java)
        val response = tester.lastResponseAsString
        tester.clickLink("openFormModalButton", true)
        val modalTester = TagTester.createTagByAttribute(tester.lastResponseAsString, "wicket:id", "modal")
        Assertions.assertTrue(modalTester.getAttributeContains("class", "modal"))
    }

    @Test
    fun testOpenAjaxFormModal()
    {
        tester.startPage(ModalPage::class.java)
        tester.assertRenderedPage(ModalPage::class.java)
        val response = tester.lastResponseAsString
        tester.clickLink("openAjaxFormModalButton", true)
        val modalTester = TagTester.createTagByAttribute(tester.lastResponseAsString, "wicket:id", "modal")
        Assertions.assertTrue(modalTester.getAttributeContains("class", "modal"))
    }
}