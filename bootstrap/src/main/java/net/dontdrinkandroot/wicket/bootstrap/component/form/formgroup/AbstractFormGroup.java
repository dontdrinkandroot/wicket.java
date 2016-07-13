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

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.Strings;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.behavior.FormGroupOnlineValidationBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.form.BootstrapForm;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;


public abstract class AbstractFormGroup<T, F extends FormComponent<T>> extends FormGroup<T>
{

	protected IModel<String> helpTextModel;

	protected F formComponent;

	protected Class<T> type = null;

	protected Component label;

	protected WebMarkupContainer componentContainer;

	protected FencedFeedbackPanel helpBlock;


	public AbstractFormGroup(String id, IModel<String> labelModel, IModel<T> model)
	{
		this(id, labelModel, model, null);
	}

	public AbstractFormGroup(String id, IModel<String> labelModel, IModel<T> model, Class<T> type)
	{
		super(id, labelModel, model);
		this.setOutputMarkupId(true);

		this.type = type;

		/* Initialize form component early, so it is available before onInitialize takes place */
		this.formComponent = this.createFormComponent("formComponent");
		this.formComponent.setOutputMarkupId(true);
		this.formComponent.setLabel(this.labelModel);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.componentContainer = new WebMarkupContainer("componentContainer");
		this.label = this.createLabel("label");
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
				boolean helpTextSet = (null != AbstractFormGroup.this.helpTextModel)
						&& !Strings.isEmpty(AbstractFormGroup.this.helpTextModel.getObject());
				if (helpTextSet) {
					this.info(AbstractFormGroup.this.helpTextModel.getObject());
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
				if (!AbstractFormGroup.this.getFormComponent().isValid()) {
					return super.getObject();
				}

				return null;
			}
		}));

		this.applyComponentAdd();

		/* Apply horizontal style if requested */
		Form<?> form = this.getFormComponent().getForm();
		if (form instanceof BootstrapForm<?>) {
			this.applyHorizontalStyleIfSet((BootstrapForm<?>) form);
		}
	}

	@Override
	protected Component createLabel(String id)
	{
		Component label = super.createLabel(id);
		label.add(new AttributeModifier("for", new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject()
			{
				return AbstractFormGroup.this.getFormComponent().getMarkupId();
			}
		}));

		return label;
	}

	public F getFormComponent()
	{
		return this.formComponent;
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

	public void addOnlineValidation(String eventName)
	{
		this.addOnlineValidation(eventName, null);
	}

	public void addOnlineValidation(String eventName, final ThrottlingSettings throttlingSettings)
	{
		this.getFormComponent().add(new FormGroupOnlineValidationBehavior(eventName, this, throttlingSettings));
	}

	protected void applyHorizontalStyleIfSet(BootstrapForm<?> form)
	{
		if ((null != form.getLabelColumnSize()) && (null != form.getFormComponentColumnSize())) {
			this.label.add(new CssClassAppender(form.getLabelColumnSize()));
			this.componentContainer.add(new CssClassAppender(form.getFormComponentColumnSize()));
		}
	}

	protected void applyComponentAdd()
	{
		this.add(this.componentContainer);
		this.componentContainer.add(this.formComponent);
		this.add(this.label);
		this.componentContainer.add(this.helpBlock);
	}

	protected abstract F createFormComponent(String id);
}
