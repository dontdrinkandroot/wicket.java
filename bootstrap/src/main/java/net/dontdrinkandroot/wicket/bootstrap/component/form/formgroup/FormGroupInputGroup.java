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

import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroup;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.IModel;

/**
 * @param <T> Type of the Model Object.
 * @param <M> Type of the Form Component Model Object.
 * @param <F> Type of the {@link FormComponent}
 * @param <I> Type of the {@link InputGroup}
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class FormGroupInputGroup<T, M, F extends FormComponent<M>, I extends InputGroup<T, M, F>>
        extends FormGroupValidatable<T, M, F>
{
    private InputGroup<T, M, F> inputGroup;

    public FormGroupInputGroup(String id, IModel<String> labelModel, IModel<T> model)
    {
        super(id, labelModel, model);

        this.inputGroup = this.createInputGroup("inputGroup");
        this.getFormComponent().setLabel(this.labelModel);
    }

    @Override
    protected void addComponents()
    {
        super.addComponents();

        this.container.add(this.inputGroup);
    }

    @Override
    public F getFormComponent()
    {
        return this.inputGroup.getFormComponent();
    }

    protected Component createInputGroupAddonBefore(String id)
    {
        return new WebMarkupContainer(id).setVisible(false);
    }

    protected Component createInputGroupAddonAfter(String id)
    {
        return new WebMarkupContainer(id).setVisible(false);
    }

    protected abstract InputGroup<T, M, F> createInputGroup(String id);

}
