package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.example.page.DecoratorPage
import net.dontdrinkandroot.wicket.model.ConcatenatingStringModel
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters

abstract class ComponentPage(parameters: PageParameters) : DecoratorPage<Void>(parameters) {

    override fun createPageTitlePrefixModel(): IModel<String> =
        ConcatenatingStringModel(super.createPageTitlePrefixModel(), " - ", Model("Components"))
}