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

import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormStyleBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.item.AjaxLinkItem
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeStack
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.markup.html.form.Form
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class FormGroupPage(parameters: PageParameters?) : FormPage(parameters)
{
    protected var formStyleBehavior = FormStyleBehavior().setHorizontal(ColumnSizeStack.FORM_DEFAULT)
    override fun createPageHeadingModel(): IModel<String>
    {
        return Model.of("Form Groups and Form Styles")
    }

    override fun onInitialize()
    {
        super.onInitialize()
        val styleItemView = RepeatingView("styleItem")
        this.add(styleItemView)
        styleItemView.add(object : AjaxLinkItem<Void?>(styleItemView.newChildId(), Model.of("Default"))
        {
            override fun onClick(target: AjaxRequestTarget)
            {
                formStyleBehavior.reset()
                this.setResponsePage(this.page)
            }

            override fun isActive(): Boolean
            {
                return (!formStyleBehavior.isInline
                        && !formStyleBehavior.isHorizontal)
            }
        })
        styleItemView.add(object : AjaxLinkItem<Void?>(styleItemView.newChildId(), Model.of("Horizontal"))
        {
            override fun onClick(target: AjaxRequestTarget)
            {
                formStyleBehavior.setHorizontal(ColumnSizeStack.FORM_DEFAULT)
                this.setResponsePage(this.page)
            }

            override fun isActive(): Boolean
            {
                return formStyleBehavior.isHorizontal
            }
        })
        styleItemView.add(object : AjaxLinkItem<Void?>(styleItemView.newChildId(), Model.of("Inline"))
        {
            override fun onClick(target: AjaxRequestTarget)
            {
                formStyleBehavior.isInline = true
                this.setResponsePage(this.page)
            }

            override fun isActive(): Boolean
            {
                return formStyleBehavior.isInline
            }
        })
        val form = Form<Void>("form")
        form.add(formStyleBehavior)
        this.add(form)
        val formGroupView = RepeatingView("formGroup")
        populateFormGroups(form, formGroupView)
        form.add(formGroupView)
    }
}