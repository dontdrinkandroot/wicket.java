package net.dontdrinkandroot.wicketexample.web.page.auth;

import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.authroles.authorization.strategies.role.annotations.AuthorizeInstantiation;
import org.apache.wicket.request.mapper.parameter.PageParameters;


@AuthorizeInstantiation(Roles.ADMIN)
public class AdminPage extends AbstractAuthPage<Void> {

	public AdminPage(final PageParameters parameters) {

		super(parameters);
	}

}
