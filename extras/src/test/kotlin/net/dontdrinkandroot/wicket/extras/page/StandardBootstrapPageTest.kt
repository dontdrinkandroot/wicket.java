package net.dontdrinkandroot.wicket.extras.page

import ` net`.dontdrinkandroot.wicket.extras.page.StandardBootstrapPage
import net.dontdrinkandroot.wicket.extras.test.AbstractWicketTest
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class StandardBootstrapPageTest : AbstractWicketTest() {

    @Test
    fun testDefaultMarkup() {
        tester.startPage(object : StandardBootstrapPage<Void?>() {
            override fun createPageHeadingModel() = "Page Heading".model()

            override fun createPageTitlePrefixModel() = "Page Title Prefix".model()
        })
        val pageResponse = tester.lastResponseAsString
        val titleTester = TagTester.createTagByAttribute(pageResponse, "wicket:id", "pageTitle")
        Assertions.assertEquals("Page Title Prefix - Page Heading", titleTester.value)
        val headingTester = TagTester.createTagByAttribute(pageResponse, "wicket:id", "pageHeading")
        Assertions.assertEquals("Page Heading", headingTester.value)
    }
}