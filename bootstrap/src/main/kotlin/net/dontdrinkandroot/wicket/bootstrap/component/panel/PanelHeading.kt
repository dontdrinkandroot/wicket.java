package net.dontdrinkandroot.wicket.bootstrap.component.panel

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.component.basic.Heading
import org.apache.wicket.markup.html.panel.GenericPanel
import org.apache.wicket.model.IModel

class PanelHeading(id: String, model: IModel<String>, headingLevelModel: IModel<Heading.Level>) :
    GenericPanel<String>(id, model) {

    init {
        val title = Heading("title", model, headingLevelModel)
        title.add(CssClassAppender(BootstrapCssClass.PANEL_TITLE))
        this.add(title)
    }
}