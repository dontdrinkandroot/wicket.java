package net.dontdrinkandroot.wicket.bootstrap.page

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior
import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FeedbackPanel
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupCheckBox
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputPassword
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle
import net.dontdrinkandroot.wicket.model.KModel
import net.dontdrinkandroot.wicket.model.toKModel
import org.apache.wicket.Component
import org.apache.wicket.RestartResponseException
import org.apache.wicket.markup.html.WebMarkupContainer
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.html.form.StatelessForm
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.model.ResourceModel
import org.apache.wicket.request.mapper.parameter.PageParameters

abstract class SignInPage(parameters: PageParameters) : BootstrapPage<Void>(parameters) {

    private var usernameModel = Model<String>()

    private var passwordModel = Model<String>()

    private val rememberMeModel = Model<Boolean>()

    private var pageTitleModel: IModel<String>? = null

    override fun onConfigure() {
        if (!signedIn) {
            val authenticationStrategy = this.application.securitySettings.authenticationStrategy
            val data = authenticationStrategy.load()
            if (data != null && data.size > 1) {
                if (signIn(data[0], data[1])) {
                    usernameModel = Model.of(data[0])
                    passwordModel = Model.of(data[1])
                    onSignInRemembered()
                } else {
                    authenticationStrategy.remove()
                }
            }
        }
        super.onConfigure()
    }

    override fun onInitialize() {
        pageTitleModel = createPageTitleModel()
        super.onInitialize()
        val form: StatelessForm<Void> = object : StatelessForm<Void>("form") {
            public override fun onSubmit() {
                this@SignInPage.onSubmit()
            }
        }
        this.add(form)
        form.add(FeedbackPanel("feedback"))
        form.add(Label("heading", pageTitleModel))
        val formGroupUsername = FormGroupInputText("username", createUsernameLabelModel(), usernameModel)
        formGroupUsername.setRequired(true)
        form.add(formGroupUsername)
        val formGroupPassword = FormGroupInputPassword("password", createPasswordLabelModel(), passwordModel)
        formGroupPassword.setRequired(true)
        form.add(formGroupPassword)
        val formGroupRememberMe = FormGroupCheckBox("rememberMe", createRememberMeLabelModel(), rememberMeModel)
        formGroupRememberMe.isVisible = isRememberMeEnabled
        form.add(formGroupRememberMe)
        val submitLabel = Label("submit", createSubmitLabelModel())
        submitLabel.add(ButtonBehavior(ButtonStyle.PRIMARY))
        form.add(submitLabel)
        form.add(Label("reset", createResetLabelModel()).add(ButtonBehavior()))
        this.add(createBeforePanel("beforePanel"))
        this.add(createAfterPanel("afterPanel"))
    }

    private fun onSubmit() {
        val strategy = this.application.securitySettings.authenticationStrategy
        val username = usernameModel.getObject()
        val password = passwordModel.getObject()
        if (signIn(username, password)) {
            if (rememberMeModel.getObject()) {
                strategy.save(username, password)
            } else {
                strategy.remove()
            }
            onSignInSucceeded()
        } else {
            onSignInFailed()
            strategy.remove()
        }
    }

    override fun createPageTitle(id: String): Component {
        return Label(id, pageTitleModel)
    }

    protected fun createPageTitleModel(): IModel<String> {
        return ResourceModel("login.title", Model.of("Login"))
    }

    protected val isRememberMeEnabled: Boolean
        get() = true

    protected open fun createUsernameLabelModel(): KModel<String> {
        return ResourceModel("login.username", Model.of("Username")).toKModel()
    }

    protected fun createPasswordLabelModel(): KModel<String> {
        return ResourceModel("login.password", Model.of("Password")).toKModel()
    }

    protected fun createRememberMeLabelModel(): KModel<String> {
        return ResourceModel("login.rememberMe", Model.of("Remember me")).toKModel()
    }

    protected fun createResetLabelModel(): KModel<String> {
        return ResourceModel("login.reset", Model.of("Reset")).toKModel()
    }

    protected fun createSubmitLabelModel(): KModel<String> {
        return ResourceModel("login.submit", Model.of("Submit")).toKModel()
    }

    protected fun onSignInRemembered() {
        continueToOriginalDestination()
        throw RestartResponseException(this.application.homePage)
    }

    protected fun onSignInFailed() {
        this.error(this.localizer.getString("login.signInFailed", this, "Sign in failed"))
    }

    protected fun onSignInSucceeded() {
        continueToOriginalDestination()
        this.setResponsePage(this.application.homePage)
    }

    /**
     * Create a component that is displayed on top of the login panel.
     *
     * @param id The id of the component to create.
     */
    protected fun createBeforePanel(id: String): Component {
        return WebMarkupContainer(id).setVisible(false)
    }

    /**
     * Create a component that is displayed on bottom of the login panel.
     *
     * @param id The id of the component to create.
     */
    protected fun createAfterPanel(id: String): Component {
        return WebMarkupContainer(id).setVisible(false)
    }

    protected abstract val signedIn: Boolean

    protected abstract fun signIn(username: String, password: String): Boolean
}