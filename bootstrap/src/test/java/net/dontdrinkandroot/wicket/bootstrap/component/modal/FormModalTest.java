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
package net.dontdrinkandroot.wicket.bootstrap.component.modal;

import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest;
import org.apache.wicket.core.util.string.ComponentRenderer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormModalTest extends AbstractWicketTest
{
    @Test
    public void testDefaultMarkup()
    {
        FormModal<String> component = new FormModal<String>("modalId")
        {
            @Override
            protected IModel<String> createHeadingModel()
            {
                return Model.of("Modal Heading");
            }
        };
        String componentMarkup = ComponentRenderer.renderComponent(component).toString();

        TagTester tester;

        tester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "modalId");
        Assert.assertTrue(tester.getAttributeContains("class", "modal"));
        Assert.assertTrue(tester.getAttributeContains("class", "fade"));

        tester = TagTester.createTagByAttribute(componentMarkup, "wicket:id", "heading");
        Assert.assertEquals("Modal Heading", tester.getValue());
    }
}
