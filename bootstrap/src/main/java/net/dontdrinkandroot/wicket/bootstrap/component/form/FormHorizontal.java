/**
 * Copyright (C) 2012, 2013 Philip W. Sorst <philip@sorst.net>
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

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.css.CssClass;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;


public class FormHorizontal<T> extends Form<T> {

	private final CssClass labelColumnSize;

	private final CssClass formComponentColumnSize;


	public FormHorizontal(String id, CssClass labelColumnSize, CssClass formComponentColumnSize) {

		super(id);
		this.labelColumnSize = labelColumnSize;
		this.formComponentColumnSize = formComponentColumnSize;
	}


	public FormHorizontal(
			final String id,
			final IModel<T> model,
			CssClass labelColumnSize,
			CssClass formComponentColumnSize) {

		super(id, model);
		this.labelColumnSize = labelColumnSize;
		this.formComponentColumnSize = formComponentColumnSize;
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();
		this.add(new CssClassAppender(BootstrapCssClass.FORM_HORIZONTAL));
		this.add(new AttributeModifier("role", "form"));
	}


	public CssClass getLabelColumnSize() {

		return this.labelColumnSize;
	}


	public CssClass getFormComponentColumnSize() {

		return this.formComponentColumnSize;
	}

}
