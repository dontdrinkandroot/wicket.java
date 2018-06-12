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

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class RepeatingFormTest extends AbstractWicketTest
{
    @Test
    public void testPlainMarkup()
    {
        RepeatingForm component = new RepeatingForm("id");
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
}
