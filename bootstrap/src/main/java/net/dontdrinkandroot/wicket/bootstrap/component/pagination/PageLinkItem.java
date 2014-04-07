/**
 * Copyright (C) 2012-2014 Philip W. Sorst <philip@sorst.net>
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

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class PageLinkItem extends AbstractPageLinkItem {

	private final long page;


	public PageLinkItem(String id, IPageable pageable, long page) {

		super(id, pageable);
		this.page = page;

		this.add(new CssClassAppender(new Model<BootstrapCssClass>(BootstrapCssClass.ACTIVE) {

			@Override
			public BootstrapCssClass getObject() {

				if (PageLinkItem.this.isCurrentPage()) {
					return super.getObject();
				}

				return null;
			}
		}));
	}


	@Override
	protected IModel<String> createLabel() {

		return new AbstractReadOnlyModel<String>() {

			@Override
			public String getObject() {

				return Long.toString(PageLinkItem.this.page + 1);
			}
		};
	}


	@Override
	protected AbstractLink createLink(String id) {

		return new AbstractPageLink(id) {

			@Override
			public void onClick() {

				PageLinkItem.this.setPage();
			}
		};
	}


	@Override
	protected void setPage() {

		this.getPageable().setCurrentPage(Math.max(0, Math.min(this.page, this.getPageable().getPageCount() - 1)));
	};


	protected boolean isCurrentPage() {

		return this.page == this.getPageable().getCurrentPage();
	}

}
