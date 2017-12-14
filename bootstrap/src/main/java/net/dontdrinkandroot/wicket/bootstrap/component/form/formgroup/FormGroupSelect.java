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

import org.apache.wicket.markup.html.form.DropDownChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * @param <T> Type of the {@link DropDownChoice}.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupSelect<T> extends FormGroupFormComponent<T, T, DropDownChoice<T>>
{
    protected FormGroupSelect(String id, IModel<String> labelModel, IModel<T> model)
    {
        super(id, labelModel, model);
    }

    public FormGroupSelect(String id, IModel<String> labelModel, IModel<T> model, List<T> choices)
    {
        super(id, labelModel, model);
        this.getFormComponent().setChoices(choices);
    }

    public FormGroupSelect(
            String id,
            IModel<String> labelModel,
            IModel<T> model,
            List<T> choices,
            IChoiceRenderer<T> choiceRenderer
    )
    {
        super(id, labelModel, model);
        this.getFormComponent().setChoices(choices);
        this.getFormComponent().setChoiceRenderer(choiceRenderer);
    }

    public FormGroupSelect(String id, IModel<String> labelModel, IModel<T> model, IModel<List<T>> choices)
    {
        super(id, labelModel, model);
        this.getFormComponent().setChoices(choices);
    }

    public FormGroupSelect(
            String id,
            IModel<String> labelModel,
            IModel<T> model,
            IModel<List<T>> choices,
            IChoiceRenderer<T> choiceRenderer
    )
    {
        super(id, labelModel, model);
        this.getFormComponent().setChoices(choices);
        this.getFormComponent().setChoiceRenderer(choiceRenderer);
    }

    @Override
    protected DropDownChoice<T> createFormComponent(String id)
    {
        return new DropDownChoice<T>(id, this.getModel(), (List<T>) null);
    }

    public void setNullValid(boolean nullValid)
    {
        this.getFormComponent().setNullValid(nullValid);
    }
}
