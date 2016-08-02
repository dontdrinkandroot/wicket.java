package net.dontdrinkandroot.wicket.example;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;

import net.dontdrinkandroot.wicket.example.model.Theme;


public class ExampleWebSession extends WebSession
{

	private Theme currentTheme;


	public ExampleWebSession(Request request)
	{
		super(request);
	}

	public static ExampleWebSession get()
	{
		return (ExampleWebSession) Session.get();
	}

	public Theme getCurrentTheme()
	{
		if (null == this.currentTheme) {
			this.currentTheme = Theme.getAvailableThemes().iterator().next();
		}

		return this.currentTheme;
	}

	public void setCurrentTheme(Theme theme)
	{
		this.currentTheme = theme;
	}
}
