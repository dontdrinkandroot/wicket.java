package page

import org.apache.wicket.Component
import org.apache.wicket.markup.html.GenericWebPage
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.model.IModel
import org.apache.wicket.request.mapper.parameter.PageParameters

/**
 * @param <T> Type of the model object.
 */
open class Html5ScaffoldPage<T> : GenericWebPage<T> {

    constructor(model: IModel<T>? = null) : super(model)

    constructor(parameters: PageParameters) : super(parameters)

    override fun onInitialize() {
        super.onInitialize()
        this.add(createPageTitle("pageTitle"))
    }

    /**
     * Creates the [Component] that displays the page title. Invisible by default.
     *
     * @param id The id to use when generating the component.
     * @return The page title component.
     */
    protected open fun createPageTitle(id: String): Component {
        val pageTitleContainer = WebMarkupContainer(id)
        pageTitleContainer.isVisible = false
        return pageTitleContainer
    }
}