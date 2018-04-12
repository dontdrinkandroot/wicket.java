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
public class ButtonTest extends AbstractWicketTest
{
    @Test
    public void testIButton()
    {
        Button<Void> component = new Button<Void>("id")
        {
            @Override
            public void onClick()
            {
                /* Noop */
            }
        };
        component.setBody(Model.of("Label"));
        this.testIButton(component);
    }

    @Test
    public void testMarkup()
    {
        Button<Void> component = new Button<Void>("id")
        {

            @Override
            public void onClick()
            {
                /* Noop */
            }
        };
        component.setBody(Model.of("Label"));

        String componentMarkup = ComponentRenderer.renderComponent(component).toString();
        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" onclick=\"var win = this.ownerDocument.defaultView || this.ownerDocument.parentWindow; if (win == window) { window.location.href=&#039;./wicket/page?0-0.-id&#039;; } ;return false\" class=\"btn btn-secondary\">Label</wicket:container>",
                componentMarkup
        );
    }
}
