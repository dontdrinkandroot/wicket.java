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
package net.dontdrinkandroot.wicket.bootstrap.component.form;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.form.AjaxFormSubmitBehavior;
import org.apache.wicket.model.IModel;

import java.util.Optional;

public class RepeatingAjaxForm<T> extends RepeatingForm<T>
{
    public RepeatingAjaxForm(String id)
    {
        this(id, null);
    }

    public RepeatingAjaxForm(String id, IModel<T> model)
    {
        super(id, model);
        this.createSubmitBehavior();
    }

    protected void createSubmitBehavior()
    {
        this.add(new AjaxFormSubmitBehavior(this, "submit")
        {
            @Override
            protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
            {
                super.updateAjaxAttributes(attributes);
                attributes.setPreventDefault(true);
            }

            @Override
            protected void onError(AjaxRequestTarget target)
            {
                super.onError(target);
                RepeatingAjaxForm.this.onError(target);
            }

            @Override
            protected void onSubmit(AjaxRequestTarget target)
            {
                super.onSubmit(target);
                RepeatingAjaxForm.this.onSubmit(target);
            }

            @Override
            protected void onAfterSubmit(AjaxRequestTarget target)
            {
                super.onAfterSubmit(target);
                RepeatingAjaxForm.this.onAfterSubmit(target);
            }
        });
    }

    @Override
    protected final void onError()
    {
        Optional<AjaxRequestTarget> target = this.getRequestCycle().find(AjaxRequestTarget.class);
        if (!target.isPresent()) {
            this.onError(null);
        }
    }

    @Override
    protected final void onSubmit()
    {
        Optional<AjaxRequestTarget> target = this.getRequestCycle().find(AjaxRequestTarget.class);
        if (!target.isPresent()) {
            this.onSubmit(null);
            this.onAfterSubmit(null);
        }
    }

    /**
     * Hook for handling the submission with Ajax. Do not perform any setResponsePage Actions here, as they will lead
     * to a double submission. Use onAfterSubmit instead.
     *
     * @param target The current AjaxRequestTarget or null if non was
     */
    protected void onSubmit(AjaxRequestTarget target)
    {
        /* Hook */
    }

    protected void onAfterSubmit(AjaxRequestTarget target)
    {
        /* Hook */
    }

    protected void onError(AjaxRequestTarget target)
    {
        if (null != target) {
            target.add(this);
        }
    }
}
