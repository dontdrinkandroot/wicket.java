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
import org.apache.wicket.markup.html.form.upload.FileUpload;
import org.apache.wicket.markup.html.form.upload.FileUploadField;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

import java.util.List;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class FormGroupInputFile extends FormGroupFormComponent<List<FileUpload>, List<FileUpload>, FileUploadField>
{
    private boolean multiple = false;

    public FormGroupInputFile(String id, IModel<String> labelModel)
    {
        super(id, labelModel);
    }

    public FormGroupInputFile(String id, IModel<String> labelModel, IModel<List<FileUpload>> model)
    {
        super(id, labelModel, model);
    }

    @Override
    protected FileUploadField createFormComponent(String id)
    {
        FileUploadField fileUploadField = new FileUploadField(id, this.getModel());
        fileUploadField.add(new AttributeAppender("multiple", new AbstractReadOnlyModel<String>()
        {
            @Override
            public String getObject()
            {
                if (FormGroupInputFile.this.multiple) {
                    return "multiple";
                }
                return null;
            }
        }));

        return fileUploadField;
    }

    public void setMultiple(boolean multiple)
    {
        this.multiple = multiple;
    }
}
