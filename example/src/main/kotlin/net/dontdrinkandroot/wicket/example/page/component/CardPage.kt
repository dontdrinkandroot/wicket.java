package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.bootstrap.component.card.PlainCard
import net.dontdrinkandroot.wicket.component.basic.Heading
import net.dontdrinkandroot.wicket.markup.html.basic.Label
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

class CardPage(parameters: PageParameters) : ComponentPage(parameters) {

    override fun createPageHeadingModel() = Model("Cards")

    override fun onInitialize() {
        super.onInitialize()

        val card = object : PlainCard<Void>("card") {
            override fun createHeader(id: String) = Heading(id, Model("Card Header"), Heading.Level.H3.model())
            override fun createBody(id: String) = Label(id, Model("Card Body"))
            override fun createFooter(id: String) = Label(id, Model("Card Footer"))
        }
        add(card)
    }
}