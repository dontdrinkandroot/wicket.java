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
package net.dontdrinkandroot.wicket.example.component

import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxSubmitButton
import net.dontdrinkandroot.wicket.bootstrap.component.form.RepeatingForm
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class NavbarForm(id: String?) : RepeatingForm<Void?>(id)
{
    override fun onInitialize()
    {
        super.onInitialize()
        setInline(true)
    }

    override fun populateFormGroups(formGroupView: RepeatingView)
    {
        super.populateFormGroups(formGroupView)
        val searchGroup = FormGroupInputText(formGroupView.newChildId(), Model.of("Search"), Model())
        searchGroup.setLabelScreenReaderOnly(true)
        formGroupView.add(searchGroup)
    }

    override fun populateActions(buttonView: RepeatingView)
    {
        buttonView.add(AjaxSubmitButton(buttonView.newChildId()).setBody(Model.of("Search")))
    }
}