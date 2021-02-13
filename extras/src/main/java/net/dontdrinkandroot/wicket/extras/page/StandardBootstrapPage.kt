package net.dontdrinkandroot.wicket.extras.page

import net.dontdrinkandroot.wicket.bootstrap.behavior.ModalRequestBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.Navbar
import net.dontdrinkandroot.wicket.bootstrap.page.BootstrapPage
import net.dontdrinkandroot.wicket.model.ConcatenatingStringModel
import org.apache.wicket.Component
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.panel.FeedbackPanel
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.request.mapper.parameter.PageParameters
import org.apache.wicket.util.string.Strings

abstract class StandardBootstrapPage<T> : BootstrapPage<T> {

    var feedbackPanel: FeedbackPanel? = null
        private set

    var pageHeading: Label? = null
        private set

    private lateinit var pageHeadingModel: IModel<String>

    constructor(parameters: PageParameters) : super(parameters)

    constructor(model: IModel<T>? = null) : super(model)

    override fun onInitialize() {
        pageHeadingModel = createPageHeadingModel()
        super.onInitialize()
        this.add(createModal(MODAL_ID))
        val navBar = createNavbar("navbar")
        this.add(navBar)
        pageHeading = Label("pageHeading", pageHeadingModel)
        val primaryActionView = RepeatingView("primaryAction")
        populatePrimaryActions(primaryActionView)
        val pageHeader: WebMarkupContainer = object : WebMarkupContainer("pageHeader") {
            override fun onConfigure() {
                super.onConfigure()
                val hasHeading = (null != pageHeadingModel
                        && !Strings.isEmpty(pageHeadingModel.getObject()))
                val hasPrimaryActions = primaryActionView.size() > 0
                this.isVisible = hasHeading || hasPrimaryActions
            }
        }
        this.add(pageHeader)
        pageHeader.add(pageHeading)
        pageHeader.add(primaryActionView)
        feedbackPanel = createFeedbackPanel("feedback")
        feedbackPanel!!.outputMarkupId = true
        this.add(feedbackPanel)
        this.add(createFooter("footer"))
        this.add(ModalRequestBehavior(MODAL_ID))
    }

    override fun createPageTitle(id: String): Component {
        return Label(id, createPageTitleModel())
    }

    private fun createModal(id: String): Component {
        val modalContainer = WebMarkupContainer(id)
        modalContainer.outputMarkupId = true
        return modalContainer
    }

    protected fun createFeedbackPanel(id: String): FeedbackPanel {
        return FencedFeedbackPanel(id)
    }

    protected fun populatePrimaryActions(primaryActionView: RepeatingView?) {
        /* Overwrite in order to add primary actions */
    }

    protected open fun createNavbar(id: String): Navbar = Navbar(id)

    protected fun createFooter(id: String) = WebMarkupContainer(id).setVisible(false)

    protected open fun createPageTitlePrefixModel(): IModel<String> = Model(null)

    protected open fun createPageTitleModel(): IModel<String> =
        ConcatenatingStringModel(createPageTitlePrefixModel(), " - ", pageHeadingModel)

    protected abstract fun createPageHeadingModel(): IModel<String>

    companion object {

        const val MODAL_ID = "modal"
    }
}