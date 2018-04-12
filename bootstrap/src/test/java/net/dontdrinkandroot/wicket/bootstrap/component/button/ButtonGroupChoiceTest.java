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
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ButtonGroupChoiceTest extends AbstractWicketTest
{
    @Test
    public void testDefault()
    {
        List<String> choices = Arrays.asList("Alpha", "Beta", "Gamma");
        ButtonGroupChoice<String> component =
                new ButtonGroupChoice<String>("id", Model.of("Beta"), choices);
        CharSequence componentMarkup = ComponentRenderer.renderComponent(component);
        Assert.assertEquals("<wicket:container wicket:id=\"id\" id=\"id1\" class=\"btn-group\"><wicket:panel>\n" +
                "\t\t<a href=\"javascript:;\" wicket:id=\"choice\" class=\"btn btn btn-secondary\" id=\"id12\">Alpha</a><a href=\"javascript:;\" wicket:id=\"choice\" class=\"btn btn btn-secondary active\" id=\"id23\">Beta</a><a href=\"javascript:;\" wicket:id=\"choice\" class=\"btn btn btn-secondary\" id=\"id34\">Gamma</a>\n" +
                "\t</wicket:panel></wicket:container>", componentMarkup.toString());
    }
}
