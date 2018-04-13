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
import org.junit.Assert;
import org.junit.Test;

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
        Assert.assertTrue(componentTester.getAttributeContains("class", "progress"));

        TagTester barTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "bar");
        Assert.assertEquals("progress-bar", barTester.getAttribute("class"));
        Assert.assertEquals("progressbar", barTester.getAttribute("role"));
        Assert.assertEquals("0", barTester.getAttribute("aria-valuemin"));
        Assert.assertEquals("100", barTester.getAttribute("aria-valuemax"));
        Assert.assertEquals("33", barTester.getAttribute("aria-valuenow"));
        Assert.assertEquals("width: 33%;", barTester.getAttribute("style"));
        Assert.assertTrue(barTester.hasAttribute("id"));
    }

    @Test
    public void testStripedAnimatedMarkup()
    {
        ProgressBar component = new ProgressBar("id", Model.of(33));

        Assert.assertFalse(component.isStriped());
        component.setStriped(true);
        Assert.assertTrue(component.isStriped());

        Assert.assertFalse(component.isAnimated());
        component.setAnimated(true);
        Assert.assertTrue(component.isAnimated());

        Assert.assertTrue(component.isAnimated());
        String componentMarkup = ComponentRenderer.renderComponent(component).toString();

        System.out.println(componentMarkup);

        TagTester componentTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id");
        Assert.assertTrue(componentTester.getAttributeContains("class", "progress"));

        TagTester barTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "bar");
        Assert.assertTrue(barTester.getAttributeContains("class", "progress-bar"));
        Assert.assertTrue(barTester.getAttributeContains("class", "progress-bar-animated"));
        Assert.assertTrue(barTester.getAttributeContains("class", "progress-bar-striped"));
        Assert.assertEquals("progressbar", barTester.getAttribute("role"));
        Assert.assertEquals("0", barTester.getAttribute("aria-valuemin"));
        Assert.assertEquals("100", barTester.getAttribute("aria-valuemax"));
        Assert.assertEquals("33", barTester.getAttribute("aria-valuenow"));
        Assert.assertEquals("width: 33%;", barTester.getAttribute("style"));
        Assert.assertTrue(barTester.hasAttribute("id"));
    }
}
