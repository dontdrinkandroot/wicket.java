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

import net.dontdrinkandroot.wicket.bootstrap.component.item.AbstractLinkItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.RepeatingDropdownItem
import net.dontdrinkandroot.wicket.example.ExampleWebSession.Companion.get
import net.dontdrinkandroot.wicket.example.model.Theme
import net.dontdrinkandroot.wicket.model.ConcatenatingStringModel
import org.apache.wicket.markup.html.link.StatelessLink
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class ThemeDropdownItem(id: String) : RepeatingDropdownItem<Void?>(
    id,
    ConcatenatingStringModel(
        Model.of("Theme"),
        ": ",
        IModel { get().currentTheme!!.name } as IModel<String>
    )
)
{
    override fun populateItems(itemView: RepeatingView)
    {
        for (theme in Theme.availableThemes)
        {
            itemView.add(createThemeLinkItem(itemView.newChildId(), theme))
        }
    }

    protected fun createThemeLinkItem(
        id: String?,
        theme: Theme
    ): AbstractLinkItem<*, *>
    {
        return object : AbstractLinkItem<Void?, StatelessLink<Void?>?>(id, Model.of(theme.name))
        {
            override fun createLink(id: String): StatelessLink<Void?>?
            {
                return object : StatelessLink<Void?>(id)
                {
                    override fun onClick()
                    {
                        get().currentTheme = theme
                        setResponsePage(page)
                    }
                }
            }
        }
    }
}