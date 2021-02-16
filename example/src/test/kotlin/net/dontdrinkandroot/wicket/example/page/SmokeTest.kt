package net.dontdrinkandroot.wicket.example.page

import net.dontdrinkandroot.wicket.example.AbstractWicketTest
import net.dontdrinkandroot.wicket.example.page.component.*
import net.dontdrinkandroot.wicket.example.page.form.AjaxFormPage
import net.dontdrinkandroot.wicket.example.page.form.FormGroupPage
import net.dontdrinkandroot.wicket.example.page.form.InputGroupPage
import net.dontdrinkandroot.wicket.example.page.form.ValidationPage
import org.apache.wicket.Page
import org.junit.jupiter.api.Test

class SmokeTest : AbstractWicketTest()
{
    @Test
    fun testPages()
    {
        testPage(HomePage::class.java)
        testPage(GettingStartedPage::class.java)
        testPage(CssPage::class.java)
        testPage(GridPage::class.java)
        testPage(AlertPage::class.java)
        testPage(ButtonPage::class.java)
        testPage(DropdownPage::class.java)
        testPage(BadgePage::class.java)
        testPage(ModalPage::class.java)
        testPage(NavPage::class.java)
        testPage(NavbarPage::class.java)
        testPage(BreadcrumbPage::class.java)
        testPage(ValidationPage::class.java)
        testPage(InputGroupPage::class.java)
        testPage(ProgressBarPage::class.java)
        testPage(FormGroupPage::class.java)
        testPage(PaginationPage::class.java)
        testPage(AjaxFormPage::class.java)
        testPage(CardPage::class.java)
    }

    protected fun <T : Page?> testPage(pageClass: Class<T>)
    {
        tester.startPage(pageClass)
        tester.assertRenderedPage(pageClass)
    }
}