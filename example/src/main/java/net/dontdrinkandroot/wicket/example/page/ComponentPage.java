package net.dontdrinkandroot.wicket.example.page;

import org.apache.wicket.request.mapper.parameter.PageParameters;


public abstract class ComponentPage extends DecoratorPage<Void>
{

	public ComponentPage(PageParameters parameters)
	{
		super(parameters);
	}
}
