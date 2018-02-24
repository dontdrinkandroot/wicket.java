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
package net.dontdrinkandroot.wicket.bootstrap.component.panel;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class SimplePanelTest extends AbstractWicketTest
{
    @Test
    public void testDefaultMarkup()
    {
        SimplePanel<String> component = new SimplePanel<String>("id", Model.of("Nothing"), Model.of("title"));
        String componentMarkup = ComponentRenderer.renderComponent(component).toString();

        TagTester componentTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id");
        Assert.assertTrue(componentTester.getAttributeIs("class", "panel panel-default"));

        TagTester headingTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "heading");
        Assert.assertTrue(headingTester.getAttributeIs("class", "panel-heading"));

        TagTester titleTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "title");
        Assert.assertTrue(titleTester.getAttributeIs("class", "panel-title"));
    }
}