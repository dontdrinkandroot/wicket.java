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
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.Strings;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.form.FormHorizontal;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.javascript.JQueryScript;


public abstract class AbstractFormGroup<T, F extends FormComponent<T>> extends GenericPanel<T>
{

	private final IModel<String> labelModel;

	private F formComponent;

	protected Class<T> type = null;

	private WebMarkupContainer componentContainer;

	private FencedFeedbackPanel feedback;

	private AjaxFormComponentUpdatingBehavior onBlurValidationBehavior;


	public AbstractFormGroup(String id, IModel<T> model, String label)
	{
		this(id, model, new Model<String>(label));
	}

	public AbstractFormGroup(String id, IModel<T> model, IModel<String> labelModel)
	{
		this(id, model, labelModel, null);
	}

	public AbstractFormGroup(String id, IModel<T> model, IModel<String> labelModel, Class<T> type)
	{
		super(id, model);
		this.setOutputMarkupId(true);

		this.labelModel = labelModel;
		this.type = type;
	}

	/**
	 * MUST be called as last method in children constructors.
	 */
	protected void createComponents()
	{
		this.componentContainer = new WebMarkupContainer("componentContainer");
		this.add(this.componentContainer);

		this.formComponent = this.createFormComponent("formComponent");
		this.formComponent.setOutputMarkupId(true);
		this.formComponent.setLabel(this.labelModel);
		this.componentContainer.add(this.formComponent);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.FORM_GROUP));

		Label label = new Label("label", this.labelModel) {

			@Override
			public boolean isVisible()
			{

				return (this.getDefaultModel() != null) && !Strings.isEmpty(this.getDefaultModelObjectAsString());
			}
		};
		label.add(new AttributeModifier("for", this.getFormComponent().getMarkupId()));
		this.add(label);

		this.feedback = new FencedFeedbackPanel("feedback", this) {

			@Override
			protected String getCSSClass(FeedbackMessage message)
			{
				return null;
			}
		};
		this.feedback.setOutputMarkupId(true);
		this.componentContainer.add(this.feedback);

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

		/* Apply horizontal style if requested */
		Form<?> form = this.getFormComponent().getForm();
		if (form instanceof FormHorizontal) {
			label.add(new CssClassAppender(((FormHorizontal<?>) form).getLabelColumnSize()));
			this.componentContainer.add(new CssClassAppender(((FormHorizontal<?>) form).getFormComponentColumnSize()));
		}
	}

	public F getFormComponent()
	{

		return this.formComponent;
	}

	public void setRequired(boolean required)
	{

		this.getFormComponent().setRequired(required);
	}

	public void setOnBlurValidation(boolean active)
	{
		if ((null != this.onBlurValidationBehavior) && !active) {
			this.getFormComponent().remove(this.onBlurValidationBehavior);
			return;
		}

		if (active) {
			this.onBlurValidationBehavior = new AjaxFormComponentUpdatingBehavior("blur") {

				@Override
				protected void onUpdate(AjaxRequestTarget target)
				{
					target.appendJavaScript(
							new JQueryScript(AbstractFormGroup.this).addClass(
									BootstrapCssClass.HAS_SUCCESS.getClassString()).toString());
					target.appendJavaScript(
							new JQueryScript(AbstractFormGroup.this).removeClass(
									BootstrapCssClass.HAS_ERROR.getClassString()).toString());
					target.add(AbstractFormGroup.this.feedback);
				}

				@Override
				protected void onError(AjaxRequestTarget target, RuntimeException e)
				{
					super.onError(target, e);
					target.appendJavaScript(
							new JQueryScript(AbstractFormGroup.this).removeClass(
									BootstrapCssClass.HAS_SUCCESS.getClassString()).toString());
					target.appendJavaScript(
							new JQueryScript(AbstractFormGroup.this).addClass(
									BootstrapCssClass.HAS_ERROR.getClassString()).toString());
					target.add(AbstractFormGroup.this.feedback);
				}
			};
			this.getFormComponent().add(this.onBlurValidationBehavior);
		}
	}

	protected abstract F createFormComponent(String id);

}
