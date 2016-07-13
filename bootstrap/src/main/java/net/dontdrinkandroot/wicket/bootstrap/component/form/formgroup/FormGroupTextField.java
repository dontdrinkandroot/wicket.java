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

import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;


public class FormGroupTextField<T> extends AbstractFormGroupTextField<T, TextField<T>>
{

	public FormGroupTextField(String id, IModel<String> labelModel, IModel<T> model)
	{
		super(id, labelModel, model);
	}

	public FormGroupTextField(String id, IModel<String> labelModel, IModel<T> model, Class<T> type)
	{
		super(id, labelModel, model, type);
	}

	@Override
	protected TextField<T> createFormComponent(String id)
	{
		TextField<T> textField = new TextField<T>(id, this.getModel(), this.type);
		textField.add(new HTML5Attributes());

		return textField;
	}
}
