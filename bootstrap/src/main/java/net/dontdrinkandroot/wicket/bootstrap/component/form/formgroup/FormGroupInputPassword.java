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
import net.dontdrinkandroot.wicket.bootstrap.component.form.inputgroup.InputGroupPassword;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.form.PasswordTextField;
import org.apache.wicket.model.IModel;


public class FormGroupInputPassword
        extends FormGroupInputGroup<String, String, PasswordTextField, InputGroupPassword>
{

    public FormGroupInputPassword(String id, IModel<String> labelModel, IModel<String> model)
    {
        super(id, labelModel, model);
    }

    @Override
    protected InputGroup<String, String, PasswordTextField> createInputGroup(String id)
    {
        return new InputGroupPassword(id, this.getModel())
        {

            @Override
            protected Component createInputGroupAddonBefore(String id)
            {
                return FormGroupInputPassword.this.createInputGroupAddonBefore(id);
            }

            @Override
            protected Component createInputGroupAddonAfter(String id)
            {
                return FormGroupInputPassword.this.createInputGroupAddonAfter(id);
            }
        };
    }

}
