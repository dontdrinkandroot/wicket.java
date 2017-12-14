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
package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.bootstrap.test.TestFormPanel;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

public class FormGroupCheckBoxTest extends AbstractWicketTest
{
    @Test
    public void testDefaultMarkup()
    {
        TestFormPanel formPanel = new TestFormPanel("id");

        FormGroupCheckBox formGroup =
                new FormGroupCheckBox("formGroup", Model.of("Label"), Model.of(true));
        formPanel.getForm().add(formGroup);

        CharSequence componentMarkup = ComponentRenderer.renderComponent(formPanel);

        TagTester formGroupTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formGroup");
        Assert.assertTrue(formGroupTester.getAttributeContains("class", "form-group"));

        TagTester labelTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "label");
        Assert.assertEquals("Label", labelTester.getValue());

        TagTester formComponentTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formComponent");
        Assert.assertEquals("checkbox", formComponentTester.getAttribute("type"));
        Assert.assertEquals("checked", formComponentTester.getAttribute("checked"));
    }
}
