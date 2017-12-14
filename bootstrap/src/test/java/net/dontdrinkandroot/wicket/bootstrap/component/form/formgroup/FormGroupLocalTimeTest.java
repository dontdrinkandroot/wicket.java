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

import java.time.LocalTime;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupLocalTimeTest extends AbstractWicketTest
{
    @Test
    public void testFullMarkup()
    {
        TestFormPanel formPanel = new TestFormPanel("id");

        FormGroupLocalTime formGroupLocalTime =
                new FormGroupLocalTime("formGroup", Model.of("Label"), Model.of(LocalTime.of(13, 37)));
        formGroupLocalTime.getFormComponent().setMinModel(Model.of(LocalTime.of(9, 13, 14)));
        formGroupLocalTime.getFormComponent().setMax(LocalTime.of(17, 12));
        formPanel.getForm().add(formGroupLocalTime);

        CharSequence componentMarkup = ComponentRenderer.renderComponent(formGroupLocalTime);

        TagTester formComponentTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formComponent");
        Assert.assertTrue(formComponentTester.getAttributeContains("class", "form-control"));
        Assert.assertTrue(formComponentTester.getAttributeContains("type", "time"));
        Assert.assertTrue(formComponentTester.getAttributeContains("value", "13:37"));
        Assert.assertTrue(formComponentTester.getAttributeContains("min", "09:13"));
        Assert.assertTrue(formComponentTester.getAttributeContains("max", "17:12"));
        Assert.assertTrue(formComponentTester.getAttributeContains("placeholder", "Label"));
    }
}
