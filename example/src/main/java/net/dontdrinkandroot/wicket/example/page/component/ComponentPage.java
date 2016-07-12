package net.dontdrinkandroot.wicket.example.page.component;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.example.page.DecoratorPage;


public abstract class ComponentPage extends DecoratorPage<Void>
{

	public ComponentPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected IModel<String> createPageTitlePrefixModel()
	{
		return Model.of("Components");
	}
}
