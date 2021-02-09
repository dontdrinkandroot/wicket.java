package net.dontdrinkandroot.wicket.example.page

import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.model.Model

class HomePage : DecoratorPage<Void>() {

    override fun createPageTitleModel() = "wicket.example - Overview".model()

    override fun createPageHeadingModel() = Model<String>(null)
}