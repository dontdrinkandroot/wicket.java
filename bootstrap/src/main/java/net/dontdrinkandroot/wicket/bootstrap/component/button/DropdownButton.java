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
import net.dontdrinkandroot.wicket.bootstrap.css.DropdownAlignment;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

/**
 * @param <T> Type of the model object.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class DropdownButton<T> extends GenericPanel<T> implements IButton
{
    protected ButtonBehavior buttonBehavior = new ButtonBehavior();

    protected IconBehavior iconBehavior = new IconBehavior(null, BootstrapCssClass.CARET);

    private IModel<String> labelModel;

    private Label toggle;

    private DropdownMenu menu;

    public DropdownButton(String id)
    {
        super(id);
        this.createComponents();
    }

    public DropdownButton(String id, IModel<T> model)
    {
        super(id, model);
        this.createComponents();
    }

    public DropdownButton(String id, IModel<T> model, IModel<String> labelModel)
    {
        super(id, model);
        this.labelModel = labelModel;
        this.createComponents();
    }

    protected void createComponents()
    {
        this.toggle = new Label("toggle", this.labelModel);
        this.toggle.add(new DropdownToggleBehavior());
        this.menu = this.createDropdownMenu("menu");
    }

    protected DropdownMenu createDropdownMenu(String id)
    {
        return new DropdownMenu(id)
        {
            @Override
            protected void populateItems(RepeatingView itemView)
            {
                DropdownButton.this.populateItems(itemView);
            }
        };
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.BTN_GROUP));
        this.toggle.add(this.buttonBehavior);
        this.toggle.add(this.iconBehavior);
        this.add(this.toggle);
        this.add(this.menu);
    }

    @Override
    public ButtonSize getButtonSize()
    {
        return this.buttonBehavior.getButtonSize();
    }

    @Override
    public DropdownButton<T> setButtonSize(ButtonSize buttonSize)
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
    public DropdownButton<T> setButtonStyle(ButtonStyle buttonStyle)
    {
        this.buttonBehavior.setButtonStyle(buttonStyle);
        return this;
    }

    @Override
    public DropdownButton<T> setButtonSizeModel(IModel<ButtonSize> buttonSizeModel)
    {
        this.buttonBehavior.setButtonSizeModel(buttonSizeModel);
        return this;
    }

    @Override
    public DropdownButton<T> setButtonStyleModel(IModel<ButtonStyle> buttonStyleModel)
    {
        this.buttonBehavior.setButtonStyleModel(buttonStyleModel);
        return this;
    }

    public Label getToggle()
    {
        return this.toggle;
    }

    public DropdownMenu getMenu()
    {
        return this.menu;
    }

    public DropdownButton<T> setDropdownAlignment(DropdownAlignment alignment)
    {
        this.menu.setAlignment(alignment);
        return this;
    }

    protected abstract void populateItems(RepeatingView itemView);

    public IconBehavior getIconBehavior()
    {
        return this.iconBehavior;
    }
}
