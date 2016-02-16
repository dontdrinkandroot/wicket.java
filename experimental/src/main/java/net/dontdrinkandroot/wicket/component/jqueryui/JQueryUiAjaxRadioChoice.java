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

import org.apache.wicket.ajax.AjaxEventBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.form.Radio;
import org.apache.wicket.markup.html.form.RadioGroup;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.util.ListModel;

import net.dontdrinkandroot.wicket.javascript.jqueryui.JQueryUiScript;


public class JQueryUiAjaxRadioChoice<T> extends GenericPanel<T>
{

	private static final long serialVersionUID = 1L;

	/** The list of objects. */
	private IModel<? extends List<T>> choices;

	/** The renderer used to generate display/id values for the objects. */
	private IChoiceRenderer<? super T> renderer;


	public JQueryUiAjaxRadioChoice(String id, IModel<T> model, List<T> choices)
	{
		this(id, model, new ListModel<T>(choices), new ChoiceRenderer<T>());
	}

	public JQueryUiAjaxRadioChoice(
			final String id,
			IModel<T> model,
			final List<T> choices,
			final IChoiceRenderer<? super T> renderer)
	{
		this(id, model, new ListModel<T>(choices), renderer);
	}

	public JQueryUiAjaxRadioChoice(String id, IModel<T> model, IModel<? extends List<T>> choices)
	{
		this(id, model, choices, new ChoiceRenderer<T>());
	}

	public JQueryUiAjaxRadioChoice(
			String id,
			IModel<T> model,
			IModel<? extends List<T>> choices,
			IChoiceRenderer<? super T> renderer)
	{
		super(id, model);

		this.setOutputMarkupId(true);

		this.choices = choices;
		this.setChoiceRenderer(renderer);

		final RadioGroup<T> radioGroup = new RadioGroup<T>("radioGroup", model);
		this.add(radioGroup);

		final ListView<T> radioItemView = new ListView<T>("radioItem", choices) {

			private static final long serialVersionUID = 1L;


			@Override
			protected void populateItem(final ListItem<T> item)
			{

				final Radio<T> radio = new Radio<T>("input", item.getModel(), radioGroup);
				radio.setOutputMarkupId(true);
				radio.add(new AjaxEventBehavior("onclick") {

					private static final long serialVersionUID = 1L;


					@Override
					protected void onEvent(AjaxRequestTarget target)
					{
						JQueryUiAjaxRadioChoice.this.onSelectionChanged(item.getModelObject(), target);
					}
				});
				item.add(radio);

				final Label label = new Label(
						"label",
						JQueryUiAjaxRadioChoice.this.getChoiceRenderer().getDisplayValue(
								item.getModel().getObject()).toString());
				label.add(new AttributeAppender("for", new Model<String>(radio.getMarkupId())));
				item.add(label);

				item.setRenderBodyOnly(true);
			}

		};
		radioGroup.add(radioItemView);
	}

	public final JQueryUiAjaxRadioChoice<T> setChoiceRenderer(IChoiceRenderer<? super T> renderer)
	{
		if (renderer == null) {
			this.renderer = new ChoiceRenderer<T>();
		}
		this.renderer = renderer;

		return this;
	}

	public final IChoiceRenderer<? super T> getChoiceRenderer()
	{
		return this.renderer;
	}

	protected void onSelectionChanged(T newValue, AjaxRequestTarget target)
	{
		this.setModelObject(newValue);
	}

	@Override
	public void renderHead(IHeaderResponse response)
	{
		super.renderHead(response);

		response.render(OnDomReadyHeaderItem.forScript(new JQueryUiScript(this).buttonset().toString()));
	}

}
