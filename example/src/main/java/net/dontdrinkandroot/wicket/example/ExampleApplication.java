package net.dontdrinkandroot.wicket.example;

import org.apache.wicket.Page;
import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebApplication;
import org.apache.wicket.request.Request;
import org.apache.wicket.request.Response;

import net.dontdrinkandroot.wicket.example.page.HomePage;


public class ExampleApplication extends WebApplication
{

	@Override
	public Class<? extends Page> getHomePage()
	{
		return HomePage.class;
	}

	@Override
	protected void init()
	{
		super.init();

		this.getMarkupSettings().setStripWicketTags(true);
	}

	@Override
	public Session newSession(Request request, Response response)
	{
		return new ExampleWebSession(request);
	}

}
