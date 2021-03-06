package net.dontdrinkandroot.wicket.example

import com.giffing.wicket.spring.boot.starter.app.WicketBootStandardWebApplication
import net.dontdrinkandroot.wicket.example.page.CssPage
import net.dontdrinkandroot.wicket.example.page.GettingStartedPage
import net.dontdrinkandroot.wicket.example.page.GridPage
import net.dontdrinkandroot.wicket.example.page.HomePage
import net.dontdrinkandroot.wicket.example.page.component.*
import net.dontdrinkandroot.wicket.example.page.form.AjaxFormPage
import net.dontdrinkandroot.wicket.example.page.form.FormGroupPage
import net.dontdrinkandroot.wicket.example.page.form.InputGroupPage
import net.dontdrinkandroot.wicket.example.page.form.ValidationPage
import org.apache.wicket.Page
import org.apache.wicket.Session
import org.apache.wicket.protocol.http.WebApplication
import org.apache.wicket.request.Request
import org.apache.wicket.request.Response
import org.apache.wicket.request.Url
import org.apache.wicket.request.resource.UrlResourceReference
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import java.util.*

@Component
open class ExampleWebApplication : WicketBootStandardWebApplication() {

    private val logger = LoggerFactory.getLogger(this.javaClass)
    lateinit var buildProperties: Properties
        private set

    override fun getHomePage(): Class<out Page?> {
        return HomePage::class.java
    }

    override fun init() {
        super.init()
        javaScriptLibrarySettings.jQueryReference =
            UrlResourceReference(Url.parse("https://code.jquery.com/jquery-2.2.4.min.js"))

        try {
            buildProperties = Properties()
            buildProperties.load(this.javaClass.classLoader.getResourceAsStream("build.properties"))
        } catch (e: Exception) {
            this.logger.warn("Could not load build properties: {}", e.message)
        }
        mountPage("css", CssPage::class.java)
        mountPage("grid", GridPage::class.java)
        mountPage("gettingstarted", GettingStartedPage::class.java)
        mountPage("forms/formgroups", FormGroupPage::class.java)
        mountPage("forms/validations", ValidationPage::class.java)
        mountPage("forms/ajax", AjaxFormPage::class.java)
        mountPage("forms/inputgroups", InputGroupPage::class.java)
        mountPage("components/navbars", NavbarPage::class.java)
        mountPage("components/navs", NavPage::class.java)
        mountPage("components/cards", CardPage::class.java)
        mountPage("components/alerts", AlertPage::class.java)
        mountPage("components/buttons", ButtonPage::class.java)
        mountPage("components/dropdowns", DropdownPage::class.java)
        mountPage("components/labels", BadgePage::class.java)
        mountPage("components/modals", ModalPage::class.java)
        mountPage("components/pagination", PaginationPage::class.java)
        mountPage("components/progressbars", ProgressBarPage::class.java)
        mountPage("components/breadcrumbs", BreadcrumbPage::class.java)
    }

    override fun newSession(request: Request, response: Response): Session {
        return ExampleWebSession(request)
    }

    companion object {

        @JvmStatic
        fun get(): ExampleWebApplication {
            return WebApplication.get() as ExampleWebApplication
        }
    }
}