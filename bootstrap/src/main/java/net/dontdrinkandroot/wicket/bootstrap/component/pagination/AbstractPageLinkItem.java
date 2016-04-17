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
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.behavior.DisabledCssBehavior;


public abstract class AbstractPageLinkItem extends Panel
{

	private final IPageable pageable;

	private AbstractLink link;


	public AbstractPageLinkItem(String id, IPageable pageable)
	{
		super(id);
		this.pageable = pageable;

		this.link = this.createLink("link");
		this.link.setBody(this.createLabel());
		this.add(this.link);

		this.add(new DisabledCssBehavior());
	}

	public IPageable getPageable()
	{
		return this.pageable;
	}

	public void setLabel(IModel<String> label)
	{
		this.link.setBody(label);
	}

	public AbstractLink getLink()
	{
		return this.link;
	}

	protected abstract void setPage();

	protected abstract IModel<String> createLabel();

	protected abstract AbstractLink createLink(String id);

}
