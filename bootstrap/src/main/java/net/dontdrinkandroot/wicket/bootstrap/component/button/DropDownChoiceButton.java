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
package net.dontdrinkandroot.wicket.bootstrap.component.button;

import java.util.List;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.ChoiceRenderer;
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.markup.html.form.HiddenField;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.markup.html.list.ListItem;
import org.apache.wicket.markup.html.list.ListView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.util.ListModel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.model.AbstractChainedModel;


public class DropDownChoiceButton<T> extends FormComponentPanel<T>
{

	private final IModel<List<T>> choicesModel;

	private IChoiceRenderer<? super T> choiceRenderer;

	private Class<T> type;

	private HiddenField<T> valueInputField;


	public DropDownChoiceButton(String id, IModel<T> model, List<T> choices)
	{
		this(id, model, new ListModel<T>(choices), new ChoiceRenderer<T>());
	}

	public DropDownChoiceButton(String id, IModel<T> model, IModel<List<T>> choicesModel)
	{
		this(id, model, choicesModel, new ChoiceRenderer<T>());
	}

	public DropDownChoiceButton(
			String id,
			IModel<T> model,
			IModel<List<T>> choicesModel,
			IChoiceRenderer<? super T> choiceRenderer)
	{
		super(id, model);

		this.choicesModel = choicesModel;
		this.setChoiceRenderer(choiceRenderer);
	}

	public DropDownChoiceButton(String id, IModel<T> model, IModel<List<T>> choicesModel, Class<T> type)
	{
		this(id, model, choicesModel, new ChoiceRenderer<T>(), type);
	}

	public DropDownChoiceButton(
			String id,
			IModel<T> model,
			IModel<List<T>> choicesModel,
			IChoiceRenderer<? super T> choiceRenderer,
			Class<T> type)
	{
		super(id, model);

		this.choicesModel = choicesModel;
		this.setChoiceRenderer(choiceRenderer);
		this.type = type;
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.setOutputMarkupId(true);
		this.add(new CssClassAppender(BootstrapCssClass.BTN_GROUP));
		this.add(new CssClassAppender("dropdownchoice"));

		final Label selectedLabel = new Label("selected", new ChoiceModel(this.getModel()));
		selectedLabel.add(new CssClassAppender("selection"));
		this.add(selectedLabel);

		final ListView<T> choicesView = new ListView<T>("choiceItem", this.choicesModel) {

			@Override
			protected void populateItem(final ListItem<T> item)
			{

				final AjaxLink<Void> choiceLink = new AjaxLink<Void>("choiceLink") {

					@Override
					public void onClick(AjaxRequestTarget target)
					{
						DropDownChoiceButton.this.onSelectionChanged(target, item.getModelObject());
					}

				};
				choiceLink.setBody(new ChoiceModel(item.getModel()));
				item.add(choiceLink);
			}

		};
		this.add(choicesView);

		this.valueInputField = new HiddenField<T>("valueInput", this.getModel(), this.type);
		this.add(this.valueInputField);
	}

	protected void onSelectionChanged(AjaxRequestTarget target, T selection)
	{
		this.setModelObject(selection);
		target.add(this);
		this.onSelectionChanged(target);
	}

	protected void onSelectionChanged(AjaxRequestTarget target)
	{
		/* Override to act on changes */
	}

	@Override
	public void renderHead(IHeaderResponse response)
	{
		super.renderHead(response);
		//
		// response.render(JavaScriptHeaderItem.forReference(new PackageResourceReference(
		// DropDownChoiceButton.class,
		// "dropdownchoicescale.js"), "dropdownchoicescale"));
		// response.render(OnLoadHeaderItem.forScript("scaleDropDownChoices()"));
	}

	@Override
	public void convertInput()
	{
		this.setConvertedInput(this.valueInputField.getConvertedInput());
	}


	public IChoiceRenderer<? super T> getChoiceRenderer()
	{
		return choiceRenderer;
	}

	public void setChoiceRenderer(IChoiceRenderer<? super T> choiceRenderer)
	{
		this.choiceRenderer = choiceRenderer;
	}


	class ChoiceModel extends AbstractChainedModel<T, Object>
	{

		public ChoiceModel(IModel<? extends T> parent)
		{
			super(parent);
		}

		@Override
		public Object getObject()
		{
			return DropDownChoiceButton.this.getChoiceRenderer().getDisplayValue(this.getParentObject());
		}

	}

}
