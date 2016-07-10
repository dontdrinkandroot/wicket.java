package net.dontdrinkandroot.wicket.example.page;

import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssContentHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.page.StandardBootstrapPage;


public abstract class DecoratorPage<T> extends StandardBootstrapPage<T>
{

	public DecoratorPage()
	{
		super();
	}

	public DecoratorPage(PageParameters parameters)
	{
		super(parameters);
	}

	public DecoratorPage(IModel<T> model)
	{
		super(model);
	}

	@Override
	protected Component createNavBar(String id)
	{
		Component navBar = super.createNavBar(id);
		navBar.add(new CssClassAppender(BootstrapCssClass.NAVBAR_FIXED_TOP));
		return navBar;
	}

	@Override
	public void renderHead(IHeaderResponse response)
	{
		super.renderHead(response);
		response.render(new CssContentHeaderItem("body{padding-top: 50px;}", "bodyPadding", null));
	}
}
