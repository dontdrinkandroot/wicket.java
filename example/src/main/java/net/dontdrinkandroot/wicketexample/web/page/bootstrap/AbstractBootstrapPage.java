package net.dontdrinkandroot.wicketexample.web.page.bootstrap;

import net.dontdrinkandroot.wicket.bootstrap.component.nav.NavItemBookmarkablePageLink;
import net.dontdrinkandroot.wicketexample.web.page.DecoratorSidebarPage;

import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class AbstractBootstrapPage<T> extends DecoratorSidebarPage<T> {

	public AbstractBootstrapPage(PageParameters parameters) {

		super(parameters);
	}


	@Override
	protected void createNavItems(RepeatingView navItemView) {

		navItemView.add(new NavItemBookmarkablePageLink<Void>(navItemView.newChildId(), ButtonPage.class, "Buttons"));
		navItemView.add(new NavItemBookmarkablePageLink<Void>(navItemView.newChildId(), FormPage.class, "Forms"));
		navItemView.add(new NavItemBookmarkablePageLink<Void>(navItemView.newChildId(), IconPage.class, "Icons"));
		navItemView.add(new NavItemBookmarkablePageLink<Void>(navItemView.newChildId(), FeedbackPage.class, "Feedback"));

	}

}
