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
package net.dontdrinkandroot.wicket.bootstrap.component.button;

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
public class DropdownButtonTest extends AbstractWicketTest
{
    @Test
    public void testDefault()
    {
        DropdownButton<Void> component = new DropdownButton<Void>("id", null, Model.of("LabelText"))
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {

            }
        };
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        TagTester componentTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "id");
        Assert.assertTrue(componentTester.getAttributeContains("class", "btn-group"));

        TagTester toggleTester =
                TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "toggle");
        Assert.assertEquals(
                "<button wicket:id=\"toggle\" type=\"button\" class=\"dropdown-toggle btn btn-secondary\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">LabelText&nbsp;&nbsp;<span class=\"caret\"></span></button>",
                toggleTester.getMarkup()
        );
        TagTester menuTester = TagTester.createTagByAttribute(componentMarkup.toString(), "wicket:id", "menu");
        Assert.assertEquals("<ul wicket:id=\"menu\" class=\"dropdown-menu\" role=\"menu\"><wicket:panel>\n" +
                "    \n" +
                "</wicket:panel></ul>", menuTester.getMarkup());
    }
}
