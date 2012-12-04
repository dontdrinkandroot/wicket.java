package net.dontdrinkandroot.wicketexample.web.page.javascript;

import net.dontdrinkandroot.wicket.bootstrap.component.nav.NavItemBookmarkablePageLink;
import net.dontdrinkandroot.wicketexample.web.page.DecoratorSidebarPage;

import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class AbstractJavascriptPage<T> extends DecoratorSidebarPage<T> {

	public AbstractJavascriptPage(PageParameters parameters) {

		super(parameters);
	}


	@Override
	protected void createNavItems(RepeatingView navItemView) {

		navItemView.add(new NavItemBookmarkablePageLink<Void>(navItemView.newChildId(), CallbackPage.class, "Callback"));
		navItemView.add(new NavItemBookmarkablePageLink<Void>(
				navItemView.newChildId(),
				ScrollToBottomPage.class,
				"ScrollToBottom"));
		navItemView.add(new NavItemBookmarkablePageLink<Void>(
				navItemView.newChildId(),
				PopulatingScrollToBottomPage.class,
				"Populating ScrollToBottom"));
	}

}
