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

import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

/**
 * @param <T> Type of the model object.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupActions<T> extends FormGroup<T>
{
    private RepeatingView actionView;

    public FormGroupActions(String id)
    {
        super(id);
    }

    public FormGroupActions(String id, IModel<String> labelModel)
    {
        super(id, labelModel);
    }

    public FormGroupActions(String id, IModel<String> labelModel, IModel<T> model)
    {
        super(id, labelModel, model);
    }

    @Override
    protected void createComponents()
    {
        super.createComponents();
        this.actionView = new RepeatingView("action");
        this.populateActions(this.actionView);
    }

    @Override
    protected void addComponents()
    {
        super.addComponents();
        this.container.add(this.actionView);
    }

    protected void populateActions(RepeatingView actionView)
    {
        /* Hook */
    }
}
