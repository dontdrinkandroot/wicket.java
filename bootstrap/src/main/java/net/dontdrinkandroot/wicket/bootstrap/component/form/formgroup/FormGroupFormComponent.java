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

import org.apache.wicket.Component;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.Strings;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.behavior.ForComponentIdBehavior;
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormGroupOnlineValidationBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;


public abstract class FormGroupFormComponent<T, F extends FormComponent<T>> extends FormGroup<T>
{

	protected IModel<String> helpTextModel;

	protected FencedFeedbackPanel helpBlock;


	public FormGroupFormComponent(String id, IModel<String> labelModel, IModel<T> model)
	{
		this(id, labelModel, model, null);
	}

	public FormGroupFormComponent(String id, IModel<String> labelModel, IModel<T> model, Class<T> type)
	{
		super(id, labelModel, model);
	}

	@Override
	protected void createComponents()
	{
		super.createComponents();
		this.helpBlock = new FencedFeedbackPanel("helpBlock", this) {

			@Override
			protected String getCSSClass(FeedbackMessage message)
			{
				return message.getLevelAsString().toLowerCase();
			}

			@Override
			protected void onConfigure()
			{
				super.onConfigure();
				boolean helpTextSet = (null != FormGroupFormComponent.this.helpTextModel)
						&& !Strings.isEmpty(FormGroupFormComponent.this.helpTextModel.getObject());
				if (helpTextSet) {
					this.info(FormGroupFormComponent.this.helpTextModel.getObject());
				}

				this.setOutputMarkupPlaceholderTag(this.getCurrentMessages().size() == 0);
				this.setVisible(this.getCurrentMessages().size() > 0);
			}
		};
		this.helpBlock.setOutputMarkupId(true);

		this.add(new CssClassAppender(new Model<BootstrapCssClass>(BootstrapCssClass.HAS_ERROR) {

			@Override
			public BootstrapCssClass getObject()
			{
				if (!FormGroupFormComponent.this.getFormComponent().isValid()) {
					return super.getObject();
				}

				return null;
			}
		}));
	}

	@Override
	protected void addComponents()
	{
		super.addComponents();
		this.container.add(this.helpBlock);
	}

	@Override
	protected Component createLabel(String id)
	{
		Component label = super.createLabel(id);
		label.add(new ForComponentIdBehavior(this.getFormComponent()));

		return label;
	}

	public void setRequired(boolean required)
	{
		this.getFormComponent().setRequired(required);
	}

	public void setHelpTextModel(IModel<String> helpTextModel)
	{
		this.helpTextModel = helpTextModel;
	}

	public FencedFeedbackPanel getHelpBlock()
	{
		return this.helpBlock;
	}

	public void addAjaxValidation(String eventName)
	{
		this.addAjaxValidation(eventName, null);
	}

	public void addAjaxValidation(String eventName, final ThrottlingSettings throttlingSettings)
	{
		this.getFormComponent().add(new FormGroupOnlineValidationBehavior(eventName, this, throttlingSettings));
	}

	public abstract F getFormComponent();

}
