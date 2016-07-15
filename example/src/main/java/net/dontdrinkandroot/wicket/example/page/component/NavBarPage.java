package net.dontdrinkandroot.wicket.example.page.component;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.DividerItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropDownItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.HeaderItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.NavBarButtonItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.NavBarTextItem;
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.InnerNavBar;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.NavBarStyle;
import net.dontdrinkandroot.wicket.example.component.NavBarForm;
import net.dontdrinkandroot.wicket.example.page.HomePage;


public class NavBarPage extends ComponentPage
{

	public NavBarPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return Model.of("Nav Bars");
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		InnerNavBar navBarDefault = new InnerNavBar("navBarDefault") {

			@Override
			protected Component createBrand(String id)
			{
				BookmarkablePageLink<Void> brandLink = new BookmarkablePageLink<Void>(id, HomePage.class);
				brandLink.setBody(Model.of("Brand"));
				return brandLink;
			}

			@Override
			protected Component createForm(String id)
			{
				return NavBarPage.this.createExampleNavBarForm(id);
			}

			@Override
			protected void populateNavbarLeftItems(RepeatingView itemView)
			{
				NavBarPage.this.populateNavbarLeftItems(itemView);
			}

			@Override
			protected void populateNavbarLeftCollapseItems(RepeatingView navbarLeftItemView)
			{
				NavBarPage.this.populateExampleNavbarLeftCollapseItems(navbarLeftItemView);
			}

			@Override
			protected void populateNavbarRightCollapseItems(RepeatingView navbarRightItemView)
			{
				NavBarPage.this.populateExampleNavbarRightCollapseItems(navbarRightItemView);
			}
		};
		this.add(navBarDefault);

		InnerNavBar navBarInverse = new InnerNavBar("navBarInverse") {

			@Override
			protected Component createBrand(String id)
			{
				BookmarkablePageLink<Void> brandLink = new BookmarkablePageLink<Void>(id, HomePage.class);
				brandLink.setBody(Model.of("Brand"));
				return brandLink;
			}

			@Override
			protected Component createForm(String id)
			{
				return NavBarPage.this.createExampleNavBarForm(id);
			}

			@Override
			protected void populateNavbarLeftItems(RepeatingView itemView)
			{
				NavBarPage.this.populateNavbarLeftItems(itemView);
			}

			@Override
			protected void populateNavbarLeftCollapseItems(RepeatingView navbarLeftItemView)
			{
				NavBarPage.this.populateExampleNavbarLeftCollapseItems(navbarLeftItemView);
			}

			@Override
			protected void populateNavbarRightCollapseItems(RepeatingView navbarRightItemView)
			{
				NavBarPage.this.populateExampleNavbarRightCollapseItems(navbarRightItemView);
			}
		};
		navBarInverse.setStyle(NavBarStyle.INVERSE);
		this.add(navBarInverse);
	}

	protected Component createExampleNavBarForm(String id)
	{
		NavBarForm navBarForm = new NavBarForm(id);
		navBarForm.add(new CssClassAppender(BootstrapCssClass.NAVBAR_LEFT));

		return navBarForm;
	}

	@Override
	protected void populateNavbarLeftItems(RepeatingView itemView)
	{
		itemView.add(new DropDownItem(itemView.newChildId(), Model.of("DropDown")) {

			@Override
			protected void populateItems(RepeatingView itemView)
			{
				itemView.add(new BookmarkablePageLinkItem(itemView.newChildId(), Model.of("Action"), HomePage.class));
				itemView.add(new DividerItem(itemView.newChildId()));
				itemView.add(new HeaderItem(itemView.newChildId(), Model.of("A Header")));
				itemView.add(
						new BookmarkablePageLinkItem(
								itemView.newChildId(),
								Model.of("Another Action"),
								HomePage.class));

			}
		});

	}

	protected void populateExampleNavbarLeftCollapseItems(RepeatingView itemView)
	{
		itemView.add(new NavBarButtonItem<Void>(itemView.newChildId()) {

			@Override
			protected AbstractLink createLink(String id)
			{
				return new BookmarkablePageLink<Void>(id, HomePage.class).setBody(Model.of("Button"));
			}
		});

	}

	protected void populateExampleNavbarRightCollapseItems(RepeatingView itemView)
	{
		itemView.add(new NavBarTextItem(itemView.newChildId(), Model.of("Text")));
	}
}
