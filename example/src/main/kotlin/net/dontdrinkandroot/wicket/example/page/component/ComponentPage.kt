package net.dontdrinkandroot.wicket.example.page.component

import net.dontdrinkandroot.wicket.example.page.DecoratorPage
import net.dontdrinkandroot.wicket.model.ConcatenatingStringModel
import net.dontdrinkandroot.wicket.model.model
import org.apache.wicket.request.mapper.parameter.PageParameters

abstract class ComponentPage(parameters: PageParameters) : DecoratorPage<Void>(parameters) {

    override fun createPageTitlePrefixModel() =
        ConcatenatingStringModel(super.createPageTitlePrefixModel(), " - ", "Components".model())
}