/*
 * Copyright (C) 2012-2017 Philip Washington Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.dontdrinkandroot.wicket.example.page

import net.dontdrinkandroot.wicket.example.AbstractWicketTest
import net.dontdrinkandroot.wicket.example.page.component.*
import net.dontdrinkandroot.wicket.example.page.form.AjaxFormPage
import net.dontdrinkandroot.wicket.example.page.form.FormGroupPage
import net.dontdrinkandroot.wicket.example.page.form.InputGroupPage
import net.dontdrinkandroot.wicket.example.page.form.ValidationPage
import org.apache.wicket.Page
import org.junit.jupiter.api.Test

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
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
        testPage(PanelPage::class.java)
    }

    protected fun <T : Page?> testPage(pageClass: Class<T>)
    {
        tester.startPage(pageClass)
        tester.assertRenderedPage(pageClass)
    }
}