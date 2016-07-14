package net.dontdrinkandroot.wicket.example.page;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class HomePage extends DecoratorPage<Void>
{

	@Override
	protected IModel<String> createPageTitleModel()
	{
		return Model.of("wicket.example - Overview");
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return null;
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
	}
}
