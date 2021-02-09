package page

import net.dontdrinkandroot.wicket.bootstrap.page.SignInPage
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.request.mapper.parameter.PageParameters
import org.junit.jupiter.api.Test

class SignInPageTest : AbstractWicketTest() {

    @Test
    fun testInstantiation() {
        tester.startPage(object : SignInPage(PageParameters()) {
            override val signedIn: Boolean
                protected get() = false

            override fun signIn(username: String, password: String): Boolean {
                return false
            }
        })
        tester.assertRenderedPage(SignInPage::class.java)
    }
}