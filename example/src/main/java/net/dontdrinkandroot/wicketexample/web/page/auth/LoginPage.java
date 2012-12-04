package net.dontdrinkandroot.wicketexample.web.page.auth;

import net.dontdrinkandroot.wicketexample.web.component.LoginPanel;

import org.apache.wicket.request.mapper.parameter.PageParameters;


public class LoginPage extends AbstractAuthPage<Void> {

	public LoginPage(final PageParameters parameters) {

		super(parameters);

		this.info("Login as \"user/user\" or \"admin/admin\"");
		this.add(new LoginPanel("loginPanel"));
	}

}
