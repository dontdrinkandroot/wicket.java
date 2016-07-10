package net.dontdrinkandroot.wicket.bootstrap.page;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public abstract class StandardBootstrapPage<T> extends BootstrapPage<T>
{

	public StandardBootstrapPage()
	{
		super();
	}

	public StandardBootstrapPage(PageParameters parameters)
	{
		super(parameters);
	}

	public StandardBootstrapPage(IModel<T> model)
	{
		super(model);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		Label pageHeading = new Label("pageHeading", this.pageHeadingModel);
		this.add(pageHeading);

		RepeatingView primaryActionView = new RepeatingView("primaryAction");
		this.populatePrimaryActions(primaryActionView);
		this.add(primaryActionView);
	}

	protected void populatePrimaryActions(RepeatingView primaryActionView)
	{
		/* Overwrite in order to add primary actions */
	}

}
