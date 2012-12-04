package net.dontdrinkandroot.wicket.bootstrap.component.nav;

import org.apache.wicket.Component;
import org.apache.wicket.Page;
import org.apache.wicket.markup.html.link.BookmarkablePageLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class NavItemBookmarkablePageLink<T> extends AbstractNavItemLink<T> {

	private BookmarkablePageLink<T> link;

	private final Class<? extends Page> pageClass;

	private PageParameters parameters;


	public <C extends Page> NavItemBookmarkablePageLink(String id, Class<C> pageClass, IModel<String> labelModel) {

		super(id, labelModel);

		this.pageClass = pageClass;
	}


	public <C extends Page> NavItemBookmarkablePageLink(
			String id,
			Class<C> pageClass,
			String string,
			PageParameters parameters) {

		this(id, pageClass, string);

		this.parameters = parameters;
	}


	public <C extends Page> NavItemBookmarkablePageLink(String id, Class<C> pageClass, String label) {

		super(id, new Model<String>(label));

		this.pageClass = pageClass;
	}


	@Override
	protected boolean isActive() {

		return this.getPage().getClass().isAssignableFrom(this.link.getPageClass());
	}


	@Override
	protected Component createLink(String id) {

		if (this.parameters == null) {
			this.link = new BookmarkablePageLink<T>(id, this.pageClass);
		} else {
			this.link = new BookmarkablePageLink<T>(id, this.pageClass, this.parameters);
		}
		this.link.setBody(this.labelModel);

		return this.link;
	}
}
