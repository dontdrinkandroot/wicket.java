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
package net.dontdrinkandroot.wicket.behavior;

import net.dontdrinkandroot.wicket.css.StringCssClass;
import net.dontdrinkandroot.wicket.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class CompositeBehaviorTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        WebMarkupContainer component = new WebMarkupContainer("id");

        CompositeBehavior behavior = new CompositeBehavior();
        behavior.addBehavior(new CssClassAppender(new StringCssClass("cssclass")));
        behavior.addBehavior(new TitleModifier("Title"));

        component.add(behavior);

        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" class=\"cssclass\" title=\"Title\"></wicket:container>",
                componentMarkup.toString()
        );
    }
}
