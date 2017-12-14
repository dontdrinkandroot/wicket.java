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

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.HTML5Attributes;
import org.apache.wicket.markup.html.form.TextArea;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

/**
 * @param <T> Type of the model object.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupTextArea<T> extends FormGroupFormComponent<T, T, TextArea<T>>
{
    private int rows = 5;

    public FormGroupTextArea(String id, IModel<String> labelModel, IModel<T> model)
    {
        super(id, labelModel, model);
    }

    @Override
    protected TextArea<T> createFormComponent(String id)
    {
        TextArea<T> textArea = new TextArea<T>(id, this.getModel());
        textArea.add(new AttributeAppender("rows", new AbstractReadOnlyModel<Integer>()
        {

            @Override
            public Integer getObject()
            {
                return FormGroupTextArea.this.rows;
            }
        }));
        textArea.add(new HTML5Attributes());
        return textArea;
    }

    public void setRows(int rows)
    {
        this.rows = rows;
    }
}
