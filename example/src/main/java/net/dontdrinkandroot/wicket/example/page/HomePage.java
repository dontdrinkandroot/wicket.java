package net.dontdrinkandroot.wicket.example.page;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class HomePage extends DecoratorPage<Void>
{

	@Override
	protected IModel<String> createPageTitlePrefixModel()
	{
		return new Model<String>();
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return Model.of("wicket.example");
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
	}
}
