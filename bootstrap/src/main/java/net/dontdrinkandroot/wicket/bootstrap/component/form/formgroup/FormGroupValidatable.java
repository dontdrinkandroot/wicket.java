/*
 * Copyright (C) 2012-2017 Philip Washington Sorst <philip@sorst.net>
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

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.behavior.ForComponentIdBehavior;
import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormGroupAjaxValidationBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.css.ValidationState;
import net.dontdrinkandroot.wicket.css.CssClass;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.util.time.Duration;
import org.apache.wicket.validation.IValidator;

/**
 * @param <T> Type of the Model Object.
 * @param <M> Type of the FormComponent Model Object.
 * @param <F> Type of the Form Component.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class FormGroupValidatable<T, M, F extends FormComponent<M>> extends FormGroup<T>
{
    protected FencedFeedbackPanel helpBlock;

    protected IModel<String> helpTextModel;

    public FormGroupValidatable(String id, IModel<String> labelModel, IModel<T> model)
    {
        this(id, labelModel, model, null);
    }

    public FormGroupValidatable(String id, IModel<String> labelModel, IModel<T> model, Class<T> type)
    {
        super(id, labelModel, model);
    }

    @Override
    protected void createComponents()
    {
        super.createComponents();
        this.helpBlock = new FencedFeedbackPanel("helpBlock", this)
        {
            @Override
            protected String getCSSClass(FeedbackMessage message)
            {
                return message.getLevelAsString().toLowerCase();
            }

            @Override
            protected void onConfigure()
            {
                /* Always renotify of help text if set so it gets rendered every time */
                IModel<String> helpTextModel = FormGroupValidatable.this.helpTextModel;
                if ((null != helpTextModel) && (null != helpTextModel.getObject())) {
                    this.info(helpTextModel.getObject());
                }

                this.setOutputMarkupPlaceholderTag(!this.anyMessage());
                this.setVisible(this.anyMessage());
            }
        };
        this.helpBlock.setOutputMarkupId(true);

        this.add(new CssClassAppender(new AbstractReadOnlyModel<CssClass>()
        {
            @Override
            public CssClass getObject()
            {
                return FormGroupValidatable.this.getValidationState();
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

    public FencedFeedbackPanel getHelpBlock()
    {
        return this.helpBlock;
    }

    /**
     * Enables Ajax Validation for the "input" event with default thresholding of 250ms.
     */
    public void addDefaultAjaxInputValidation()
    {
        this.addAjaxValidation("input", new ThrottlingSettings(Duration.milliseconds(250), true));
    }

    public void addAjaxValidation(String eventName)
    {
        this.addAjaxValidation(eventName, null);
    }

    public void addAjaxValidation(String eventName, final ThrottlingSettings throttlingSettings)
    {
        this.getFormComponent().add(new FormGroupAjaxValidationBehavior(eventName, this, throttlingSettings));
    }

    public ValidationState getValidationState()
    {
        if (!this.getFormComponent().isValid()) {
            return ValidationState.ERROR;
        }

        if (this.helpBlock.anyMessage(FeedbackMessage.FATAL) || this.helpBlock.anyMessage(FeedbackMessage.ERROR)) {
            return ValidationState.ERROR;
        }

        if (this.helpBlock.anyMessage(FeedbackMessage.WARNING)) {
            return ValidationState.WARNING;
        }

        if (this.helpBlock.anyMessage(FeedbackMessage.SUCCESS)) {
            return ValidationState.SUCCESS;
        }

        if (this.getFormComponent().isRequired() && null == this.getModelObject()) {
            return ValidationState.WARNING;
        }

        return null;
    }

    public void addValidator(IValidator<M> validator)
    {
        this.getFormComponent().add(validator);
    }

    public void setHelpText(IModel<String> helpTextModel)
    {
        this.helpTextModel = helpTextModel;
    }

    public abstract F getFormComponent();
}
