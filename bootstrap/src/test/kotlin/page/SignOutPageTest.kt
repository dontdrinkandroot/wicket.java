package page

import net.dontdrinkandroot.wicket.bootstrap.page.SignOutPage
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class SignOutPageTest : AbstractWicketTest() {

    @Test
    @Disabled("Session in validate in Page causes this test to fail")
    fun testInstantiation() {
        tester.startPage(SignOutPage())
        tester.assertRenderedPage(SignOutPage::class.java)
    }
}