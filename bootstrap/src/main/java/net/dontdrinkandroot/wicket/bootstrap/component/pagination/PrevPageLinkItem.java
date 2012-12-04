package net.dontdrinkandroot.wicket.bootstrap.component.pagination;

import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class PrevPageLinkItem extends AbstractPageLinkItem {

	public PrevPageLinkItem(String id, IPageable pageable) {

		super(id, pageable);
	}


	@Override
	protected IModel<String> createLabel() {

		return new Model<String>("<");
	}


	@Override
	protected AbstractLink createLink(String id) {

		return new AbstractPageLink(id) {

			@Override
			public void onClick() {

				PrevPageLinkItem.this.setPage();
			}
		};
	}


	@Override
	public boolean isEnabled() {

		return this.getPageable().getCurrentPage() != 0;
	}


	@Override
	protected void setPage() {

		this.getPageable().setCurrentPage(Math.max(0, this.getPageable().getCurrentPage() - 1));
	};

}
