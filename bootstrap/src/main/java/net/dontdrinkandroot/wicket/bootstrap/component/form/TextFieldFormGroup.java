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
package net.dontdrinkandroot.wicket.bootstrap.component.form;

import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;


public class TextFieldFormGroup<T> extends AbstractFormGroup<T, TextField<T>> {

	public TextFieldFormGroup(String id, IModel<T> model, IModel<String> labelModel) {

		super(id, model, labelModel);
		this.createComponents();
	}


	public TextFieldFormGroup(String id, IModel<T> model, IModel<String> labelModel, Class<T> type) {

		super(id, model, labelModel, type);
		this.createComponents();
	}


	@Override
	protected TextField<T> createFormComponent(String id) {

		return new TextField<T>(id, this.getModel(), this.type);
	}

}
