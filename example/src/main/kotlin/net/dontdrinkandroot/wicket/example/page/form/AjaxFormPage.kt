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
package net.dontdrinkandroot.wicket.example.page.form

import net.dontdrinkandroot.wicket.bootstrap.component.button.SubmitLabelButton
import net.dontdrinkandroot.wicket.bootstrap.component.form.RepeatingAjaxForm
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class AjaxFormPage(parameters: PageParameters?) : FormPage(parameters)
{
    private var submitCount = 0
    override fun createPageHeadingModel(): IModel<String>
    {
        return Model.of("Ajax Form")
    }

    override fun onInitialize()
    {
        super.onInitialize()
        val simpleAjaxForm: RepeatingAjaxForm<Void> = object : RepeatingAjaxForm<Void>("simpleAjaxForm")
        {
            override fun populateFormGroups(formGroupView: RepeatingView)
            {
                super.populateFormGroups(formGroupView)
                formGroupView.add(
                    FormGroupInputText(
                        formGroupView.newChildId(),
                        Model.of("TextField"),
                        Model()
                    )
                )
            }

            override fun populateActions(buttonView: RepeatingView)
            {
                super.populateActions(buttonView)
                buttonView.add(SubmitLabelButton(buttonView.newChildId(), Model.of("Submit")))
            }

            override fun onSubmit(target: AjaxRequestTarget)
            {
                super.onSubmit(target)
                submitCount++
                this.info(String.format("Submitted %d times", submitCount))
                target.add(this.feedbackPanel)
            }
        }
        this.add(simpleAjaxForm)
    }
}