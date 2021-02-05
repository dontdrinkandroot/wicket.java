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
import net.dontdrinkandroot.wicket.example.page.component.ModalPage
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class ModalPageTest : AbstractWicketTest()
{
    @Test
    fun testOpenStandardModal()
    {
        tester.startPage(ModalPage::class.java)
        tester.assertRenderedPage(ModalPage::class.java)
        tester.clickLink("openStandardModalButton", true)
        val response = tester.lastResponseAsString
        val modalTester = TagTester.createTagByAttribute(tester.lastResponseAsString, "wicket:id", "modal")
        Assertions.assertTrue(modalTester.getAttributeContains("class", "modal"))
    }

    @Test
    fun testOpenFormModal()
    {
        tester.startPage(ModalPage::class.java)
        tester.assertRenderedPage(ModalPage::class.java)
        val response = tester.lastResponseAsString
        tester.clickLink("openFormModalButton", true)
        val modalTester = TagTester.createTagByAttribute(tester.lastResponseAsString, "wicket:id", "modal")
        Assertions.assertTrue(modalTester.getAttributeContains("class", "modal"))
    }

    @Test
    fun testOpenAjaxFormModal()
    {
        tester.startPage(ModalPage::class.java)
        tester.assertRenderedPage(ModalPage::class.java)
        val response = tester.lastResponseAsString
        tester.clickLink("openAjaxFormModalButton", true)
        val modalTester = TagTester.createTagByAttribute(tester.lastResponseAsString, "wicket:id", "modal")
        Assertions.assertTrue(modalTester.getAttributeContains("class", "modal"))
    }
}