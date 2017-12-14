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
package net.dontdrinkandroot.wicket.bootstrap.behavior.form;

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupValidatable;
import net.dontdrinkandroot.wicket.bootstrap.css.ValidationState;
import net.dontdrinkandroot.wicket.javascript.JQueryScript;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;

/**
 * Ajax Validation state that colors the {@link FormGroupValidatable} according to the validation state and shows
 * any error messages.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupAjaxValidationBehavior extends AjaxFormComponentUpdatingBehavior
{
    private ThrottlingSettings throttlingSettings;

    private FormGroupValidatable<?, ?, ?> formGroup;

    public FormGroupAjaxValidationBehavior(String event, FormGroupValidatable<?, ?, ?> formGroup)
    {
        super(event);
        this.formGroup = formGroup;
    }

    public FormGroupAjaxValidationBehavior(
            String event,
            FormGroupValidatable<?, ?, ?> formGroup,
            ThrottlingSettings throttlingSettings
    )
    {
        super(event);
        this.throttlingSettings = throttlingSettings;
        this.formGroup = formGroup;
    }

    @Override
    protected void onUpdate(AjaxRequestTarget target)
    {
        this.renderValidation(target);
    }

    @Override
    protected void onError(AjaxRequestTarget target, RuntimeException e)
    {
        super.onError(target, e);
        this.renderValidation(target);
    }

    protected void renderValidation(AjaxRequestTarget target)
    {
        target.appendJavaScript(new JQueryScript(this.formGroup).removeClass(ValidationState.ERROR.getClassString()));
        target.appendJavaScript(new JQueryScript(this.formGroup).removeClass(ValidationState.WARNING.getClassString()));
        target.appendJavaScript(new JQueryScript(this.formGroup).removeClass(ValidationState.SUCCESS.getClassString()));

        ValidationState validationState = this.formGroup.getValidationState();
        if ((null == validationState) && this.formGroup.getFormComponent().isValid()) {
            validationState = ValidationState.SUCCESS;
        }

        if (null != validationState) {
            target.appendJavaScript(
                    new JQueryScript(this.formGroup).addClass(validationState.getClassString()).toString()
            );
            target.add(this.formGroup.getHelpBlock());
        }
    }

    @Override
    protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
    {
        super.updateAjaxAttributes(attributes);
        if (null != this.throttlingSettings) {
            attributes.setThrottlingSettings(this.throttlingSettings);
        }
    }
}
