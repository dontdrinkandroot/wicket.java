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

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior;
import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.NavStyle;
import net.dontdrinkandroot.wicket.model.CssClassToggleModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class NavPillsBehavior extends CompositeBehavior
{
    private IModel<Boolean> justifiedModel = Model.of(Boolean.FALSE);

    private IModel<Boolean> stackedModel = Model.of(Boolean.FALSE);

    public NavPillsBehavior()
    {
        super(new CssClassAppender(BootstrapCssClass.NAV), new CssClassAppender(NavStyle.NAV_PILLS));
        this.addBehavior(new CssClassAppender(new CssClassToggleModel(
                this.justifiedModel,
                BootstrapCssClass.NAV_JUSTIFIED
        )));
        this.addBehavior(new CssClassAppender(new CssClassToggleModel(
                this.stackedModel,
                BootstrapCssClass.NAV_STACKED
        )));
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
