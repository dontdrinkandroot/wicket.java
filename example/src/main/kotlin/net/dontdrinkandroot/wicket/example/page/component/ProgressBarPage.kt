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
package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.progress.ProgressBar
import net.dontdrinkandroot.wicket.bootstrap.css.Spacing
import org.apache.wicket.ajax.AjaxRequestTarget
import org.apache.wicket.ajax.markup.html.AjaxLink
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class ProgressBarPage(parameters: PageParameters?) : ComponentPage(parameters)
{
    override fun createPageHeadingModel(): IModel<String>
    {
        return Model.of("Progress Bars")
    }

    override fun onInitialize()
    {
        super.onInitialize()
        val valueModel: IModel<Int> = Model(33)
        val defaultBar = ProgressBar("defaultBar", valueModel)
        defaultBar.add(
            CssClassAppender(
                Spacing(
                    Spacing.Property.MARGIN,
                    Spacing.Side.BOTTOM,
                    Spacing.Size.HALF
                )
            )
        )
        this.add(defaultBar)
        val updateButton: AjaxLink<Void> = object : AjaxLink<Void>("updateButton")
        {
            override fun onClick(target: AjaxRequestTarget)
            {
                valueModel.setObject(Math.round(Math.random() * 100).toInt())
                defaultBar.update(target)
            }
        }
        updateButton.body = Model.of("update")
        updateButton.add(ButtonBehavior())
        this.add(updateButton)
        val stripedBar = ProgressBar("stripedBar", valueModel, true, false)
        this.add(stripedBar)
        val animatedBar = ProgressBar("animatedBar", valueModel, true, true)
        this.add(animatedBar)
    }
}