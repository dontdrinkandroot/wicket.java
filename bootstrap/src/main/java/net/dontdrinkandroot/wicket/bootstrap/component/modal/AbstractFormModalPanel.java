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
package net.dontdrinkandroot.wicket.bootstrap.component.modal;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;


public abstract class AbstractFormModalPanel<T> extends AbstractBaseModalPanel<T> {

	public AbstractFormModalPanel(String id) {

		super(id);
	}


	public AbstractFormModalPanel(String id, IModel<T> model) {

		super(id, model);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.MODAL));
		this.add(new CssClassAppender(BootstrapCssClass.HIDE));
		this.add(new CssClassAppender(BootstrapCssClass.FADE));

		Form<T> form = this.createForm("form");
		this.add(form);

		form.add(new Label("heading", this.createHeadingModel()));
		form.add(this.createBody("body"));
		form.add(this.createFooter("footer"));
	}


	@Override
	public CharSequence getHideScript() {

		return String.format("$('%s').modal('hide');", this.getMarkupId());
	}


	@Override
	public CharSequence getShowScript() {

		return String.format("$('%s').modal('show');", this.getMarkupId());
	}


	@Override
	public CharSequence getToggleScript() {

		return String.format("$('%s').modal('toggle');", this.getMarkupId());
	}


	@Override
	protected Component createBody(String id) {

		return new WebMarkupContainer(id);
	}


	@Override
	protected Component createFooter(String id) {

		return new WebMarkupContainer(id);
	}


	protected Form<T> createForm(String id) {

		return new Form<T>(id, this.getModel());
	}

}
