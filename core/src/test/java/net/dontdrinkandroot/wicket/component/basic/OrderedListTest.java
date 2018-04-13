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

import net.dontdrinkandroot.wicket.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.test.TestPage;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class OrderedListTest extends AbstractWicketTest
{
    @Test
    public void testDefault()
    {
        TestPage page = new TestPage()
        {
            @Override
            protected void populateComponents(RepeatingView componentView)
            {
                OrderedList<String> component =
                        new OrderedList<String>(
                                componentView.newChildId(),
                                new ListModel<>(Arrays.asList("Alpha", "Beta", "Gamma"))
                        )
                        {
                            @Override
                            protected Component createListComponent(String id, IModel<String> model)
                            {
                                return new Label(id, model);
                            }
                        };
                componentView.add(component);
            }
        };

        this.tester.startPage(page);
        CharSequence pageMarkup = this.tester.getLastResponseAsString();
        TagTester componentTester = TagTester.createTagByAttribute(pageMarkup.toString(), "wicket:id", "component");
        String componentMarkup = componentTester.getMarkup();
        Assert.assertEquals("<ol wicket:id=\"component\"><wicket:panel>\n" +
                "\t\t<li wicket:id=\"item\">Alpha</li><li wicket:id=\"item\">Beta</li><li wicket:id=\"item\">Gamma</li>\n" +
                "\t</wicket:panel></ol>", componentMarkup);
    }
}
