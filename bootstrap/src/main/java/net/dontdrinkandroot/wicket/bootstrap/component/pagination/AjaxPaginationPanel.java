/**
 * Copyright (C) 2012, 2013 Philip W. Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
