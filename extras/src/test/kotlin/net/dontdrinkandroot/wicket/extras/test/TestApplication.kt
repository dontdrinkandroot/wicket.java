package net.dontdrinkandroot.wicket.extras.test

import org.apache.wicket.Page
import org.apache.wicket.protocol.http.WebApplication

class TestApplication : WebApplication() {

    override fun getHomePage(): Class<out Page> = TestHomePage::class.java
}