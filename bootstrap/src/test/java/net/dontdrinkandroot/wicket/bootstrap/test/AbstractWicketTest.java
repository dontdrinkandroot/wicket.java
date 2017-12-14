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
package net.dontdrinkandroot.wicket.bootstrap.test;

import net.dontdrinkandroot.wicket.bootstrap.component.button.IButton;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.tester.WicketTester;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;

public class AbstractWicketTest
{
    protected WicketTester tester;

    @Before
    public void setUp()
    {
        this.tester = new WicketTester(new TestApplication());
    }

    @After
    public void tearDown()
    {
        this.tester.destroy();
    }

    public void testIButton(IButton component)
    {
        component.setButtonSize(ButtonSize.LARGE);
        Assert.assertEquals(ButtonSize.LARGE, component.getButtonSize());

        component.setButtonStyle(ButtonStyle.DANGER);
        Assert.assertEquals(ButtonStyle.DANGER, component.getButtonStyle());

        component.setButtonSizeModel(Model.of(ButtonSize.SMALL));
        Assert.assertEquals(ButtonSize.SMALL, component.getButtonSize());

        component.setButtonStyleModel(Model.of(ButtonStyle.WARNING));
        Assert.assertEquals(ButtonStyle.WARNING, component.getButtonStyle());
    }
}
