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
package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupAutoCompleteTest extends AbstractWicketTest
{
    @Test
    public void testMarkup()
    {
        FormGroupAutoComplete component = new FormGroupAutoComplete("id", Model.of("ExampleLabel"), new Model<>())
        {
            @Override
            protected List<String> getChoices(String input)
            {
                return Arrays.asList("Alpha", "Beta", "Gamma");
            }
        };
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" id=\"id1\" class=\"form-group dropdown autocomplete\"><wicket:panel>\n" +
                        "\t\t<label wicket:id=\"label\" class=\"control-label\" for=\"formComponent2\">ExampleLabel</label>\n" +
                        "\t\t\n" +
                        "\t\t\t<wicket:child><wicket:extend>\n" +
                        "\t\t<wicket:child><wicket:extend>\n" +
                        "    <input type=\"text\" wicket:id=\"formComponent\" class=\"form-control dropdown-toggle\" autocomplete=\"off\" value=\"\" name=\"id:container:formComponent\" id=\"formComponent2\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"/>\n" +
                        "    <ul class=\"dropdown-menu\" aria-labelledby=\"dropdownMenu\" wicket:id=\"dropdownMenu\" id=\"dropdownMenu3\">\n" +
                        "        <li wicket:id=\"suggestionItem\">\n" +
                        "            <a wicket:id=\"link\" id=\"link4\" href=\"javascript:;\">Alpha</a>\n" +
                        "        </li><li wicket:id=\"suggestionItem\">\n" +
                        "            <a wicket:id=\"link\" id=\"link5\" href=\"javascript:;\">Beta</a>\n" +
                        "        </li><li wicket:id=\"suggestionItem\">\n" +
                        "            <a wicket:id=\"link\" id=\"link6\" href=\"javascript:;\">Gamma</a>\n" +
                        "        </li>\n" +
                        "    </ul>\n" +
                        "</wicket:extend></wicket:child>\n" +
                        "\t\t<div id=\"helpBlock7\" style=\"display:none\"></div>\n" +
                        "\t</wicket:extend></wicket:child>\n" +
                        "\t\t\n" +
                        "\t</wicket:panel></wicket:container>",
                componentMarkup.toString()
        );
    }
}
