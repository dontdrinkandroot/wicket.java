package net.dontdrinkandroot.wicket.example.page;

import org.apache.wicket.Component;
import org.apache.wicket.markup.head.CssContentHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropDownItem;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.page.StandardBootstrapPage;
import net.dontdrinkandroot.wicket.example.page.component.AlertPage;
import net.dontdrinkandroot.wicket.example.page.component.ComponentPage;
import net.dontdrinkandroot.wicket.example.page.component.DropDownPage;
import net.dontdrinkandroot.wicket.example.page.component.LabelPage;
import net.dontdrinkandroot.wicket.example.page.component.ModalPage;
import net.dontdrinkandroot.wicket.example.page.component.NavBarPage;
import net.dontdrinkandroot.wicket.example.page.component.ProgressBarPage;
import net.dontdrinkandroot.wicket.example.page.form.FormPage;
import net.dontdrinkandroot.wicket.example.page.form.HorizontalFormPage;
import net.dontdrinkandroot.wicket.example.page.form.StandardFormPage;


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
	protected IModel<String> createPageTitlePrefixModel()
	{
		return Model.of("wicket.example");
	}

	@Override
	protected Component createNavBar(String id)
	{
		Component navBar = super.createNavBar(id);
		navBar.add(new CssClassAppender(BootstrapCssClass.NAVBAR_FIXED_TOP));
		return navBar;
	}

	@Override
	protected Component createBrandLink(String id)
	{
		BookmarkablePageLink<Void> brandLink = new BookmarkablePageLink(id, HomePage.class);
		brandLink.setBody(Model.of("wicket.example"));

		return brandLink;
	}

	@Override
	protected void populateNavbarLeftItems(RepeatingView navbarLeftItemView)
	{
		super.populateNavbarLeftItems(navbarLeftItemView);
		navbarLeftItemView.add(
				new BookmarkablePageLinkItem(navbarLeftItemView.newChildId(), Model.of("The Grid"), GridPage.class));
		navbarLeftItemView.add(new DropDownItem(navbarLeftItemView.newChildId(), Model.of("Components")) {

			@Override
			protected void populateItems(RepeatingView itemView)
			{
				itemView.add(
						new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Nav Bars"), NavBarPage.class));
				itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Labels"), LabelPage.class));
				itemView.add(
						new BookmarkablePageLinkItem(
								itemView.newChildId(),
								Model.of("Alerts and Feedback"),
								AlertPage.class));
				itemView.add(
						new BookmarkablePageLinkItem(
								itemView.newChildId(),
								Model.of("Progress Bars"),
								ProgressBarPage.class));
				itemView.add(
						new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Dropdowns"), DropDownPage.class));
				itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Modals"), ModalPage.class));
			}

			@Override
			protected boolean isActive()
			{
				return this.getPage() instanceof ComponentPage;
			}
		});

		navbarLeftItemView.add(new DropDownItem(navbarLeftItemView.newChildId(), Model.of("Forms")) {

			@Override
			protected void populateItems(RepeatingView itemView)
			{
				itemView.add(
						new BookmarkablePageLinkItem(
								itemView.newChildId(),
								Model.of("Standard Form"),
								StandardFormPage.class));
				itemView.add(
						new BookmarkablePageLinkItem(
								itemView.newChildId(),
								Model.of("Horizontal Form"),
								HorizontalFormPage.class));
			}

			@Override
			protected boolean isActive()
			{
				return this.getPage() instanceof FormPage;
			}
		});
	}

	@Override
	public void renderHead(IHeaderResponse response)
	{
		super.renderHead(response);
		response.render(new CssContentHeaderItem("body{padding-top: 50px;}", "bodyPadding", null));
	}
}
