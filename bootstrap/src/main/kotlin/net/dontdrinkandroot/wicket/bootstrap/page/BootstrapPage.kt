package net.dontdrinkandroot.wicket.bootstrap.page

import net.dontdrinkandroot.wicket.bootstrap.headeritem.BootstrapCssHeaderItem
import net.dontdrinkandroot.wicket.bootstrap.headeritem.BootstrapJsHeaderItem
import net.dontdrinkandroot.wicket.page.Html5ScaffoldPage
import org.apache.wicket.markup.head.HeaderItem
import org.apache.wicket.markup.head.IHeaderResponse
import org.apache.wicket.model.IModel
import org.apache.wicket.request.mapper.parameter.PageParameters

abstract class BootstrapPage<T> : Html5ScaffoldPage<T> {

    protected open val bootstrapJavaScriptHeaderItem: HeaderItem
        get() = BootstrapJsHeaderItem()

    protected open val bootstrapCssHeaderItem: HeaderItem
        get() = BootstrapCssHeaderItem()

    constructor(parameters: PageParameters) : super(parameters)

    constructor(model: IModel<T>? = null) : super(model)

    override fun renderHead(response: IHeaderResponse) {
        super.renderHead(response)
        response.render(bootstrapJavaScriptHeaderItem)
        response.render(bootstrapCssHeaderItem)
    }
}