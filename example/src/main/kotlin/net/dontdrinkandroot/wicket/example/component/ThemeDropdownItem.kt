package net.dontdrinkandroot.wicket.example.component

import net.dontdrinkandroot.wicket.bootstrap.component.item.AbstractLinkItem
import net.dontdrinkandroot.wicket.bootstrap.component.item.RepeatingDropdownItem
import net.dontdrinkandroot.wicket.example.getCurrentSession
import net.dontdrinkandroot.wicket.example.model.Theme
import net.dontdrinkandroot.wicket.example.model.availableThemes
import net.dontdrinkandroot.wicket.model.ConcatenatingStringModel
import org.apache.wicket.markup.html.link.StatelessLink
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

class ThemeDropdownItem(id: String) : RepeatingDropdownItem<Void?>(
    id,
    ConcatenatingStringModel(
        Model.of("Theme"),
        ": ",
        IModel { getCurrentSession().currentTheme!!.name } as IModel<String>
    )
) {

    override fun populateItems(itemView: RepeatingView) {
        for (theme in availableThemes()) {
            itemView.add(createThemeLinkItem(itemView.newChildId(), theme))
        }
    }

    protected fun createThemeLinkItem(id: String, theme: Theme): AbstractLinkItem<*, *> {
        return object : AbstractLinkItem<Void?, StatelessLink<Void?>?>(id, Model.of(theme.name)) {
            override fun createLink(id: String): StatelessLink<Void?> {
                return object : StatelessLink<Void?>(id) {
                    override fun onClick() {
                        getCurrentSession().currentTheme = theme
                        setResponsePage(page)
                    }
                }
            }
        }
    }
}