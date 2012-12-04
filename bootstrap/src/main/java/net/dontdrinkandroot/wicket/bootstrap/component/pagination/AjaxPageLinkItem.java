package net.dontdrinkandroot.wicket.bootstrap.component.pagination;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.navigation.paging.IPageable;


public class AjaxPageLinkItem extends PageLinkItem {

	public AjaxPageLinkItem(String id, IPageable pageable, long page) {

		super(id, pageable, page);
	}


	@Override
	protected AbstractLink createLink(String id) {

		return new AbstractAjaxPageLink(id) {

			@Override
			public void onClick(AjaxRequestTarget target) {

				AjaxPageLinkItem.this.setPage();
				AjaxPageLinkItem.this.onPageChanged(target);
			}

		};
	}


	protected void onPageChanged(AjaxRequestTarget target) {

	}

}
