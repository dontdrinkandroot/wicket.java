package net.dontdrinkandroot.wicket.bootstrap.component.panel

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.component.basic.Heading
import net.dontdrinkandroot.wicket.model.KModel
import org.apache.wicket.markup.html.panel.GenericPanel

class PanelHeading(id: String, model: KModel<String>, headingLevelModel: KModel<Heading.Level>) :
    GenericPanel<String>(id, model) {

    init {
        val title = Heading("title", model, headingLevelModel)
        title.add(CssClassAppender(BootstrapCssClass.PANEL_TITLE))
        this.add(title)
    }
}