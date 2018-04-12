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

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LabelButtonTest extends AbstractWicketTest
{
    @Test
    public void testIButton()
    {
        LabelButton component = new LabelButton("id", Model.of("Label"));
        this.testIButton(component);
    }

    @Test
    public void testMarkup()
    {
        LabelButton component = new LabelButton("id", Model.of("Label"));

        String componentMarkup = ComponentRenderer.renderComponent(component).toString();
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" class=\"btn btn-secondary\">Label</wicket:container>",
                componentMarkup
        );
    }
}
