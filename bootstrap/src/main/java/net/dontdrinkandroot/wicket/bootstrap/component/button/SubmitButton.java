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
package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.SubmitLink;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;


public class SubmitButton extends SubmitLink implements IButton
{

	protected ButtonBehavior buttonBehavior = new ButtonBehavior();


	public SubmitButton(String id)
	{
		super(id);
	}

	public SubmitButton(String id, IModel<?> model)
	{
		super(id, model);
	}

	public SubmitButton(String id, Form<?> form)
	{
		super(id, form);
	}

	public SubmitButton(String id, IModel<?> model, Form<?> form)
	{
		super(id, model, form);
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
	public SubmitButton setButtonSize(ButtonSize buttonSize)
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
	public SubmitButton setButtonStyle(ButtonStyle buttonStyle)
	{
		this.buttonBehavior.setButtonStyle(buttonStyle);
		return this;
	}

	@Override
	public SubmitButton setButtonSizeModel(IModel<ButtonSize> buttonSizeModel)
	{
		this.buttonBehavior.setButtonSizeModel(buttonSizeModel);
		return this;
	}

	@Override
	public SubmitButton setButtonStyleModel(IModel<ButtonStyle> buttonStyleModel)
	{
		this.buttonBehavior.setButtonStyleModel(buttonStyleModel);
		return this;
	}
}
