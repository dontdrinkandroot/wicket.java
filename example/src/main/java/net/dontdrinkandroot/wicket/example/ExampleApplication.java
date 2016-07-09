package net.dontdrinkandroot.wicket.example;

import org.apache.wicket.Page;
import org.apache.wicket.protocol.http.WebApplication;

import net.dontdrinkandroot.wicket.example.page.HomePage;


public class ExampleApplication extends WebApplication
{

	@Override
	public Class<? extends Page> getHomePage()
	{
		return HomePage.class;
	}

}
