package net.dontdrinkandroot.wicketexample.web;

import net.dontdrinkandroot.wicket.bootstrap.util.WebApplicationUtils;
import net.dontdrinkandroot.wicketexample.web.component.DateImageResource;
import net.dontdrinkandroot.wicketexample.web.page.auth.LoginPage;
import net.dontdrinkandroot.wicketexample.web.page.bootstrap.ButtonPage;
import net.dontdrinkandroot.wicketexample.web.page.resources.ResourcesPage;

import org.apache.log4j.lf5.util.Resource;
import org.apache.wicket.Page;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;


public class WicketApplication extends AuthenticatedWebApplication {

	public WicketApplication() {

		super();
	}


	@Override
	public Class<? extends Page> getHomePage() {

		return ButtonPage.class;
	}


	@Override
	protected void init() {

		super.init();

		this.getComponentInstantiationListeners().add(new SpringComponentInjector(this));

		this.getMarkupSettings().setStripWicketTags(true);

		WebApplicationUtils.mountBoostrapResources(this);

		this.getSharedResources().add(Resource.class, "dateImage", null, null, null, new DateImageResource());
		ResourceReference dateImageResource =
				this.getSharedResources().get(Resource.class, "dateImage", null, null, null, true);
		this.mountResource("images/dateImage", dateImageResource);
		this.mountPage("resources", ResourcesPage.class);

		this.mountPage("bootstrap/button", ButtonPage.class);
	}


	@Override
	protected Class<? extends WebPage> getSignInPageClass() {

		return LoginPage.class;
	}


	@Override
	protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {

		return WicketTestWebSession.class;
	}

}
