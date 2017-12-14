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
package net.dontdrinkandroot.wicket.bootstrap.component.modal;

import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

/**
 * @param <T> Type of the model object
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class FormModal<T> extends Modal<T>
{
    private Form<T> form;

    private FencedFeedbackPanel feedbackPanel;

    public FormModal(String id)
    {
        super(id);
    }

    public FormModal(String id, IModel<T> model)
    {
        super(id, model);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.form = this.createForm("form");
        this.add(this.form);

        this.feedbackPanel = new FencedFeedbackPanel("feedback", this);
        this.feedbackPanel.setOutputMarkupId(true);
        this.form.add(this.feedbackPanel);

        RepeatingView formGroupView = new RepeatingView("formGroup");
        this.populateFormGroups(formGroupView);
        this.form.add(formGroupView);

        RepeatingView formActionView = new RepeatingView("formAction");
        this.populateFormActions(formActionView);
        this.form.add(formActionView);
    }

    protected Form<T> createForm(String id)
    {
        return new Form<T>(id, this.getModel())
        {
            @Override
            protected void onError()
            {
                FormModal.this.onError();
            }

            @Override
            protected void onSubmit()
            {
                FormModal.this.onSubmit();
            }
        };
    }

    @Override
    protected final void addFooter()
    {
        /* Noop */
    }

    @Override
    protected final Component createFooter(String id)
    {
        return null;
    }

    protected Form<T> getForm()
    {
        return this.form;
    }

    protected FencedFeedbackPanel getFeedbackPanel()
    {
        return this.feedbackPanel;
    }

    protected void populateFormActions(RepeatingView formActionView)
    {
        /* Hook */
    }

    protected void populateFormGroups(RepeatingView formGroupView)
    {
        /* Hook */
    }

    /**
     * @see Form#onError()
     */
    protected void onError()
    {
        /* Hook */
    }

    /**
     * @see Form#onSubmit()
     */
    protected void onSubmit()
    {
        /* Hook */
    }
}
