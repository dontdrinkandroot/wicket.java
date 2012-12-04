package net.dontdrinkandroot.wicketexample.web.page.auth;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.request.mapper.parameter.PageParameters;


@AuthorizeInstantiation(Roles.USER)
public class UserPage extends AbstractAuthPage<Void> {

	public UserPage(final PageParameters parameters) {

		super(parameters);
	}

}
