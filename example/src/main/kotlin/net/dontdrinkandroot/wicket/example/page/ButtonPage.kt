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
package net.dontdrinkandroot.wicket.example.page

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.button.ButtonGroupChoice
import net.dontdrinkandroot.wicket.bootstrap.component.button.DropdownButton
import net.dontdrinkandroot.wicket.bootstrap.component.button.SplitDropdownButton
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.example.page.component.ComponentPage
import org.apache.wicket.Component
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters
import java.util.*

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class ButtonPage(parameters: PageParameters?) : ComponentPage(parameters)
{
    override fun createPageHeadingModel(): IModel<String>
    {
        return Model.of("Buttons")
    }

    override fun onInitialize()
    {
        super.onInitialize()
        val styleView = RepeatingView("buttonStyle")
        this.add(styleView)
        for (style in ButtonStyle.values())
        {
            val button = Label(styleView.newChildId(), Model.of(style.name))
            button.add(ButtonBehavior(Model.of(style)))
            styleView.add(button)
        }
        val sizeView = RepeatingView("buttonSize")
        this.add(sizeView)
        for (size in ButtonSize.values())
        {
            val button = Label(sizeView.newChildId(), Model.of(size.name))
            button.add(ButtonBehavior().setButtonSize(size))
            sizeView.add(button)
        }
        val dropdownButton: DropdownButton<Void> =
            object : DropdownButton<Void>("dropdownButton", null, Model.of("My Label"))
            {
                override fun populateItems(itemView: RepeatingView)
                {
                    populateDropdownItems(itemView)
                }
            }
        this.add(dropdownButton)
        val dropupButton: DropdownButton<Void> =
            object : DropdownButton<Void>("dropupButton", null, Model.of("DropUp"))
            {
                override fun populateItems(itemView: RepeatingView)
                {
                    populateDropdownItems(itemView)
                }
            }
        dropupButton.add(CssClassAppender(BootstrapCssClass.DROPUP))
        this.add(dropupButton)
        val splitDropdownButton: SplitDropdownButton<Void> = object : SplitDropdownButton<Void>("splitDropdownButton")
        {
            override fun createAction(id: String): Component
            {
                return Label(id, "Action")
            }

            override fun populateItems(itemView: RepeatingView)
            {
                populateDropdownItems(itemView)
            }
        }
        this.add(splitDropdownButton)
        val choices = Arrays.asList("Red", "Green", "Blue")
        val buttonGroupChoice = ButtonGroupChoice("buttonGroupChoice", Model.of(choices.iterator().next()), choices)
        this.add(buttonGroupChoice)
    }

    protected fun populateDropdownItems(itemView: RepeatingView)
    {
        itemView.add(
            BookmarkablePageLinkItem<Void, ButtonPage>(
                itemView.newChildId(),
                Model.of("This is a link"),
                ButtonPage::class.java
            )
        )
    }
}