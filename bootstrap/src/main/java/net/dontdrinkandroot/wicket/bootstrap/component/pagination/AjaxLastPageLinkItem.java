package net.dontdrinkandroot.wicket.bootstrap.component.pagination;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.navigation.paging.IPageable;


public class AjaxLastPageLinkItem extends LastPageLinkItem {

	public AjaxLastPageLinkItem(String id, IPageable pageable) {

		super(id, pageable);
	}


	@Override
	protected AbstractLink createLink(String id) {

		return new AbstractAjaxPageLink(id) {

			@Override
			public void onClick(AjaxRequestTarget target) {

				AjaxLastPageLinkItem.this.setPage();
				AjaxLastPageLinkItem.this.onPageChanged(target);
			}
		};
	}


	protected void onPageChanged(AjaxRequestTarget target) {

	}

}
