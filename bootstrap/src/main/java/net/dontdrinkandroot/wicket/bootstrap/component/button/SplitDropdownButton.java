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
package net.dontdrinkandroot.wicket.bootstrap.component.button;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.behavior.DropdownToggleBehavior;
import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

abstract public class SplitDropdownButton<T> extends GenericPanel<T> implements IButton
{
    private ButtonBehavior buttonBehavior = new ButtonBehavior();

    private WebMarkupContainer toggle;

    public SplitDropdownButton(String id)
    {
        super(id);
    }

    public SplitDropdownButton(String id, IModel<T> model)
    {
        super(id, model);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.BTN_GROUP));

        Component action = this.createAction("button");
        action.add(this.buttonBehavior);
        this.add(action);

        this.toggle = new WebMarkupContainer("toggle");
        this.toggle.add(this.buttonBehavior);
        this.toggle.add(new DropdownToggleBehavior());
        this.toggle.add(new IconBehavior().setAppendIcon(this.getCaretClass()).setSeparator(null));
        this.add(this.toggle);

        this.add(this.createDropdownMenu("dropdownMenu"));
    }

    public WebMarkupContainer getToggle()
    {
        return this.toggle;
    }

    protected Component createDropdownMenu(String id)
    {
        return new DropdownMenu(id)
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                SplitDropdownButton.this.populateItems(itemView);
            }
        };
    }

    @Override
    public ButtonSize getButtonSize()
    {
        return this.buttonBehavior.getButtonSize();
    }

    @Override
    public SplitDropdownButton<T> setButtonSize(ButtonSize buttonSize)
    {
        this.buttonBehavior.setButtonSize(buttonSize);
        return this;
    }

    @Override
    public ButtonStyle getButtonStyle()
    {
        return this.buttonBehavior.getButtonStyle();
    }

    @Override
    public SplitDropdownButton<T> setButtonStyle(ButtonStyle buttonStyle)
    {
        this.buttonBehavior.setButtonStyle(buttonStyle);
        return this;
    }

    @Override
    public SplitDropdownButton<T> setButtonSizeModel(IModel<ButtonSize> buttonSizeModel)
    {
        this.buttonBehavior.setButtonSizeModel(buttonSizeModel);
        return this;
    }

    @Override
    public SplitDropdownButton<T> setButtonStyleModel(IModel<ButtonStyle> buttonStyleModel)
    {
        this.buttonBehavior.setButtonStyleModel(buttonStyleModel);
        return this;
    }

    protected BootstrapCssClass getCaretClass()
    {
        return BootstrapCssClass.CARET;
    }

    protected abstract Component createAction(String id);

    protected abstract void populateItems(RepeatingView itemView);
}
