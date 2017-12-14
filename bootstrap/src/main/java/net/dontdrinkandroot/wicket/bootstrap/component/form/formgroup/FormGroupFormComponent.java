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

import org.apache.wicket.markup.html.form.FormComponent;
import org.apache.wicket.model.IModel;

/**
 * @param <T> Type of the Model Object.
 * @param <M> Type of the FormComponent Model Object.
 * @param <F> Type of the {@link FormComponent}
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class FormGroupFormComponent<T, M, F extends FormComponent<M>> extends FormGroupValidatable<T, M, F>
{
    protected F formComponent;

    protected Class<T> type = null;

    public FormGroupFormComponent(String id, IModel<String> labelModel)
    {
        this(id, labelModel, null, null);
    }

    public FormGroupFormComponent(String id, IModel<String> labelModel, IModel<T> model)
    {
        this(id, labelModel, model, null);
    }

    public FormGroupFormComponent(String id, IModel<String> labelModel, IModel<T> model, Class<T> type)
    {
        super(id, labelModel, model);
        this.setOutputMarkupId(true);

        this.type = type;

        /* Initialize form component early, so it is available before onInitialize takes place */
        this.formComponent = this.createFormComponent("formComponent");
        this.formComponent.setOutputMarkupId(true);
        this.formComponent.setLabel(this.labelModel);
    }

    @Override
    protected void createComponents()
    {
        super.createComponents();
    }

    @Override
    protected void addComponents()
    {
        super.addComponents();
        this.container.add(this.formComponent);
        this.container.add(this.helpBlock);
    }

    @Override
    public F getFormComponent()
    {
        return this.formComponent;
    }

    protected abstract F createFormComponent(String id);
}
