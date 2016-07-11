package net.dontdrinkandroot.wicket.bootstrap.page;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.NavBar;


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

		Component navBar = this.createNavBar("navBar");
		this.add(navBar);

		Label pageHeading = new Label("pageHeading", this.pageHeadingModel);
		this.add(pageHeading);

		RepeatingView primaryActionView = new RepeatingView("primaryAction");
		this.populatePrimaryActions(primaryActionView);
		this.add(primaryActionView);

		this.add(this.createFeedbackPanel("feedback"));
	}

	protected Component createFeedbackPanel(String id)
	{
		return new FencedFeedbackPanel(id);
	}

	protected void populatePrimaryActions(RepeatingView primaryActionView)
	{
		/* Overwrite in order to add primary actions */
	}

	protected Component createNavBar(String id)
	{
		NavBar navBar = new NavBar(id) {

			@Override
			protected Component createBrandLink(String id)
			{
				return StandardBootstrapPage.this.createBrandLink(id);
			}

			@Override
			protected void populateNavbarLeftItems(RepeatingView navbarLeftItemView)
			{
				StandardBootstrapPage.this.populateNavbarLeftItems(navbarLeftItemView);
			}

			@Override
			protected Component createNavBarForm(String id)
			{
				return StandardBootstrapPage.this.createNavBarForm(id);
			}

			@Override
			protected void populateNavbarRightItems(RepeatingView navbarRightItemView)
			{
				StandardBootstrapPage.this.populateNavbarRightItems(navbarRightItemView);
			}
		};
		return navBar;
	}

	protected Component createBrandLink(String id)
	{
		WebMarkupContainer brandLink = new WebMarkupContainer(id);
		brandLink.setVisible(false);
		return brandLink;
	}

	protected void populateNavbarLeftItems(RepeatingView navbarLeftItemView)
	{
		/* Overwrite to populate navbar items on left side */
	}

	protected Component createNavBarForm(String id)
	{
		WebMarkupContainer navBarForm = new WebMarkupContainer(id);
		navBarForm.setVisible(false);

		return navBarForm;
	}

	protected void populateNavbarRightItems(RepeatingView navbarLeftItemView)
	{
		/* Overwrite to populate navbar items on right side */
	}
}
