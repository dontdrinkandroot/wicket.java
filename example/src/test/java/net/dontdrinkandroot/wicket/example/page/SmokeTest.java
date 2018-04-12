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
package net.dontdrinkandroot.wicket.example.page;

import net.dontdrinkandroot.wicket.example.AbstractWicketTest;
import net.dontdrinkandroot.wicket.example.page.component.*;
import net.dontdrinkandroot.wicket.example.page.form.AjaxFormPage;
import net.dontdrinkandroot.wicket.example.page.form.FormGroupPage;
import net.dontdrinkandroot.wicket.example.page.form.InputGroupPage;
import net.dontdrinkandroot.wicket.example.page.form.ValidationPage;
import org.apache.wicket.Page;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class SmokeTest extends AbstractWicketTest
{
    @Test
    public void testPages()
    {
        this.testPage(HomePage.class);
        this.testPage(GettingStartedPage.class);
        this.testPage(CssPage.class);
        this.testPage(GridPage.class);
        this.testPage(AlertPage.class);
        this.testPage(ButtonPage.class);
        this.testPage(DropdownPage.class);
        this.testPage(BadgePage.class);
        this.testPage(ModalPage.class);
        this.testPage(NavPage.class);
        this.testPage(NavbarPage.class);
        this.testPage(BreadcrumbPage.class);
        this.testPage(ValidationPage.class);
        this.testPage(InputGroupPage.class);
        this.testPage(ProgressBarPage.class);
        this.testPage(FormGroupPage.class);
        this.testPage(PaginationPage.class);
        this.testPage(AjaxFormPage.class);
        this.testPage(PanelPage.class);
    }

    protected <T extends Page> void testPage(Class<T> pageClass)
    {
        this.tester.startPage(pageClass);
        this.tester.assertRenderedPage(pageClass);
    }
}
