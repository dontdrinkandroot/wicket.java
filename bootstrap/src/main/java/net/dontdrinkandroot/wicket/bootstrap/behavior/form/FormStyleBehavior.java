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
package net.dontdrinkandroot.wicket.bootstrap.behavior.form;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize;
import net.dontdrinkandroot.wicket.model.CssClassToggleModel;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;


public class FormStyleBehavior extends Behavior
{

    private ColumnSize containerSize;

    private boolean inline = false;

    @Override
    public void bind(Component component)
    {
        super.bind(component);
        component.add(new CssClassAppender(new CssClassToggleModel(BootstrapCssClass.FORM_HORIZONTAL)
        {

            @Override
            protected boolean isActive()
            {
                return FormStyleBehavior.this.isHorizontal();
            }
        }));
        component.add(new CssClassAppender(new CssClassToggleModel(BootstrapCssClass.FORM_INLINE)
        {

            @Override
            protected boolean isActive()
            {
                return FormStyleBehavior.this.isInline();
            }
        }));
    }

    public boolean isInline()
    {
        return this.inline;
    }

    public boolean isHorizontal()
    {
        return null != this.containerSize;
    }

    /**
     * Apply horizontal style to form. Specify the ColumnSize for the container component, the ColumnSize for the label
     * component will be computed.
     */
    public FormStyleBehavior setHorizontal(ColumnSize containerSize)
    {
        this.inline = false;
        this.containerSize = containerSize;
        return this;
    }

    public FormStyleBehavior setInline(boolean inline)
    {
        this.inline = inline;
        this.containerSize = null;
        return this;
    }

    public void reset()
    {
        this.inline = false;
        this.containerSize = null;
    }

    public ColumnSize getLabelSize()
    {
        return this.containerSize.getInverseColumnSize();
    }

    public ColumnSize getContainerSize()
    {
        return this.containerSize;
    }

}
