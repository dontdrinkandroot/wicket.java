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
package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.inputgroup.addon;

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.addon.InputGroupButton;
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.addon.InputGroupLabel;
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.bootstrap.test.TestFormPanel;
import net.dontdrinkandroot.wicket.bootstrap.test.TestHomePage;
import org.apache.wicket.Component;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class InputGroupAddonTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        TestFormPanel formPanel = new TestFormPanel("id");

        FormGroupInputText formGroupInputText =
                new FormGroupInputText("formGroup", Model.of("Label"), Model.of("Value"))
                {
                    @Override
                    protected Component createInputGroupAddonBefore(String id)
                    {
                        return new InputGroupLabel(id, Model.of("Label"));
                    }

                    @Override
                    protected Component createInputGroupAddonAfter(String id)
                    {
                        return new InputGroupButton(id)
                        {
                            @Override
                            protected Component createLink(String id)
                            {
                                return new BookmarkablePageLink(id, TestHomePage.class);
                            }
                        };
                    }
                };
        formPanel.getForm().add(formGroupInputText);

        CharSequence componentMarkup = ComponentRenderer.renderComponent(formGroupInputText);
        TagTester inputGroupAddonBefore =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "inputGroupAddonBefore");
        Assert.assertEquals("input-group-addon", inputGroupAddonBefore.getAttribute("class"));
        TagTester inputGroupAddonAfter =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "inputGroupAddonAfter");
        Assert.assertEquals("input-group-btn", inputGroupAddonAfter.getAttribute("class"));
    }
}
