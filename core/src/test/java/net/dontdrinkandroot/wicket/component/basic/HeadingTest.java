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
package net.dontdrinkandroot.wicket.component.basic;

import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.WicketTestCase;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class HeadingTest extends WicketTestCase
{
    @Test
    public void testMarkup()
    {
        Heading heading;
        String markup;

        heading = new Heading("id", Heading.Level.H1);
        markup = ComponentRenderer.renderComponent(heading).toString();
        Assert.assertEquals("<wicket:h1 wicket:id=\"id\"></wicket:h1>", markup);

        heading = new Heading("id", "Heading2", Heading.Level.H2);
        markup = ComponentRenderer.renderComponent(heading).toString();
        Assert.assertEquals("<wicket:h2 wicket:id=\"id\">Heading2</wicket:h2>", markup);

        heading = new Heading("id", Model.of("Heading3"), Heading.Level.H3);
        markup = ComponentRenderer.renderComponent(heading).toString();
        Assert.assertEquals("<wicket:h3 wicket:id=\"id\">Heading3</wicket:h3>", markup);
    }
}
