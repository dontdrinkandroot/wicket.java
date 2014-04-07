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
package net.dontdrinkandroot.wicket.bootstrap.component.modal;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;


public abstract class AbstractBaseModalPanel<T> extends GenericPanel<T> {

	public AbstractBaseModalPanel(String id) {

		super(id);
		this.setOutputMarkupId(true);
	}


	public AbstractBaseModalPanel(String id, IModel<T> model) {

		super(id, model);
		this.setOutputMarkupId(true);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.MODAL));
		this.add(new CssClassAppender(BootstrapCssClass.HIDE));
		this.add(new CssClassAppender(BootstrapCssClass.FADE));
	}


	protected Component createBody(String id) {

		return new WebMarkupContainer(id);
	}


	protected Component createFooter(String id) {

		return new WebMarkupContainer(id);
	}


	protected abstract IModel<String> createHeadingModel();


	public CharSequence getHideScript() {

		return String.format("$('%s').modal('hide');", this.getMarkupId());
	}


	public CharSequence getShowScript() {

		return String.format("$('%s').modal('show');", this.getMarkupId());
	}


	public CharSequence getToggleScript() {

		return String.format("$('%s').modal('toggle');", this.getMarkupId());
	}
}
