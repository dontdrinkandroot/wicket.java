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
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormContainerSizeBehavior;
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormLabelSizeBehavior;


public class FormGroupCheckBox extends FormGroupFormComponent<Boolean, CheckBox>
{

	private WebMarkupContainer offset;


	public FormGroupCheckBox(String id, IModel<String> labelModel, IModel<Boolean> model)
	{
		super(id, labelModel, model);
	}

	@Override
	protected CheckBox createFormComponent(String id)
	{
		return new CheckBox(id, this.getModel());
	}

	@Override
	protected void onInitialize()
	{

		super.onInitialize();
	}

	@Override
	protected void createComponents()
	{
		super.createComponents();
		this.offset = new WebMarkupContainer("offset");
	}

	@Override
	protected void addComponents()
	{
		this.add(this.offset);
		this.add(this.container);
		this.container.add(this.helpBlock);
		this.container.add(this.label);
		this.container.add(this.formComponent);
	}

	@Override
	protected void addBehaviors()
	{
		this.offset.add(new FormLabelSizeBehavior());
		this.container.add(new FormContainerSizeBehavior());
	}
}
