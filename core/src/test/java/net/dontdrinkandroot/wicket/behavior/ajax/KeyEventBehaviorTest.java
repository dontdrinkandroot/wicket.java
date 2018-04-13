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
package net.dontdrinkandroot.wicket.behavior.ajax;

import net.dontdrinkandroot.wicket.test.AbstractWicketTest;
import net.dontdrinkandroot.wicket.test.TestPage;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class KeyEventBehaviorTest extends AbstractWicketTest
{
    @Test
    public void testKeyup()
    {
        TestPage page = new TestPage()
        {
            @Override
            protected void onInitialize()
            {
                super.onInitialize();
                this.add(new KeyEventBehavior()
                {
                    @Override
                    protected void onEvent(AjaxRequestTarget target, KeyEventResponse keyPressResponse)
                    {
                        Assert.assertEquals(-1, keyPressResponse.getCharCode());
                        Assert.assertEquals(-1, keyPressResponse.getKeyCode());
                        Assert.assertEquals(-1, keyPressResponse.getWhich());
                        Assert.assertFalse(keyPressResponse.isAltKey());
                        Assert.assertFalse(keyPressResponse.isCtrlKey());
                        Assert.assertFalse(keyPressResponse.isMetaKey());
                        Assert.assertFalse(keyPressResponse.isShiftKey());
                    }
                });
            }
        };

        this.tester.startPage(page);
        this.tester.debugComponentTrees();
        this.tester.executeAjaxEvent(page, "keyup");
    }
}
