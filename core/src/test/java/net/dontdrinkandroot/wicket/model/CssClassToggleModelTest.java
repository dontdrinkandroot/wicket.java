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
package net.dontdrinkandroot.wicket.model;

import net.dontdrinkandroot.wicket.css.StringCssClass;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class CssClassToggleModelTest
{
    @Test
    public void testByModelActive()
    {
        IModel<Boolean> activeModel = Model.of(Boolean.FALSE);

        StringCssClass activeClass = new StringCssClass("active");

        CssClassToggleModel model = new CssClassToggleModel(activeModel, activeClass);
        Assert.assertNull(model.getObject());

        activeModel.setObject(Boolean.TRUE);
        Assert.assertEquals(activeClass, model.getObject());
    }

    @Test
    public void testByModelActiveInactive()
    {
        IModel<Boolean> activeModel = Model.of(Boolean.FALSE);

        StringCssClass activeClass = new StringCssClass("active");
        StringCssClass inactiveClass = new StringCssClass("inactive");

        CssClassToggleModel model = new CssClassToggleModel(activeModel, activeClass, inactiveClass);
        Assert.assertEquals(inactiveClass, model.getObject());

        activeModel.setObject(Boolean.TRUE);
        Assert.assertEquals(activeClass, model.getObject());
    }

    @Test
    public void testActiveInactiveAnonymous()
    {
        IModel<Boolean> activeModel = Model.of(Boolean.FALSE);

        StringCssClass activeClass = new StringCssClass("active");
        StringCssClass inactiveClass = new StringCssClass("inactive");

        CssClassToggleModel model = new CssClassToggleModel(activeClass)
        {
            @Override
            protected boolean isActive()
            {
                return activeModel.getObject();
            }
        };
        Assert.assertNull(model.getObject());

        activeModel.setObject(Boolean.TRUE);
        Assert.assertEquals(activeClass, model.getObject());
    }

    @Test
    public void testWithoutModel()
    {
        StringCssClass activeClass = new StringCssClass("active");
        CssClassToggleModel model = new CssClassToggleModel(activeClass);
        Assert.assertEquals(activeClass, model.getObject());
    }
}
