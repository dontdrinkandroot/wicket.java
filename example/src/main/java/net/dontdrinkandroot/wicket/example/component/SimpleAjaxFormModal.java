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
package net.dontdrinkandroot.wicket.example.component;

import net.dontdrinkandroot.wicket.bootstrap.component.button.SubmitLabelButton;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupStatic;
import net.dontdrinkandroot.wicket.bootstrap.component.modal.AjaxFormModal;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

public class SimpleAjaxFormModal extends AjaxFormModal<Void>
{
    public SimpleAjaxFormModal(String id)
    {
        super(id);
    }

    @Override
    protected IModel<String> createHeadingModel()
    {
        return Model.of("This is a form modal");
    }

    @Override
    protected void populateFormGroups(RepeatingView formGroupView)
    {
        formGroupView.add(
                new FormGroupStatic(
                        formGroupView.newChildId(),
                        Model.of(FormGroupStatic.class.getSimpleName()),
                        Model.of("A static label")
                ));
        FormGroupInputText formGroupInputText = new FormGroupInputText(
                formGroupView.newChildId(),
                Model.of(FormGroupInputText.class.getSimpleName()),
                Model.of("")
        );
        formGroupInputText.setRequired(true);
        formGroupInputText.addDefaultAjaxInputValidation();
        formGroupView.add(formGroupInputText);
    }

    @Override
    protected void populateFormActions(RepeatingView formActionView)
    {
        formActionView.add(new SubmitLabelButton(formActionView.newChildId(), Model.of("Submit")));
    }
}
