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
package net.dontdrinkandroot.wicket.bootstrap.component.panel;

import net.dontdrinkandroot.wicket.bootstrap.component.button.SubmitLabelButton;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText;
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class RepeatingFormPanelTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        RepeatingFormPanel component = new RepeatingFormPanel("id", Model.of("title"))
        {
            @Override
            protected void populateFormGroups(RepeatingView formGroupView)
            {
                super.populateFormGroups(formGroupView);
                formGroupView.add(new FormGroupInputText(formGroupView.newChildId(), Model.of("Text"), new Model<>()));
            }

            @Override
            protected void populateActions(RepeatingView buttonView)
            {
                super.populateActions(buttonView);
                buttonView.add(new SubmitLabelButton(buttonView.newChildId(), Model.of("Submit")));
            }
        };

        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        TagTester formTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assert.assertTrue(formTester.getAttributeContains("class", "panel"));
        Assert.assertTrue(formTester.getAttributeContains("class", "panel-default"));
    }
}
