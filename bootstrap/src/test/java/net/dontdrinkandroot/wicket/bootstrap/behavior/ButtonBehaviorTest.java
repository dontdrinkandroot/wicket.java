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
package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

public class ButtonBehaviorTest extends AbstractWicketTest
{
    @Test
    public void testGettersSetters()
    {
        ButtonBehavior buttonBehavior = new ButtonBehavior(ButtonStyle.PRIMARY, ButtonSize.LARGE);
        Assert.assertEquals(ButtonStyle.PRIMARY, buttonBehavior.getButtonStyle());
        Assert.assertEquals(ButtonSize.LARGE, buttonBehavior.getButtonSize());

        buttonBehavior.setButtonStyle(ButtonStyle.DANGER);
        Assert.assertEquals(ButtonStyle.DANGER, buttonBehavior.getButtonStyle());

        buttonBehavior.setButtonStyleModel(Model.of(ButtonStyle.INFO));
        Assert.assertEquals(ButtonStyle.INFO, buttonBehavior.getButtonStyle());

        buttonBehavior.setButtonSize(ButtonSize.SMALL);
        Assert.assertEquals(ButtonSize.SMALL, buttonBehavior.getButtonSize());
    }

    @Test
    public void testDefaultMarkup()
    {
        WebMarkupContainer buttonContainer = new WebMarkupContainer("id");
        buttonContainer.add(new ButtonBehavior());
        CharSequence componentMarkup = ComponentRenderer.renderComponent(buttonContainer);

        TagTester tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assert.assertTrue(tagTester.getAttributeContains("class", "btn"));
        Assert.assertTrue(tagTester.getAttributeContains("class", "btn-secondary"));
        Assert.assertFalse(tagTester.getAttributeContains("class", "disabled"));
    }

    @Test
    public void testDisabledMarkup()
    {
        WebMarkupContainer buttonContainer = new WebMarkupContainer("id");
        buttonContainer.setEnabled(false);
        buttonContainer.add(new ButtonBehavior());
        CharSequence componentMarkup = ComponentRenderer.renderComponent(buttonContainer);

        TagTester tagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assert.assertTrue(tagTester.getAttributeContains("class", "btn"));
        Assert.assertTrue(tagTester.getAttributeContains("class", "btn-secondary"));
        Assert.assertTrue(tagTester.getAttributeContains("class", "disabled"));
    }
}
