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
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.model.IModel;


public class FormGroupPasswordTextField extends AbstractFormGroupTextField<String, PasswordTextField>
{

	public FormGroupPasswordTextField(String id, IModel<String> labelModel, IModel<String> model)
	{
		super(id, model, labelModel);
	}

	@Override
	protected PasswordTextField createFormComponent(String id)
	{
		PasswordTextField passwordField = new PasswordTextField(id, this.getModel());
		passwordField.add(new HTML5Attributes());
		return passwordField;
	}
}
