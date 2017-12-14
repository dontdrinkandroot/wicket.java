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
package net.dontdrinkandroot.wicket.component.form;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;
import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class AjaxDropDownChoice<T> extends DropDownChoice<T>
{
    public AjaxDropDownChoice(String id)
    {
        super(id);
    }

    public AjaxDropDownChoice(final String id, final List<? extends T> choices)
    {
        super(id, choices);
    }

    public AjaxDropDownChoice(
            final String id,
            final List<? extends T> choices,
            final IChoiceRenderer<? super T> renderer
    )
    {
        super(id, choices, renderer);
    }

    public AjaxDropDownChoice(final String id, IModel<T> model, final List<? extends T> choices)
    {
        super(id, model, choices);
    }

    public AjaxDropDownChoice(
            final String id,
            IModel<T> model,
            final List<? extends T> choices,
            final IChoiceRenderer<? super T> renderer
    )
    {
        super(id, model, choices, renderer);
    }

    public AjaxDropDownChoice(String id, IModel<? extends List<? extends T>> choices)
    {
        super(id, choices);
    }

    public AjaxDropDownChoice(String id, IModel<T> model, IModel<? extends List<? extends T>> choices)
    {
        super(id, model, choices);
    }

    public AjaxDropDownChoice(
            String id,
            IModel<? extends List<? extends T>> choices,
            IChoiceRenderer<? super T> renderer
    )
    {
        super(id, choices, renderer);
    }

    public AjaxDropDownChoice(
            String id,
            IModel<T> model,
            IModel<? extends List<? extends T>> choices,
            IChoiceRenderer<? super T> renderer
    )
    {
        super(id, model, choices, renderer);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.setOutputMarkupId(true);
        this.add(new AjaxFormComponentUpdatingBehavior("change")
        {
            @Override
            protected void onUpdate(final AjaxRequestTarget target)
            {
                AjaxDropDownChoice.this.onSelectionChanged(target);
            }
        });
    }

    protected void onSelectionChanged(AjaxRequestTarget target)
    {
        /* Hook */
    }
}
