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

import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.IModel;


public class FormGroupTextArea<T> extends AbstractFormGroup<T, TextArea<T>>
{

	public FormGroupTextArea(String id, IModel<T> model, IModel<String> labelModel)
	{
		super(id, model, labelModel);
	}

	@Override
	protected TextArea<T> createFormComponent(String id)
	{
		return new TextArea<T>(id, this.getModel());
	}

}
