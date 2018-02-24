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
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class AjaxSubmitButton extends AjaxSubmitLink implements IButton
{
    protected ButtonBehavior buttonBehavior = new ButtonBehavior(Model.of(ButtonStyle.PRIMARY));

    public AjaxSubmitButton(String id)
    {
        super(id);
    }

    public AjaxSubmitButton(String id, IModel<String> bodyModel)
    {
        super(id);
        this.setBody(bodyModel);
    }

    public AjaxSubmitButton(String id, Form<?> form)
    {
        super(id, form);
    }

    public AjaxSubmitButton(String id, Form<?> form, IModel<String> bodyModel)
    {
        super(id, form);
        this.setBody(bodyModel);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();
        this.add(this.buttonBehavior);
    }

    @Override
    public ButtonSize getButtonSize()
    {
        return this.buttonBehavior.getButtonSize();
    }

    @Override
    public AjaxSubmitButton setButtonSize(ButtonSize buttonSize)
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
    public AjaxSubmitButton setButtonStyle(ButtonStyle buttonStyle)
    {
        this.buttonBehavior.setButtonStyle(buttonStyle);
        return this;
    }

    @Override
    public AjaxSubmitButton setButtonSizeModel(IModel<ButtonSize> buttonSizeModel)
    {
        this.buttonBehavior.setButtonSizeModel(buttonSizeModel);
        return this;
    }

    @Override
    public AjaxSubmitButton setButtonStyleModel(IModel<ButtonStyle> buttonStyleModel)
    {
        this.buttonBehavior.setButtonStyleModel(buttonStyleModel);
        return this;
    }

    @Override
    protected void onError(AjaxRequestTarget target)
    {
        super.onError(target);
        target.add(this.getForm());
    }
}
