package net.dontdrinkandroot.wicket.bootstrap;

import net.dontdrinkandroot.wicket.bootstrap.util.WebApplicationUtils;

import org.apache.wicket.protocol.http.WebApplication;


public abstract class BootstrapWebApplication extends WebApplication {

	@Override
	protected void init() {

		super.init();
		WebApplicationUtils.mountBoostrapResources(this);
	}

}
