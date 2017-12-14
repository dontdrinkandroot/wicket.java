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
package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

public class ToolTipBehaviorTest extends AbstractWicketTest
{
    @Test
    public void testDefaultMarkup()
    {
        WebMarkupContainer container = new WebMarkupContainer("id");
        container.add(new ToolTipBehavior(Model.of("TestText")));
        CharSequence componentMarkup = ComponentRenderer.renderComponent(container);

        Assert.assertEquals(
                "<wicket:container wicket:id=\"id\" title=\"TestText\" data-toggle=\"tooltip\" data-placement=\"top\" data-delay=\"0\"></wicket:container>",
                componentMarkup.toString()
        );
    }

    @Test
    public void testPosition()
    {
        WebMarkupContainer container = new WebMarkupContainer("id");
        ToolTipBehavior behavior = new ToolTipBehavior(Model.of("TestText"));
        container.add(behavior);

        TagTester tagTester;
        String componentMarkup;
        IModel<ToolTipBehavior.Position> positionModel = new Model<>();

        positionModel.setObject(ToolTipBehavior.Position.TOP);
        componentMarkup = ComponentRenderer.renderComponent(container).toString();
        tagTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id");
        tagTester.getAttributeIs("data-placement", "top");

        positionModel.setObject(ToolTipBehavior.Position.RIGHT);
        componentMarkup = ComponentRenderer.renderComponent(container).toString();
        tagTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id");
        tagTester.getAttributeIs("data-placement", "right");

        positionModel.setObject(ToolTipBehavior.Position.BOTTOM);
        componentMarkup = ComponentRenderer.renderComponent(container).toString();
        tagTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id");
        tagTester.getAttributeIs("data-placement", "bottom");

        positionModel.setObject(ToolTipBehavior.Position.LEFT);
        componentMarkup = ComponentRenderer.renderComponent(container).toString();
        tagTester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "id");
        tagTester.getAttributeIs("data-placement", "left");
    }
}
