package net.dontdrinkandroot.wicket.example.component

import net.dontdrinkandroot.wicket.bootstrap.component.item.AbstractLinkItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.ItemView
import net.dontdrinkandroot.wicket.bootstrap.component.item.RepeatingDropdownItem
import net.dontdrinkandroot.wicket.example.getCurrentSession
import net.dontdrinkandroot.wicket.example.model.Theme
import net.dontdrinkandroot.wicket.example.model.availableThemes
import net.dontdrinkandroot.wicket.model.ConcatenatingStringModel
import org.apache.wicket.markup.html.link.StatelessLink
import org.apache.wicket.model.Model

class ThemeDropdownItem(id: String) : RepeatingDropdownItem<Void>(
    id,
    labelModel = ConcatenatingStringModel(Model("Theme"), ": ", { getCurrentSession().currentTheme!!.name }),
) {

    override fun populateItems(itemView: ItemView) {
        for (theme in availableThemes()) {
            itemView.add(createThemeLinkItem(itemView.newChildId(), theme))
        }
    }

    private fun createThemeLinkItem(id: String, theme: Theme): AbstractLinkItem<*, *> {
        return object : AbstractLinkItem<Void, StatelessLink<Void>>(id, label = Model.of(theme.name)) {
            override fun createLink(id: String): StatelessLink<Void> {
                return object : StatelessLink<Void>(id) {
                    override fun onClick() {
                        getCurrentSession().currentTheme = theme
                        setResponsePage(page)
                    }
                }
            }
        }
    }
}