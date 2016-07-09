package net.dontdrinkandroot.wicket.example.page;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.bootstrap.page.AbstractBootstrapPage;


public class HomePage extends AbstractBootstrapPage<Void>
{

	@Override
	protected IModel<String> getPageTitleModel()
	{
		return Model.of("HomePage");
	}

}
