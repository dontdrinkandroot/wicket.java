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

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

import java.io.Serializable;

/**
 * A {@link Label} with {@link ButtonBehavior}.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class LabelButton extends Label implements IButton
{
    protected ButtonBehavior buttonBehavior = new ButtonBehavior();

    public LabelButton(String id)
    {
        super(id);
    }

    public LabelButton(String id, Serializable label)
    {
        super(id, label);
    }

    public LabelButton(String id, IModel<?> model)
    {
        super(id, model);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();
        this.add(this.buttonBehavior);
    }

    @Override
    public LabelButton setButtonStyle(ButtonStyle buttonStyle)
    {
        this.buttonBehavior.setButtonStyle(buttonStyle);
        return this;
    }

    @Override
    public LabelButton setButtonSize(ButtonSize buttonSize)
    {
        this.buttonBehavior.setButtonSize(buttonSize);
        return this;
    }

    @Override
    public ButtonSize getButtonSize()
    {
        return this.buttonBehavior.getButtonSize();
    }

    @Override
    public ButtonStyle getButtonStyle()
    {
        return this.buttonBehavior.getButtonStyle();
    }

    @Override
    public LabelButton setButtonSizeModel(IModel<ButtonSize> buttonSizeModel)
    {
        this.buttonBehavior.setButtonSizeModel(buttonSizeModel);
        return this;
    }

    @Override
    public LabelButton setButtonStyleModel(IModel<ButtonStyle> buttonStyleModel)
    {
        this.buttonBehavior.setButtonStyleModel(buttonStyleModel);
        return this;
    }
}
