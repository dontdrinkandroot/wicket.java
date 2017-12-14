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
package net.dontdrinkandroot.wicket.bootstrap.behavior.form;

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputEmail;
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.bootstrap.test.FormGroupTestPage;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupAjaxValidationBehaviorTest extends AbstractWicketTest
{
    @Test
    public void testError()
    {
        FormGroupTestPage<FormGroupInputEmail> page = new FormGroupTestPage<FormGroupInputEmail>()
        {
            @Override
            protected FormGroupInputEmail createFormGroup(String id)
            {
                FormGroupInputEmail formGroup = new FormGroupInputEmail(id, Model.of("Label"), new Model<>());
                formGroup.addAjaxValidation("blur");

                return formGroup;
            }
        };
        this.tester.startPage(page);

        FormTester formTester = this.tester.newFormTester("form", false);
        formTester.setValue("formGroup:container:inputGroup:formComponent", "invalid");

        this.tester.executeAjaxEvent(page.getFormGroup().getFormComponent(), "blur");

        CharSequence componentMarkup = ComponentRenderer.renderComponent(page.getFormGroup());

        TagTester formGroupTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "formGroup");
        Assert.assertTrue(formGroupTester.getAttributeContains("class", "form-group"));
        Assert.assertTrue(formGroupTester.getAttributeContains("class", "has-error"));

        List<TagTester> messagesTesters =
                TagTester.createTagsByAttribute(componentMarkup.toString(), "wicket:id", "messages", false);
        Assert.assertEquals(1, messagesTesters.size());

        TagTester messageTester = messagesTesters.get(0);
        Assert.assertTrue(messageTester.getAttributeContains("class", "error"));
        Assert.assertEquals(
                "The value of &#039;Label&#039; is not a valid email address.",
                messageTester.getChild("container").getValue()
        );

        //TODO: Test jQuery validations
    }
}
