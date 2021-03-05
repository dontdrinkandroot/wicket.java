package net.dontdrinkandroot.wicket.example.page

import org.apache.wicket.model.Model

class HomePage : DecoratorPage<Void>() {

    override fun createPageTitleModel() = Model("wicket.example - Overview")

    override fun createPageHeadingModel() = Model<String>(null)
}