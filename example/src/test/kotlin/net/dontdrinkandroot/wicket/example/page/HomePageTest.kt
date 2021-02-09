package net.dontdrinkandroot.wicket.example.page

import net.dontdrinkandroot.wicket.example.AbstractWicketTest
import org.junit.jupiter.api.Test

class HomePageTest : AbstractWicketTest()
{
    @Test
    fun testPageStateless()
    {
        tester.startPage(HomePage::class.java)
        tester.assertRenderedPage(HomePage::class.java)
        val page = tester.lastRenderedPage
        assertStateless(page)
    }
}