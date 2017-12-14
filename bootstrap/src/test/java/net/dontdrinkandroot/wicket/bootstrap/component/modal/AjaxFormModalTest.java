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
package net.dontdrinkandroot.wicket.bootstrap.component.modal;

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText;
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.bootstrap.test.ComponentTestPage;
import net.dontdrinkandroot.wicket.bootstrap.test.FormTestPage;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.FormTester;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class AjaxFormModalTest extends AbstractWicketTest
{
    @Test
    public void testDefaultMarkup()
    {
        AjaxFormModal<String> component = new AjaxFormModal<String>("modalId")
        {
            @Override
            protected IModel<String> createHeadingModel()
            {
                return Model.of("Modal Heading");
            }
        };
        String componentMarkup = ComponentRenderer.renderComponent(component).toString();

        TagTester tester;

        tester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "modalId");
        Assert.assertTrue(tester.getAttributeContains("class", "modal"));
        Assert.assertTrue(tester.getAttributeContains("class", "fade"));

        tester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "heading");
        Assert.assertEquals("Modal Heading", tester.getValue());
    }

    @Test
    public void testSubmit()
    {
        IModel<String> testStringModel = new Model<>();
        AjaxFormModal<String> component = new AjaxFormModal<String>(FormTestPage.COMPONENT_ID, testStringModel)
        {
            @Override
            protected IModel<String> createHeadingModel()
            {
                return Model.of("Heading");
            }

            @Override
            protected void populateFormGroups(RepeatingView formGroupView)
            {
                super.populateFormGroups(formGroupView);
                FormGroupInputText formGroup =
                        new FormGroupInputText(formGroupView.newChildId(), Model.of("Label"), testStringModel);
                formGroup.setRequired(true);
                formGroupView.add(formGroup);
            }

            @Override
            protected void onError(AjaxRequestTarget target)
            {
                super.onError(target);
                testStringModel.setObject("error");
            }
        };
        ComponentTestPage page = new ComponentTestPage(component);
        this.tester.startPage(page);

        /* Default submit with error */
        FormTester formTester = this.tester.newFormTester(FormTestPage.COMPONENT_ID + ":form", false);
        formTester.submit();

        /* Ajax submit with error */
        this.tester.executeAjaxEvent(component.getForm(), "submit");

        Assert.assertEquals("error", testStringModel.getObject());

        /* Default submit with success */
        formTester = this.tester.newFormTester(FormTestPage.COMPONENT_ID + ":form", false);
        formTester.setValue("formGroup:1:container:inputGroup:formComponent", "default");
        formTester.submit();

        Assert.assertEquals("default", testStringModel.getObject());

        /* Ajax submit with success */
        formTester = this.tester.newFormTester(FormTestPage.COMPONENT_ID + ":form", false);
        formTester.setValue("formGroup:1:container:inputGroup:formComponent", "ajax");
        this.tester.executeAjaxEvent(component.getForm(), "submit");

        Assert.assertEquals("ajax", testStringModel.getObject());
    }
}
