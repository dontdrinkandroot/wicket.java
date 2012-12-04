package net.dontdrinkandroot.wicketexample.web.page.auth;

import org.apache.wicket.request.mapper.parameter.PageParameters;


public class LogoutPage extends AbstractAuthPage<Void> {

	public LogoutPage(final PageParameters parameters) {

		super(parameters);

		this.getSession().invalidate();
		this.info("You are now logged out.");
	}

}
