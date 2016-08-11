package net.dontdrinkandroot.wicket.bootstrap;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;


public class TestApplication extends WebApplication
{

	@Override
	public Class<? extends Page> getHomePage()
	{
		return TestHomePage.class;
	}

}
