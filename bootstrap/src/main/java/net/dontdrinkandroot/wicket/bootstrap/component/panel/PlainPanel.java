package net.dontdrinkandroot.wicket.bootstrap.component.panel;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.component.basic.Heading;
import net.dontdrinkandroot.wicket.component.basic.Heading.Level;


public class PlainPanel<T> extends Panel<T>
{

	private final IModel<String> headingModel;

	private final Level headingLevel;

	private Component body;


	public PlainPanel(String id, IModel<String> headingModel, Heading.Level headingLevel)
	{
		super(id);

		this.headingModel = headingModel;
		this.headingLevel = headingLevel;
	}

	public PlainPanel(String id, IModel<T> model, IModel<String> headingModel, Heading.Level headingLevel)
	{
		super(id, model);

		this.headingModel = headingModel;
		this.headingLevel = headingLevel;
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		this.body = this.createBodyComponent("body");
		this.add(this.body);
	}

	@Override
	protected Component createFooterComponent(String id)
	{
		final WebMarkupContainer footerContainer = new WebMarkupContainer(id);
		footerContainer.setVisible(false);

		return footerContainer;
	}

	protected Component createBodyComponent(String id)
	{
		final WebMarkupContainer bodyContainer = new WebMarkupContainer(id);
		bodyContainer.setVisible(false);

		return bodyContainer;
	}

	@Override
	protected Component createAfterBodyComponent(String id)
	{
		final WebMarkupContainer afterBodyContainer = new WebMarkupContainer(id);
		afterBodyContainer.setVisible(false);

		return afterBodyContainer;
	}

	@Override
	protected Component createHeadingComponent(String id)
	{
		return new PanelHeading(id, this.headingModel, this.headingLevel);
	}

}
