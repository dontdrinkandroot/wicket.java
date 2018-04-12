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
package net.dontdrinkandroot.wicket.bootstrap.component.form;

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText;
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.bootstrap.test.FormTestPage;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.FormTester;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class RepeatingAjaxFormTest extends AbstractWicketTest
{
    @Test
    public void testPlainMarkup()
    {
        RepeatingAjaxForm component = new RepeatingAjaxForm("id");
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);

        Assert.assertEquals(
                "<wicket:form wicket:id=\"id\" id=\"id1\" method=\"post\" action=\"./wicket/page?0-0.-id\"><wicket:panel>\n" +
                        "\t\t<div wicket:id=\"feedback\" id=\"feedback2\"><wicket:panel>\n" +
                        "\t\t\n" +
                        "\t</wicket:panel></div>\n" +
                        "\t\t\n" +
                        "\t\t<div wicket:id=\"actions\" id=\"actions3\" class=\"form-group\"><wicket:panel>\n" +
                        "\t\t<label wicket:id=\"label\" class=\"control-label\"></label>\n" +
                        "\t\t<div wicket:id=\"container\">\n" +
                        "\t\t\t<wicket:child><wicket:extend>\n" +
                        "    <div class=\"btn-toolbar\">\n" +
                        "        \n" +
                        "    </div>\n" +
                        "</wicket:extend></wicket:child>\n" +
                        "\t\t</div>\n" +
                        "\t</wicket:panel></div>\n" +
                        "\t</wicket:panel></wicket:form>",
                componentMarkup.toString()
        );
    }

    @Test
    public void testSubmit()
    {
        Set<String> callSet = new HashSet<>();
        RepeatingAjaxForm<Void> component = new RepeatingAjaxForm<Void>(FormTestPage.COMPONENT_ID)
        {
            @Override
            protected void populateFormGroups(RepeatingView formGroupView)
            {
                super.populateFormGroups(formGroupView);
                FormGroupInputText formGroup =
                        new FormGroupInputText(formGroupView.newChildId(), Model.of("Label"), new Model<>());
                formGroup.setRequired(true);
                formGroupView.add(formGroup);
            }

            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                super.onSubmit(target);
                callSet.add("onSubmit");
                if (null != target) {
                    callSet.add("onSubmitAjax");
                }
            }

            @Override
            protected void onAfterSubmit(AjaxRequestTarget target)
            {
                super.onAfterSubmit(target);
                callSet.add("onAfterSubmit");
                if (null != target) {
                    callSet.add("onAfterSubmitAjax");
                }
            }

            @Override
            protected void onError(AjaxRequestTarget target)
            {
                super.onError(target);
                callSet.add("onError");
                if (null != target) {
                    callSet.add("onErrorAjax");
                }
            }
        };
        FormTestPage page = new FormTestPage(component);
        this.tester.startPage(page);

        /* Default submit with error */
        FormTester formTester = this.tester.newFormTester(FormTestPage.COMPONENT_ID, false);
        formTester.submit();

        Assert.assertFalse(callSet.contains("onSubmit"));
        Assert.assertFalse(callSet.contains("onSubmitAjax"));
        Assert.assertFalse(callSet.contains("onAfterSubmit"));
        Assert.assertFalse(callSet.contains("onAfterSubmitAjax"));
        Assert.assertTrue(callSet.contains("onError"));
        Assert.assertFalse(callSet.contains("onErrorAjax"));

        /* Ajax submit with error */
        callSet.clear();
        this.tester.executeAjaxEvent(component, "submit");

        Assert.assertFalse(callSet.contains("onSubmit"));
        Assert.assertFalse(callSet.contains("onSubmitAjax"));
        Assert.assertFalse(callSet.contains("onAfterSubmit"));
        Assert.assertFalse(callSet.contains("onAfterSubmitAjax"));
        Assert.assertTrue(callSet.contains("onError"));
        Assert.assertTrue(callSet.contains("onErrorAjax"));

        /* Populating textfield */
        formTester = this.tester.newFormTester(FormTestPage.COMPONENT_ID, false);
        formTester.setValue("formGroup:1:container:inputGroup:formComponent", "valid");

        /* Default submit with success */
        callSet.clear();
        formTester.submit();

        Assert.assertTrue(callSet.contains("onSubmit"));
        Assert.assertFalse(callSet.contains("onSubmitAjax"));
        Assert.assertTrue(callSet.contains("onAfterSubmit"));
        Assert.assertFalse(callSet.contains("onAfterSubmitAjax"));
        Assert.assertFalse(callSet.contains("onError"));
        Assert.assertFalse(callSet.contains("onErrorAjax"));

        /* Ajax submit with success */
        callSet.clear();
        this.tester.executeAjaxEvent(component, "submit");

        Assert.assertTrue(callSet.contains("onSubmit"));
        Assert.assertTrue(callSet.contains("onSubmitAjax"));
        Assert.assertTrue(callSet.contains("onAfterSubmit"));
        Assert.assertTrue(callSet.contains("onAfterSubmitAjax"));
        Assert.assertFalse(callSet.contains("onError"));
        Assert.assertFalse(callSet.contains("onErrorAjax"));
    }
}
