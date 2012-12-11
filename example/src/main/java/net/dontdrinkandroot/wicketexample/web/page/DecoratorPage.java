package net.dontdrinkandroot.wicketexample.web.page;

import net.dontdrinkandroot.wicket.bootstrap.component.feedback.CloseableFeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.component.item.DropDownItem;
import net.dontdrinkandroot.wicket.bootstrap.page.BootstrapPage;
import net.dontdrinkandroot.wicketexample.web.WicketTestWebSession;
import net.dontdrinkandroot.wicketexample.web.page.auth.AbstractAuthPage;
import net.dontdrinkandroot.wicketexample.web.page.auth.AdminPage;
import net.dontdrinkandroot.wicketexample.web.page.auth.LoginPage;
import net.dontdrinkandroot.wicketexample.web.page.auth.LogoutPage;
import net.dontdrinkandroot.wicketexample.web.page.auth.UserPage;
import net.dontdrinkandroot.wicketexample.web.page.bootstrap.AbstractBootstrapPage;
import net.dontdrinkandroot.wicketexample.web.page.bootstrap.ButtonPage;
import net.dontdrinkandroot.wicketexample.web.page.component.DataTablePage;
import net.dontdrinkandroot.wicketexample.web.page.component.JQueryUiSortableListPage;
import net.dontdrinkandroot.wicketexample.web.page.component.PageHeightScalingPage;
import net.dontdrinkandroot.wicketexample.web.page.cookie.CookiePage;
import net.dontdrinkandroot.wicketexample.web.page.event.EventPage;
import net.dontdrinkandroot.wicketexample.web.page.javascript.AbstractJavascriptPage;
import net.dontdrinkandroot.wicketexample.web.page.javascript.CallbackPage;
import net.dontdrinkandroot.wicketexample.web.page.resources.ResourcesPage;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public abstract class DecoratorPage<T> extends BootstrapPage<T> {

	private CloseableFeedbackPanel feedbackPanel;


	public DecoratorPage(PageParameters parameters) {

		super(parameters);
	}


	public DecoratorPage(IModel<T> model) {

		super(model);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.feedbackPanel = new CloseableFeedbackPanel("feedbackPanel");
		this.feedbackPanel.setOutputMarkupId(true);
		this.add(this.feedbackPanel);

		this.add(new Label("pageHeader", this.getPageHeaderModel()));

		RepeatingView navItemView = new RepeatingView("navItem");
		this.createNavItems(navItemView);
		this.add(navItemView);

		// BookmarkablePageLink<?> signInLink = new BookmarkablePageLink<Void>("signInLink",
		// SignInPage.class);
		// this.add(signInLink);
		//
		// BookmarkablePageLink<?> signOutLink = new BookmarkablePageLink<Void>("signOutLink",
		// SignOutPage.class);
		// this.add(signOutLink);
		//
		// this.add(new BookmarkablePageLink<T>("buttonsLink", ButtonPage.class));
		// this.add(new BookmarkablePageLink<T>("progressLink", ProgressPage.class));
	}


	private void createNavItems(RepeatingView navItemView) {

		navItemView.add(new BookmarkablePageLinkItem<Void>(navItemView.newChildId(), ButtonPage.class, "Bootstrap") {

			@Override
			protected boolean isActive() {

				return AbstractBootstrapPage.class.isAssignableFrom(this.getPage().getClass());
			}
		});
		navItemView.add(new BookmarkablePageLinkItem<Void>(
				navItemView.newChildId(),
				ResourcesPage.class,
				"Resources"));
		navItemView.add(new BookmarkablePageLinkItem<Void>(
				navItemView.newChildId(),
				CallbackPage.class,
				"JavaScript") {

			@Override
			protected boolean isActive() {

				return AbstractJavascriptPage.class.isAssignableFrom(this.getPage().getClass());
			}
		});
		navItemView.add(new DropDownItem(navItemView.newChildId(), "Components") {

			@Override
			protected void createDropDownItems(RepeatingView itemView) {

				itemView.add(new BookmarkablePageLinkItem<Void>(
						itemView.newChildId(),
						PageHeightScalingPage.class,
						"PageHeight Scaling"));
				itemView.add(new BookmarkablePageLinkItem<Void>(
						itemView.newChildId(),
						DataTablePage.class,
						"Data Table"));
				itemView.add(new BookmarkablePageLinkItem<Void>(
						itemView.newChildId(),
						JQueryUiSortableListPage.class,
						"Sortable List"));
			}
		});

		navItemView.add(new DropDownItem(navItemView.newChildId(), "Authentication") {

			@Override
			protected void createDropDownItems(RepeatingView itemView) {

				itemView.add(new BookmarkablePageLinkItem<Void>(itemView.newChildId(), LoginPage.class, "Login") {

					@Override
					public boolean isVisible() {

						return !WicketTestWebSession.get().isSignedIn();
					}
				});
				itemView.add(new BookmarkablePageLinkItem<Void>(itemView.newChildId(), LogoutPage.class, "Logout") {

					@Override
					public boolean isVisible() {

						return WicketTestWebSession.get().isSignedIn();
					}
				});
				itemView.add(new BookmarkablePageLinkItem<Void>(itemView.newChildId(), UserPage.class, "User Page"));
				itemView.add(new BookmarkablePageLinkItem<Void>(itemView.newChildId(), AdminPage.class, "Admin Page"));
			}


			@Override
			protected boolean isActive() {

				return AbstractAuthPage.class.isAssignableFrom(this.getPage().getClass());
			}

		});

		navItemView.add(new BookmarkablePageLinkItem<Void>(navItemView.newChildId(), CookiePage.class, "Cookies"));
		navItemView.add(new BookmarkablePageLinkItem<Void>(navItemView.newChildId(), EventPage.class, "Events"));
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);

		response.render(CssHeaderItem.forCSS("body {padding-top: 60px}", "bodyPadding"));
	}


	protected IModel<String> getPageHeaderModel() {

		return this.getPageTitleModel();
	}


	protected FeedbackPanel getFeedbackPanel() {

		return this.feedbackPanel;
	}


	@Override
	protected IModel<String> getPageTitleModel() {

		return new Model<String>(this.getClass().getSimpleName());
	}

}
