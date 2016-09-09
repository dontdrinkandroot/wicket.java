package net.dontdrinkandroot.wicket.extras.page;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupCheckBox;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputPassword;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import net.dontdrinkandroot.wicket.bootstrap.page.BootstrapPage;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.authentication.IAuthenticationStrategy;
import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class SignInPage extends BootstrapPage<Void>
{

    private Model<String> usernameModel = new Model<>();
    private Model<String> passwordModel = new Model<>();
    private Model<Boolean> rememberMeModel = new Model<>();

    public SignInPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected void onConfigure()
    {
        if (!this.isSignedIn()) {
            IAuthenticationStrategy authenticationStrategy =
                    this.getApplication().getSecuritySettings().getAuthenticationStrategy();
            String[] data = authenticationStrategy.load();
            if ((data != null) && (data.length > 1)) {
                if (this.signIn(data[0], data[1])) {
                    this.usernameModel = Model.of(data[0]);
                    this.passwordModel = Model.of(data[1]);
                    this.onSignInRemembered();
                } else {
                    authenticationStrategy.remove();
                }
            }
        }

        super.onConfigure();
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();
        StatelessForm<Void> form = new StatelessForm<Void>("form")
        {
            @Override
            public final void onSubmit()
            {
                SignInPage.this.onSubmit();
            }
        };
        this.add(form);

        form.add(new Label("heading", this.pageHeadingModel));

        form.add(new FormGroupInputText("username", this.createUsernameLabelModel(), this.usernameModel));

        form.add(new FormGroupInputPassword("password", this.createPasswordLabelModel(), this.passwordModel));

        FormGroupCheckBox formGroupRememberMe =
                new FormGroupCheckBox("rememberMe", this.createRememberMeLabelModel(), this.rememberMeModel);
        formGroupRememberMe.setVisible(this.isRememberMeEnabled());
        form.add(formGroupRememberMe);

        Label submitLabel = new Label("submit", this.createSubmitLabelModel());
        submitLabel.add(new ButtonBehavior(ButtonStyle.PRIMARY));
        form.add(submitLabel);

        form.add(new Label("reset", this.createResetLabelModel()).add(new ButtonBehavior()));
    }

    private void onSubmit()
    {
        IAuthenticationStrategy strategy = this.getApplication().getSecuritySettings().getAuthenticationStrategy();

        String username = this.usernameModel.getObject();
        String password = this.passwordModel.getObject();
        if (this.signIn(username, password)) {
            if (this.rememberMeModel.getObject()) {
                strategy.save(username, password);
            } else {
                strategy.remove();
            }
            this.onSignInSucceeded();
        } else {
            this.onSignInFailed();
            strategy.remove();
        }
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Login");
    }

    protected boolean isRememberMeEnabled()
    {
        return true;
    }

    protected IModel<String> createUsernameLabelModel()
    {
        return Model.of("Username");
    }

    protected IModel<String> createPasswordLabelModel()
    {
        return Model.of("Password");
    }

    protected IModel<String> createRememberMeLabelModel()
    {
        return Model.of("Remember me");
    }

    protected IModel<String> createResetLabelModel()
    {
        return Model.of("Reset");
    }

    protected IModel<String> createSubmitLabelModel()
    {
        return Model.of("Submit");
    }

    protected void onSignInRemembered()
    {
        this.continueToOriginalDestination();
        throw new RestartResponseException(this.getApplication().getHomePage());
    }

    protected void onSignInFailed()
    {
        this.error(this.getLocalizer().getString("signInFailed", this, "Sign in failed"));
    }

    protected void onSignInSucceeded()
    {
        this.continueToOriginalDestination();
        this.setResponsePage(this.getApplication().getHomePage());
    }

    private boolean isSignedIn()
    {
        return AuthenticatedWebSession.get().isSignedIn();
    }

    private boolean signIn(String username, String password)
    {
        return AuthenticatedWebSession.get().signIn(username, password);
    }
}
