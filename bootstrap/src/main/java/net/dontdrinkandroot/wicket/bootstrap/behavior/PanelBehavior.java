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
import net.dontdrinkandroot.wicket.bootstrap.css.PanelStyle;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class PanelBehavior extends CompositeBehavior
{
    private IModel<PanelStyle> styleModel = Model.of(PanelStyle.DEFAULT);

    public PanelBehavior()
    {
        this(Model.of(PanelStyle.DEFAULT));
    }

    public PanelBehavior(IModel<PanelStyle> styleModel)
    {
        super(new CssClassAppender(BootstrapCssClass.PANEL));
        this.styleModel = styleModel;
        this.addBehavior(new CssClassAppender(this.styleModel));
    }

    public void setStyle(PanelStyle style)
    {
        this.styleModel.setObject(style);
    }

    public PanelStyle getStyle()
    {
        return this.styleModel.getObject();
    }
}
