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

import net.dontdrinkandroot.wicket.component.GenericWebMarkupContainer;

import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.IHeaderContributor;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.StringValue;


public class JQueryUiAjaxSlider extends GenericWebMarkupContainer<Integer> implements IHeaderContributor {

	private final AbstractDefaultAjaxBehavior valueChangedBehaviour;

	private final int step;

	private final IModel<Integer> maxModel;

	private final IModel<Integer> minModel;


	public JQueryUiAjaxSlider(final String id, final IModel<Integer> model, final int min, final int max, final int step) {

		this(id, model, new Model<Integer>(min), new Model<Integer>(max), step);

	}


	public JQueryUiAjaxSlider(
			final String id,
			final IModel<Integer> model,
			IModel<Integer> minModel,
			final IModel<Integer> maxModel,
			final int step) {

		super(id, model);

		this.setOutputMarkupId(true);

		this.minModel = minModel;
		this.maxModel = maxModel;
		this.step = step;

		this.valueChangedBehaviour = new AbstractDefaultAjaxBehavior() {

			private static final long serialVersionUID = 1L;


			@Override
			protected void respond(final AjaxRequestTarget target) {

				final StringValue value =
						JQueryUiAjaxSlider.this.getRequest().getQueryParameters().getParameterValue("value");
				JQueryUiAjaxSlider.this.setModelObject(value.toInteger());
				JQueryUiAjaxSlider.this.onValueChanged(target);
			}

		};
		this.add(this.valueChangedBehaviour);
	}


	@Override
	public void renderHead(final IHeaderResponse response) {

		super.renderHead(response);

		response.render(OnDomReadyHeaderItem.forScript(String.format(
				"$('#%s').slider({value: %d, min: %d, max: %d, step: %d, change: function(event, ui) {wicketAjaxGet('%s&value=' + ui.value)}"
						+ "})",
				this.getMarkupId(),
				this.getModelObject(),
				this.minModel.getObject(),
				this.maxModel.getObject(),
				this.step,
				this.valueChangedBehaviour.getCallbackUrl())));
	}


	public void onValueChanged(final AjaxRequestTarget target) {

		target.appendJavaScript(String.format(
				"$('#%s').slider({ 'option', 'max', %d})",
				this.getMarkupId(),
				this.maxModel.getObject()));
		target.appendJavaScript(String.format(
				"$('#%s').slider({ 'option', 'min', %d})",
				this.getMarkupId(),
				this.minModel.getObject()));
		target.appendJavaScript(String.format(
				"$('#%s').slider({ 'option', 'value', %d})",
				this.getMarkupId(),
				this.getModelObject()));
	}
}
