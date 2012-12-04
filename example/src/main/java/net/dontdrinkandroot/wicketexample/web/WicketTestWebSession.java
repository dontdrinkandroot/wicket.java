package net.dontdrinkandroot.wicketexample.web;

import org.apache.wicket.authroles.authentication.AuthenticatedWebSession;
import org.apache.wicket.authroles.authorization.strategies.role.Roles;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;


public class WicketTestWebSession extends AuthenticatedWebSession {

	private String userName;


	public WicketTestWebSession(Request request) {

		super(request);
	}


	public static WicketTestWebSession get() {

		return (WicketTestWebSession) WebSession.get();
	}


	@Override
	public Roles getRoles() {

		if ("user".equals(this.userName)) {

			return new Roles(Roles.USER);

		} else if ("admin".equals(this.userName)) {

			return new Roles(new String[] { Roles.ADMIN, Roles.USER });

		}

		return null;
	}


	@Override
	public void signOut() {

		super.signOut();
		this.userName = null;
	}


	@Override
	public boolean authenticate(String username, String password) {

		if ("user".equals(username) && "user".equals(password)) {
			this.userName = "user";
			return true;
		}

		if ("admin".equals(username) && "admin".equals(password)) {
			this.userName = "admin";
			return true;
		}

		return false;
	}

}
