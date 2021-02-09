package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.bootstrap.component.panel.PlainPanel
import net.dontdrinkandroot.wicket.bootstrap.component.panel.SimplePanel
import net.dontdrinkandroot.wicket.bootstrap.css.PanelStyle
import net.dontdrinkandroot.wicket.component.basic.Heading
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.Component
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.request.mapper.parameter.PageParameters

class PanelPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel() = "Panels".model()

    override fun onInitialize() {
        super.onInitialize()
        val panelStyleView = RepeatingView("panelStyle")
        this.add(panelStyleView)
        for (panelStyle in PanelStyle.values()) {
            val panel: SimplePanel<*> =
                SimplePanel<Void>(
                    panelStyleView.newChildId(),
                    headingModel = panelStyle.name.model(),
                    headingLevelModel = Heading.Level.H3.model(),
                    styleModel = panelStyle.model()
                )
            panelStyleView.add(panel)
        }
        val panelFooter: PlainPanel<*> = object : PlainPanel<Void>("panelFooter", null) {
            override fun createBody(id: String): Component {
                return Label(id, "Body")
            }

            override fun createFooter(id: String): Component {
                return Label(id, "Footer")
            }
        }
        this.add(panelFooter)
    }
}