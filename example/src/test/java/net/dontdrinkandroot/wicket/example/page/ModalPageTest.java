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
import net.dontdrinkandroot.wicket.example.page.component.ModalPage;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ModalPageTest extends AbstractWicketTest
{
    @Test
    public void testOpenStandardModal()
    {
        this.tester.startPage(ModalPage.class);
        this.tester.assertRenderedPage(ModalPage.class);

        this.tester.clickLink("openStandardModalButton", true);

        String response = this.tester.getLastResponseAsString();
        System.out.println(response);

        TagTester modalTester =
                TagTester.createTagByAttribute(this.tester.getLastResponseAsString(), "wicket:id", "modal");
        Assert.assertTrue(modalTester.getAttributeContains("class", "modal"));
    }

    @Test
    public void testOpenFormModal()
    {
        this.tester.startPage(ModalPage.class);
        this.tester.assertRenderedPage(ModalPage.class);

        String response = this.tester.getLastResponseAsString();
        this.tester.clickLink("openFormModalButton", true);

        TagTester modalTester =
                TagTester.createTagByAttribute(this.tester.getLastResponseAsString(), "wicket:id", "modal");
        Assert.assertTrue(modalTester.getAttributeContains("class", "modal"));
    }

    @Test
    public void testOpenAjaxFormModal()
    {
        this.tester.startPage(ModalPage.class);
        this.tester.assertRenderedPage(ModalPage.class);

        String response = this.tester.getLastResponseAsString();
        this.tester.clickLink("openAjaxFormModalButton", true);

        TagTester modalTester =
                TagTester.createTagByAttribute(this.tester.getLastResponseAsString(), "wicket:id", "modal");
        Assert.assertTrue(modalTester.getAttributeContains("class", "modal"));
    }
}
