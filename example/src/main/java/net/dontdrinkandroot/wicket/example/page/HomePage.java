package net.dontdrinkandroot.wicket.example.page;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class HomePage extends DecoratorPage<Void>
{

	@Override
	protected IModel<String> createPageTitlePrefixModel()
	{
		return Model.of("wicket.example");
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return Model.of("HomePage");
	}
}
