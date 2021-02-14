package net.dontdrinkandroot.wicket.bootstrap.page

import org.apache.wicket.Component
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.model.ResourceModel
import org.apache.wicket.request.mapper.parameter.PageParameters

class SignOutPage(parameters: PageParameters = PageParameters()) : BootstrapPage<Void>(parameters) {

    private lateinit var pageTitleModel: IModel<String>

    init {
        this.session.invalidate()
    }

    override fun onInitialize() {
        pageTitleModel = createPageTitleModel()
        super.onInitialize()
        this.add(Label("message", createPageTitleModel()))
    }

    override fun createPageTitle(id: String): Component {
        return Label(id, pageTitleModel)
    }

    protected fun createPageTitleModel(): IModel<String> {
        return ResourceModel("logout.success", Model.of("You have been signed out successfully"))
    }
}