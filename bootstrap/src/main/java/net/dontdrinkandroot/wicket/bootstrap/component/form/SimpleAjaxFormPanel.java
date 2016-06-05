package net.dontdrinkandroot.wicket.bootstrap.component.form;

import org.apache.wicket.Component;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.PanelStyle;
import net.dontdrinkandroot.wicket.component.basic.Heading;
import net.dontdrinkandroot.wicket.component.basic.Heading.Level;


public class SimpleAjaxFormPanel<T> extends SimpleAjaxForm<T>
{

	private final IModel<PanelStyle> styleModel = Model.of(PanelStyle.DEFAULT);

	private Level headingLevel = Level.H2;

	private IModel<String> titleModel;


	public SimpleAjaxFormPanel(String id, IModel<String> titleModel)
	{
		super(id);
		this.titleModel = titleModel;
	}

	public SimpleAjaxFormPanel(String id, IModel<String> titleModel, IModel<T> model)
	{
		super(id, model);
		this.titleModel = titleModel;
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.PANEL));
		this.add(new CssClassAppender(this.styleModel));

		Heading title = new Heading("title", this.titleModel, this.headingLevel);
		this.add(title);
	}

	public SimpleAjaxFormPanel<T> setHeadingLevel(Level headingLevel)
	{
		this.headingLevel = headingLevel;
		return this;
	}

	@Override
	protected Component createActionsView(String id)
	{
		RepeatingView actionsView = new RepeatingView(id);
		this.populateActions(actionsView);

		return actionsView;
	}

}
