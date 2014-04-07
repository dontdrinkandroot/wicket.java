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

import org.apache.wicket.markup.html.link.AbstractLink;
import org.apache.wicket.markup.html.navigation.paging.IPageable;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class FirstPageLinkItem extends AbstractPageLinkItem {

	public FirstPageLinkItem(String id, IPageable pageable) {

		super(id, pageable);
	}


	@Override
	protected IModel<String> createLabel() {

		return new Model<String>("<<");
	}


	@Override
	protected AbstractLink createLink(String id) {

		return new AbstractPageLink(id) {

			@Override
			public void onClick() {

				FirstPageLinkItem.this.setPage();
			}
		};
	}


	@Override
	public boolean isEnabled() {

		return this.getPageable().getCurrentPage() != 0;
	}


	@Override
	protected void setPage() {

		this.getPageable().setCurrentPage(0);
	};

}
