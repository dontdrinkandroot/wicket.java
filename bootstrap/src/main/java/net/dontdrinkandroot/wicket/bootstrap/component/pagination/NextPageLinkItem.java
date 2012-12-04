package net.dontdrinkandroot.wicket.bootstrap.component.pagination;

import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class NextPageLinkItem extends AbstractPageLinkItem {

	public NextPageLinkItem(String id, IPageable pageable) {

		super(id, pageable);
	}


	@Override
	protected IModel<String> createLabel() {

		return new Model<String>(">");
	}


	@Override
	protected AbstractLink createLink(String id) {

		return new AbstractPageLink(id) {

			@Override
			public void onClick() {

				NextPageLinkItem.this.setPage();
			}
		};
	}


	@Override
	public boolean isEnabled() {

		return this.getPageable().getPageCount() != 0
				&& this.getPageable().getCurrentPage() != this.getPageable().getPageCount() - 1;
	}


	@Override
	protected void setPage() {

		this.getPageable().setCurrentPage(
				Math.min(this.getPageable().getPageCount() - 1, this.getPageable().getCurrentPage() + 1));
	};

}
