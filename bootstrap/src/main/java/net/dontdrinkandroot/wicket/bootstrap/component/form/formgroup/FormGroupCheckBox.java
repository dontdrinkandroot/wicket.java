/**
 * Copyright (C) 2012-2014 Philip W. Sorst <philip@sorst.net>
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
package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.component.form.FormHorizontal;


public class FormGroupCheckBox extends AbstractFormGroup<Boolean, CheckBox>
{

	private WebMarkupContainer offset;


	public FormGroupCheckBox(String id, IModel<Boolean> model, String label)
	{
		super(id, model, label);
	}

	public FormGroupCheckBox(String id, IModel<Boolean> model, IModel<String> labelModel)
	{
		super(id, model, labelModel);
	}

	@Override
	protected CheckBox createFormComponent(String id)
	{
		return new CheckBox(id, this.getModel());
	}

	@Override
	protected void onInitialize()
	{
		this.offset = new WebMarkupContainer("offset");
		super.onInitialize();
	}

	@Override
	protected void applyComponentAdd()
	{
		this.add(this.componentContainer);
		this.componentContainer.add(this.formComponent);
		this.componentContainer.add(this.label);
		this.componentContainer.add(this.helpBlock);
		this.add(this.offset);
	}

	@Override
	protected void applyHorizontalStyle(Form<?> form)
	{
		this.offset.add(new CssClassAppender(((FormHorizontal<?>) form).getLabelColumnSize()));
		this.componentContainer.add(new CssClassAppender(((FormHorizontal<?>) form).getFormComponentColumnSize()));
	}

}
