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
package net.dontdrinkandroot.wicket.component.jqueryui;

import java.util.List;

import net.dontdrinkandroot.wicket.component.form.AjaxDropDownChoice;
import net.dontdrinkandroot.wicket.javascript.jqueryui.JQueryUiScript;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.resource.PackageResourceReference;


public class JQueryUiAjaxDropDownChoice<T> extends AjaxDropDownChoice<T> {

	private static final long serialVersionUID = 1L;

	private boolean renderResources = false;


	public JQueryUiAjaxDropDownChoice(String id) {

		super(id);
	}


	public JQueryUiAjaxDropDownChoice(final String id, final List<? extends T> choices) {

		super(id, choices);
	}


	public JQueryUiAjaxDropDownChoice(
			final String id,
			final List<? extends T> choices,
			final IChoiceRenderer<? super T> renderer) {

		super(id, choices, renderer);
	}


	public JQueryUiAjaxDropDownChoice(final String id, IModel<T> model, final List<? extends T> choices) {

		super(id, model, choices);
	}


	public JQueryUiAjaxDropDownChoice(
			final String id,
			IModel<T> model,
			final List<? extends T> choices,
			final IChoiceRenderer<? super T> renderer) {

		super(id, model, choices, renderer);
	}


	public JQueryUiAjaxDropDownChoice(String id, IModel<? extends List<? extends T>> choices) {

		super(id, choices);
	}


	public JQueryUiAjaxDropDownChoice(String id, IModel<T> model, IModel<? extends List<? extends T>> choices) {

		super(id, model, choices);
	}


	public JQueryUiAjaxDropDownChoice(
			String id,
			IModel<? extends List<? extends T>> choices,
			IChoiceRenderer<? super T> renderer) {

		super(id, choices, renderer);
	}


	public JQueryUiAjaxDropDownChoice(
			String id,
			IModel<T> model,
			IModel<? extends List<? extends T>> choices,
			IChoiceRenderer<? super T> renderer) {

		super(id, model, choices, renderer);
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);

		if (this.renderResources) {
			response.render(JavaScriptHeaderItem.forReference(new PackageResourceReference(
					JQueryUiAjaxDropDownChoice.class,
					"jquery.ui.selectmenu.js")));
		}

		response.render(OnDomReadyHeaderItem.forScript(new JQueryUiScript(this).selectMenu().toString()));
	}


	public void setRenderResources(boolean renderResources) {

		this.renderResources = renderResources;
	}


	public boolean isRenderResources() {

		return this.renderResources;
	}
}
