/*
 * Copyright (C) 2012-2017 Philip Washington Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.dontdrinkandroot.wicket.bootstrap.page;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupCheckBox;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputPassword;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupInputText;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import org.apache.wicket.Component;
import org.apache.wicket.RestartResponseException;
import org.apache.wicket.authentication.IAuthenticationStrategy;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.StatelessForm;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.model.ResourceModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class SignInPage extends BootstrapPage<Void>
{
    private Model<String> usernameModel = new Model<>();

    private Model<String> passwordModel = new Model<>();

    private Model<Boolean> rememberMeModel = new Model<>();

    private IModel<String> pageTitleModel;

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
        this.pageTitleModel = this.createPageTitleModel();

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

        form.add(new FeedbackPanel("feedback"));

        form.add(new Label("heading", this.pageTitleModel));

        FormGroupInputText formGroupUsername =
                new FormGroupInputText("username", this.createUsernameLabelModel(), this.usernameModel);
        formGroupUsername.setRequired(true);
        form.add(formGroupUsername);

        FormGroupInputPassword formGroupPassword =
                new FormGroupInputPassword("password", this.createPasswordLabelModel(), this.passwordModel);
        formGroupPassword.setRequired(true);
        form.add(formGroupPassword);

        FormGroupCheckBox formGroupRememberMe =
                new FormGroupCheckBox("rememberMe", this.createRememberMeLabelModel(), this.rememberMeModel);
        formGroupRememberMe.setVisible(this.isRememberMeEnabled());
        form.add(formGroupRememberMe);

        Label submitLabel = new Label("submit", this.createSubmitLabelModel());
        submitLabel.add(new ButtonBehavior(ButtonStyle.PRIMARY));
        form.add(submitLabel);

        form.add(new Label("reset", this.createResetLabelModel()).add(new ButtonBehavior()));

        this.add(this.createBeforePanel("beforePanel"));
        this.add(this.createAfterPanel("afterPanel"));
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
    protected Component createPageTitle(String id)
    {
        return new Label(id, this.pageTitleModel);
    }

    protected IModel<String> createPageTitleModel()
    {
        return new ResourceModel("login.title", Model.of("Login"));
    }

    protected boolean isRememberMeEnabled()
    {
        return true;
    }

    protected IModel<String> createUsernameLabelModel()
    {
        return new ResourceModel("login.username", Model.of("Username"));
    }

    protected IModel<String> createPasswordLabelModel()
    {
        return new ResourceModel("login.password", Model.of("Password"));
    }

    protected IModel<String> createRememberMeLabelModel()
    {
        return new ResourceModel("login.rememberMe", Model.of("Remember me"));
    }

    protected IModel<String> createResetLabelModel()
    {
        return new ResourceModel("login.reset", Model.of("Reset"));
    }

    protected IModel<String> createSubmitLabelModel()
    {
        return new ResourceModel("login.submit", Model.of("Submit"));
    }

    protected void onSignInRemembered()
    {
        this.continueToOriginalDestination();
        throw new RestartResponseException(this.getApplication().getHomePage());
    }

    protected void onSignInFailed()
    {
        this.error(this.getLocalizer().getString("login.signInFailed", this, "Sign in failed"));
    }

    protected void onSignInSucceeded()
    {
        this.continueToOriginalDestination();
        this.setResponsePage(this.getApplication().getHomePage());
    }

    /**
     * Create a component that is displayed on top of the login panel.
     *
     * @param id The id of the component to create.
     */
    protected Component createBeforePanel(String id)
    {
        return new WebMarkupContainer(id).setVisible(false);
    }

    /**
     * Create a component that is displayed on bottom of the login panel.
     *
     * @param id The id of the component to create.
     */
    protected Component createAfterPanel(String id)
    {
        return new WebMarkupContainer(id).setVisible(false);
    }

    protected abstract boolean isSignedIn();

    protected abstract boolean signIn(String username, String password);
}
