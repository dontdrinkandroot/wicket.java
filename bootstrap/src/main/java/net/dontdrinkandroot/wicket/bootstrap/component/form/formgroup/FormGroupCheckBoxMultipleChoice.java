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

import org.apache.wicket.markup.html.form.AbstractChoice;
import org.apache.wicket.markup.html.form.CheckBoxMultipleChoice;
import org.apache.wicket.markup.html.form.IChoiceRenderer;
import org.apache.wicket.model.IModel;

import java.util.Collection;
import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupCheckBoxMultipleChoice<T> extends FormGroupFormComponent<Collection<T>, Collection<T>, CheckBoxMultipleChoice<T>>
{
    @SuppressWarnings("unchecked")
    public FormGroupCheckBoxMultipleChoice(String id, IModel<String> labelModel, IModel<? extends Collection<T>> model)
    {
        super(id, labelModel, (IModel<Collection<T>>) model);
    }

    public FormGroupCheckBoxMultipleChoice(
            String id,
            IModel<String> labelModel, IModel<? extends Collection<T>> model,
            List<T> choices,
            IChoiceRenderer<T> choiceRenderer
    )
    {
        this(id, labelModel, model);
        this.getFormComponent().setChoices(choices);
        this.getFormComponent().setChoiceRenderer(choiceRenderer);
    }

    @Override
    protected CheckBoxMultipleChoice<T> createFormComponent(String id)
    {
        CheckBoxMultipleChoice<T> formComponent = new CheckBoxMultipleChoice<>(id, this.getModel(), (List<T>) null);
        formComponent.setPrefix("<div class=\"checkbox\">");
        formComponent.setSuffix("</div>");
        formComponent.setLabelPosition(AbstractChoice.LabelPosition.WRAP_AFTER);

        return formComponent;
    }
}
