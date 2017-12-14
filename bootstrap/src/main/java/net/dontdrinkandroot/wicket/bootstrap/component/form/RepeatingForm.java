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

import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormStyleBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupActions;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize;
import org.apache.wicket.Component;
import org.apache.wicket.IQueueRegion;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.html.panel.IMarkupSourcingStrategy;
import org.apache.wicket.markup.html.panel.PanelMarkupSourcingStrategy;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

/**
 * @param <T> Type of the Model object.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class RepeatingForm<T> extends Form<T> implements IQueueRegion
{
    private FormStyleBehavior formStyleBehavior = new FormStyleBehavior();

    private FeedbackPanel feedbackPanel;

    public RepeatingForm(String id)
    {
        super(id);
    }

    public RepeatingForm(String id, IModel<T> model)
    {
        super(id, model);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();
        this.add(this.formStyleBehavior);

        this.feedbackPanel = new FencedFeedbackPanel("feedback", this);
        this.feedbackPanel.setOutputMarkupId(true);
        this.add(this.feedbackPanel);

        RepeatingView formGroupView = new RepeatingView("formGroup");
        this.populateFormGroups(formGroupView);
        this.add(formGroupView);

        Component formGroupActions = this.createActionsView("actions");
        this.add(formGroupActions);
    }

    protected Component createActionsView(String id)
    {
        return new FormGroupActions<Void>(id)
        {
            @Override
            protected void populateActions(RepeatingView actionView)
            {
                RepeatingForm.this.populateActions(actionView);
            }
        };
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected IMarkupSourcingStrategy newMarkupSourcingStrategy()
    {
        return new PanelMarkupSourcingStrategy(false);
    }

    @Override
    protected void onComponentTag(ComponentTag tag)
    {
        tag.setName("form");
        super.onComponentTag(tag);
    }

    protected void populateFormGroups(RepeatingView formGroupView)
    {
        /* Hook */
    }

    protected void populateActions(RepeatingView buttonView)
    {
        /* Hook */
    }

    public FeedbackPanel getFeedbackPanel()
    {
        return this.feedbackPanel;
    }

    public RepeatingForm<T> setHorizontal(ColumnSize containerSize)
    {
        this.formStyleBehavior.setHorizontal(containerSize);
        return this;
    }

    public RepeatingForm<T> setInline(boolean inline)
    {
        this.formStyleBehavior.setInline(inline);
        return this;
    }
}
