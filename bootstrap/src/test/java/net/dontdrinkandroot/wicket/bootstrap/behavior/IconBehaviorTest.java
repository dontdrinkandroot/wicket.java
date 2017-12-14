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

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.css.StringCssClass;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

public class IconBehaviorTest extends AbstractWicketTest
{
    @Test
    public void testEmptyIconBehavior()
    {
        WebMarkupContainer component = new WebMarkupContainer("id");
        component.add(new IconBehavior());
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);

        TagTester componentTagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assert.assertNotNull(componentTagTester);
        Assert.assertEquals("", componentTagTester.getValue());
    }

    @Test
    public void testIconOnly()
    {
        WebMarkupContainer component = new WebMarkupContainer("id");
        component.add(new IconBehavior().setPrependIcon(new StringCssClass("prependIconClass")));
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);

        TagTester componentTagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assert.assertNotNull(componentTagTester);
        Assert.assertEquals("<span class=\"prependIconClass\"></span>", componentTagTester.getValue());
    }

    @Test
    public void testPrependIcon()
    {
        Label component = new Label("id", Model.of("body"));
        IconBehavior iconBehavior = new IconBehavior().setPrependIcon(new StringCssClass("prependIconClass"));
        component.add(iconBehavior);

        Assert.assertEquals("prependIconClass", iconBehavior.getPrependIcon().getClassString());
        Assert.assertNull(iconBehavior.getAppendIcon());

        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);

        TagTester componentTagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assert.assertNotNull(componentTagTester);
        Assert.assertEquals("<span class=\"prependIconClass\"></span>&nbsp;&nbsp;body", componentTagTester.getValue());

        iconBehavior.setPrependIcon(new StringCssClass("prependIconClass2"));

        Assert.assertEquals("prependIconClass2", iconBehavior.getPrependIcon().getClassString());
        Assert.assertNull(iconBehavior.getAppendIcon());
    }

    @Test
    public void testAppendIcon()
    {
        Label component = new Label("id", Model.of("body"));
        IconBehavior iconBehavior = new IconBehavior().setAppendIcon(new StringCssClass("appendIconClass"));
        component.add(iconBehavior);

        Assert.assertEquals("appendIconClass", iconBehavior.getAppendIcon().getClassString());
        Assert.assertNull(iconBehavior.getPrependIcon());

        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);

        TagTester componentTagTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assert.assertNotNull(componentTagTester);
        Assert.assertEquals("body&nbsp;&nbsp;<span class=\"appendIconClass\"></span>", componentTagTester.getValue());

        iconBehavior.setAppendIcon(new StringCssClass("appendIconClass2"));

        Assert.assertEquals("appendIconClass2", iconBehavior.getAppendIcon().getClassString());
        Assert.assertNull(iconBehavior.getPrependIcon());
    }
}
