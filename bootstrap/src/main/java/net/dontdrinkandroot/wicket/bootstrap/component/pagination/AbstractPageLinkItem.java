package net.dontdrinkandroot.wicket.bootstrap.component.pagination;

import net.dontdrinkandroot.wicket.bootstrap.behavior.DisabledCssBehavior;

import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;


public abstract class AbstractPageLinkItem extends Panel {

	private final IPageable pageable;


	public AbstractPageLinkItem(String id, IPageable pageable) {

		super(id);
		this.pageable = pageable;

		AbstractLink link = this.createLink("link");
		link.setBody(this.createLabel());
		this.add(link);

		this.add(new DisabledCssBehavior());
	}


	public IPageable getPageable() {

		return this.pageable;
	}


	protected abstract void setPage();


	protected abstract IModel<String> createLabel();


	protected abstract AbstractLink createLink(String id);

}
