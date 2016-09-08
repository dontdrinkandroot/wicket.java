/*
 * Copyright (C) 2012-2016 Philip Washington Sorst <philip@sorst.net>
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

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.model.CssClassToggleModel;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class NavPillsBehavior extends Behavior
{

    private IModel<Boolean> justifiedModel = Model.of(Boolean.FALSE);

    private IModel<Boolean> stackedModel = Model.of(Boolean.FALSE);

    @Override
    public void bind(Component component)
    {
        super.bind(component);

        component.add(new CssClassAppender(BootstrapCssClass.NAV));
        component.add(new CssClassAppender(BootstrapCssClass.NAV_PILLS));
        component.add(
                new CssClassAppender(new CssClassToggleModel(this.justifiedModel, BootstrapCssClass.NAV_JUSTIFIED)));
        component.add(new CssClassAppender(new CssClassToggleModel(this.stackedModel, BootstrapCssClass.NAV_STACKED)));
    }

    public void setJustified(boolean justified)
    {
        this.justifiedModel.setObject(justified);
    }

    public void setStacked(boolean stacked)
    {
        this.stackedModel.setObject(stacked);
    }
}
