package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;


abstract public class SplitDropDownButton<T> extends GenericPanel<T>
{

	private WebMarkupContainer toggle;


	public SplitDropDownButton(String id)
	{
		super(id);
	}

	public SplitDropDownButton(String id, IModel<T> model)
	{
		super(id, model);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.BTN_GROUP));
		this.add(this.createButton("button"));
		this.add(this.toggle = new WebMarkupContainer("toggle"));
		this.add(this.createDropDownMenu("dropdownMenu"));
	}

	public WebMarkupContainer getToggle()
	{
		return this.toggle;
	}

	protected abstract Component createButton(String id);

	protected abstract Component createDropDownMenu(String id);
}
