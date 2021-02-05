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
package net.dontdrinkandroot.wicket.bootstrap.component.progress;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ProgressBarTest extends AbstractWicketTest
{
    @Test
    public void testDefaultMarkup()
    {
        ProgressBar component = new ProgressBar("id", Model.of(33));
        String componentMarkup = ComponentRenderer.renderComponent(component).toString();

        TagTester componentTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id");
        Assertions.assertTrue(componentTester.getAttributeContains("class", "progress"));

        TagTester barTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "bar");
        Assertions.assertEquals("progress-bar", barTester.getAttribute("class"));
        Assertions.assertEquals("progressbar", barTester.getAttribute("role"));
        Assertions.assertEquals("0", barTester.getAttribute("aria-valuemin"));
        Assertions.assertEquals("100", barTester.getAttribute("aria-valuemax"));
        Assertions.assertEquals("33", barTester.getAttribute("aria-valuenow"));
        Assertions.assertEquals("width: 33%;", barTester.getAttribute("style"));
        Assertions.assertTrue(barTester.hasAttribute("id"));
    }

    @Test
    public void testStripedAnimatedMarkup()
    {
        ProgressBar component = new ProgressBar("id", Model.of(33));

        Assertions.assertFalse(component.isStriped());
        component.setStriped(true);
        Assertions.assertTrue(component.isStriped());

        Assertions.assertFalse(component.isAnimated());
        component.setAnimated(true);
        Assertions.assertTrue(component.isAnimated());

        Assertions.assertTrue(component.isAnimated());
        String componentMarkup = ComponentRenderer.renderComponent(component).toString();

        TagTester componentTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id");
        Assertions.assertTrue(componentTester.getAttributeContains("class", "progress"));

        TagTester barTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "bar");
        Assertions.assertTrue(barTester.getAttributeContains("class", "progress-bar"));
        Assertions.assertTrue(barTester.getAttributeContains("class", "progress-bar-animated"));
        Assertions.assertTrue(barTester.getAttributeContains("class", "progress-bar-striped"));
        Assertions.assertEquals("progressbar", barTester.getAttribute("role"));
        Assertions.assertEquals("0", barTester.getAttribute("aria-valuemin"));
        Assertions.assertEquals("100", barTester.getAttribute("aria-valuemax"));
        Assertions.assertEquals("33", barTester.getAttribute("aria-valuenow"));
        Assertions.assertEquals("width: 33%;", barTester.getAttribute("style"));
        Assertions.assertTrue(barTester.hasAttribute("id"));
    }
}
