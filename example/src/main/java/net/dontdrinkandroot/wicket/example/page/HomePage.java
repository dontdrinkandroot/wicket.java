package net.dontdrinkandroot.wicket.example.page;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.bootstrap.page.StandardBootstrapPage;


public class HomePage extends StandardBootstrapPage<Void>
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
