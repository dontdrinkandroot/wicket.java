package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.bootstrap.component.panel.PlainPanel
import net.dontdrinkandroot.wicket.bootstrap.component.panel.SimplePanel
import net.dontdrinkandroot.wicket.bootstrap.css.PanelStyle
import net.dontdrinkandroot.wicket.component.basic.Heading
import org.apache.wicket.Component
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class PanelPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel(): IModel<String> {
        return Model.of("Panels")
    }

    override fun onInitialize() {
        super.onInitialize()
        val panelStyleView = RepeatingView("panelStyle")
        this.add(panelStyleView)
        for (panelStyle in PanelStyle.values())
        {
            val panel: SimplePanel<*> =
                SimplePanel<Void>(panelStyleView.newChildId(), Model.of(panelStyle.name), Heading.Level.H3)
            panel.panelStyle = panelStyle
            panelStyleView.add(panel)
        }
        val panelFooter: PlainPanel<*> = object : PlainPanel<Void?>("panelFooter")
        {
            override fun createBody(id: String): Component
            {
                return Label(id, "Body")
            }

            override fun createFooter(id: String): Component
            {
                return Label(id, "Footer")
            }
        }
        this.add(panelFooter)
    }
}