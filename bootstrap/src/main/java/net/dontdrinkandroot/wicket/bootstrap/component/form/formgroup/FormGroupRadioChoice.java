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

import org.apache.wicket.markup.html.form.AbstractChoice.LabelPosition;
import org.apache.wicket.markup.html.form.RadioChoice;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * @param <T> Type of the model object.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupRadioChoice<T> extends FormGroupFormComponent<T, T, RadioChoice<T>>
{
    public FormGroupRadioChoice(
            String id,
            IModel<String> labelModel,
            IModel<T> model,
            IModel<? extends List<? extends T>> choices
    )
    {
        super(id, labelModel, model);
        this.getFormComponent().setChoices(choices);
    }

    public FormGroupRadioChoice(String id, IModel<String> labelModel, IModel<T> model, List<? extends T> choices)
    {
        super(id, labelModel, model);
        this.getFormComponent().setChoices(choices);
    }

    @Override
    protected RadioChoice<T> createFormComponent(String id)
    {
        RadioChoice<T> radioChoice = new RadioChoice<T>(id, this.getModel(), (List<T>) null);
        radioChoice.setPrefix("<div class=\"radio\">");
        radioChoice.setSuffix("</div>");
        radioChoice.setLabelPosition(LabelPosition.WRAP_AFTER);

        return radioChoice;
    }
}
