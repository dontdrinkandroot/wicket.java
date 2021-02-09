package net.dontdrinkandroot.wicket.page

import net.dontdrinkandroot.wicket.test.AbstractWicketTest
import org.junit.jupiter.api.Test
import page.Html5ScaffoldPage

class Html5ScaffoldPageTest : AbstractWicketTest() {

    @Test
    fun testInstantiation() {
        tester.startPage(Html5ScaffoldPage::class.java)
        tester.assertRenderedPage(Html5ScaffoldPage::class.java)
    }
}