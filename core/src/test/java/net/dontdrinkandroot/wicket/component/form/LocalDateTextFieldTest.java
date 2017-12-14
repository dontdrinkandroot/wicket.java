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
package net.dontdrinkandroot.wicket.component.form;

import net.dontdrinkandroot.wicket.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.test.InputTestPage;
import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.TagTester;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LocalDateTextFieldTest extends AbstractWicketTest
{
    @Test
    public void testBasicAttributes()
    {
        LocalDateTextField component =
                new LocalDateTextField("id", Model.of(LocalDate.of(2017, 2, 3)));
        component.setOutputMarkupId(true);
        component.setMin(LocalDate.of(2017, 1, 1));
        component.setMax(LocalDate.of(2018, 12, 31));
        component.setRequired(true);
        component.add(new HTML5Attributes());
        InputTestPage page = new InputTestPage(component, "date");
        this.tester.startPage(page);

        TagTester tagTester = this.tester.getTagById(component.getMarkupId());
        Assert.assertNotNull(tagTester);
        Assert.assertEquals("2017-02-03", tagTester.getAttribute("value"));
        Assert.assertEquals("2017-01-01", tagTester.getAttribute("min"));
        Assert.assertEquals("2018-12-31", tagTester.getAttribute("max"));
        Assert.assertEquals("required", tagTester.getAttribute("required"));
    }
}
