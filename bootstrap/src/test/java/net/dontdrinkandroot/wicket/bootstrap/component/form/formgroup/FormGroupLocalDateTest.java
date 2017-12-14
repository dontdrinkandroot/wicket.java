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

import java.time.LocalDate;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupLocalDateTest extends AbstractWicketTest
{
    @Test
    public void testFullMarkup()
    {
        TestFormPanel formPanel = new TestFormPanel("id");

        LocalDate testDate = LocalDate.of(2016, 3, 4);
        LocalDate minDate = LocalDate.of(2015, 1, 2);
        LocalDate maxDate = LocalDate.of(2017, 5, 6);
        FormGroupLocalDate formGroupLocalDate =
                new FormGroupLocalDate("formGroup", Model.of("Label"), Model.of(testDate));
        formGroupLocalDate.getFormComponent().setMin(minDate);
        formGroupLocalDate.getFormComponent().setMax(maxDate);
        formPanel.getForm().add(formGroupLocalDate);

        CharSequence componentMarkup = ComponentRenderer.renderComponent(formGroupLocalDate);

        TagTester formComponentTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formComponent");
        Assert.assertTrue(formComponentTester.getAttributeContains("class", "form-control"));
        Assert.assertTrue(formComponentTester.getAttributeContains("type", "date"));
        Assert.assertTrue(formComponentTester.getAttributeContains("value", "2016-03-04"));
        Assert.assertTrue(formComponentTester.getAttributeContains("min", "2015-01-02"));
        Assert.assertTrue(formComponentTester.getAttributeContains("max", "2017-05-06"));
        Assert.assertTrue(formComponentTester.getAttributeContains("placeholder", "Label"));
    }
}
