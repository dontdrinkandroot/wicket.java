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
package net.dontdrinkandroot.wicket.bootstrap.component.nav;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class NavTabsTest extends AbstractWicketTest
{
    @Test
    public void testDefaultMarkup()
    {
        RepeatingNavTabs component = new RepeatingNavTabs("id");
        String markup = ComponentRenderer.renderComponent(component).toString();
        TagTester tagTester = TagTester.createTagByAttribute(markup, "wicket:id", "id");
        Assert.assertEquals("nav nav-tabs", tagTester.getAttribute("class"));
    }

    @Test
    public void testJustifiedMarkup()
    {
        RepeatingNavTabs component = new RepeatingNavTabs("id");
        component.setJustified(true);
        String markup = ComponentRenderer.renderComponent(component).toString();
        TagTester tagTester = TagTester.createTagByAttribute(markup, "wicket:id", "id");
        Assert.assertEquals("nav nav-tabs nav-justified", tagTester.getAttribute("class"));
    }
}
