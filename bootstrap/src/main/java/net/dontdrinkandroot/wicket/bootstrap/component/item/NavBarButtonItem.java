package net.dontdrinkandroot.wicket.bootstrap.component.item;

import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;


public abstract class NavBarButtonItem<T> extends AbstractItem<T>
{

	public NavBarButtonItem(String id)
	{
		super(id);
	}

	public NavBarButtonItem(String id, IModel<T> model)
	{
		super(id, model);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		AbstractLink link = this.createLink("button");
		link.add(new ButtonBehavior());
		link.add(new CssClassAppender(BootstrapCssClass.NAVBAR_BTN));
		this.add(link);
	}

	protected abstract AbstractLink createLink(String id);

}
