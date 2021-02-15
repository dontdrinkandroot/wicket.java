package net.dontdrinkandroot.wicket.bootstrap.test

import org.apache.wicket.Page
import org.apache.wicket.Session
import org.apache.wicket.protocol.http.WebApplication
import org.apache.wicket.protocol.http.WebSession
import org.apache.wicket.request.Request
import org.apache.wicket.request.Response
import java.util.*

fun getTestApplication(): TestApplication = WebApplication.get() as TestApplication

class TestApplication : WebApplication() {

    override fun getHomePage(): Class<out Page> = TestHomePage::class.java

    override fun newSession(request: Request, response: Response): Session {
        return object : WebSession(request) {
            override fun getLocale(): Locale {
                return Locale.ENGLISH
            }
        }
    }
}