package net.dontdrinkandroot.wicket.example;

import org.apache.wicket.Session;
import org.apache.wicket.protocol.http.WebSession;
import org.apache.wicket.request.Request;


public class ExampleWebSession extends WebSession
{

	private String currentThemeUrl = "https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css";


	public ExampleWebSession(Request request)
	{
		super(request);
	}

	public static ExampleWebSession get()
	{
		return (ExampleWebSession) Session.get();
	}

	public String getCurrentThemeUrl()
	{
		return this.currentThemeUrl;
	}

	public void setCurrentThemeUrl(String currentThemeUrl)
	{
		this.currentThemeUrl = currentThemeUrl;
	}
}
