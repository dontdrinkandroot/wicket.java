package net.dontdrinkandroot.wicketexample.web.page.bootstrap;

import net.dontdrinkandroot.wicket.bootstrap.component.item.BookmarkablePageLinkItem;
import net.dontdrinkandroot.wicketexample.web.page.DecoratorSidebarPage;

import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class AbstractBootstrapPage<T> extends DecoratorSidebarPage<T> {

	public AbstractBootstrapPage(PageParameters parameters) {

		super(parameters);
	}


	@Override
	protected void createNavItems(RepeatingView navItemView) {

		navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), ButtonPage.class, "Buttons"));
		navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), FormPage.class, "Forms"));
		navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), IconPage.class, "Icons"));
		navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), FeedbackPage.class, "Feedback"));
		navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), DropDownPage.class, "Drop Down"));
		navItemView.add(new BookmarkablePageLinkItem(navItemView.newChildId(), LabelBadgePage.class, "Labels & Badges"));
	}

}
