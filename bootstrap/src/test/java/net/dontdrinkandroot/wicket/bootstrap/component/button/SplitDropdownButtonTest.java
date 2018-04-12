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
import org.apache.wicket.Component;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class SplitDropdownButtonTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        SplitDropdownButton<String> component = new SplitDropdownButton<String>("id")
        {
            @Override
            protected Component createAction(String id)
            {
                return new Label(id, "ActionLabel");
            }

            @Override
            protected void populateItems(RepeatingView itemView)
            {

            }
        };
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" class=\"btn-group\"><wicket:panel>\n" +
                        "\t\t<button wicket:id=\"button\" type=\"button\" class=\"btn btn-secondary\">ActionLabel</button>\n" +
                        "\t\t<button wicket:id=\"toggle\" type=\"button\" class=\"btn btn-secondary dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\n" +
                        "\t\t\t<span class=\"sr-only\">Toggle Dropdown</span>\n" +
                        "\t\t<span class=\"caret\"></span></button>\n" +
                        "\t\t<ul wicket:id=\"dropdownMenu\" class=\"dropdown-menu\" role=\"menu\"><wicket:panel>\n" +
                        "    \n" +
                        "</wicket:panel></ul>\n" +
                        "\t</wicket:panel></wicket:container>",
                componentMarkup.toString()
        );
    }
}
