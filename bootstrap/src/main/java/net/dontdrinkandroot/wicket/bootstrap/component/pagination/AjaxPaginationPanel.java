package net.dontdrinkandroot.wicket.bootstrap.component.pagination;

import net.dontdrinkandroot.wicket.bootstrap.css.PaginationSize;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.navigation.paging.IPageable;


public class AjaxPaginationPanel extends PaginationPanel {

	public AjaxPaginationPanel(String id, IPageable pageable) {

		super(id, pageable);
		this.setOutputMarkupId(true);
	}


	public AjaxPaginationPanel(String id, IPageable pageable, PaginationSize size) {

		super(id, pageable, size);
		this.setOutputMarkupId(true);
	}


	@Override
	protected Component createFirstPageItem(String id) {

		return new AjaxFirstPageLinkItem(id, this.getPageable()) {

			@Override
			protected void onPageChanged(AjaxRequestTarget target) {

				super.onPageChanged(target);
				AjaxPaginationPanel.this.onPageChanged(target);
			}
		};
	}


	@Override
	protected Component createNextPageItem(String id) {

		return new AjaxNextPageLinkItem(id, this.getPageable()) {

			@Override
			protected void onPageChanged(AjaxRequestTarget target) {

				super.onPageChanged(target);
				AjaxPaginationPanel.this.onPageChanged(target);
			}
		};
	}


	@Override
	protected Component createPrevPageItem(String id) {

		return new AjaxPrevPageLinkItem(id, this.getPageable()) {

			@Override
			protected void onPageChanged(AjaxRequestTarget target) {

				super.onPageChanged(target);
				AjaxPaginationPanel.this.onPageChanged(target);
			}
		};
	}


	@Override
	protected Component createLastPageItem(String id) {

		return new AjaxLastPageLinkItem(id, this.getPageable()) {

			@Override
			protected void onPageChanged(AjaxRequestTarget target) {

				super.onPageChanged(target);
				AjaxPaginationPanel.this.onPageChanged(target);
			}
		};
	}


	@Override
	protected Component createPageItem(String id, long page) {

		return new AjaxPageLinkItem(id, this.getPageable(), page) {

			@Override
			protected void onPageChanged(AjaxRequestTarget target) {

				super.onPageChanged(target);
				AjaxPaginationPanel.this.onPageChanged(target);
			}
		};
	}


	protected void onPageChanged(AjaxRequestTarget target) {

		if (this.getPageable() instanceof Component) {
			target.add((Component) this.getPageable());
		}

		target.add(this);
	}

}
