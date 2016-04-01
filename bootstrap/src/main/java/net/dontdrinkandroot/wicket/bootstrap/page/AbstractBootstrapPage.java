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
package net.dontdrinkandroot.wicket.bootstrap.page;

import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.headeritem.BootstrapCssHeaderItem;
import net.dontdrinkandroot.wicket.bootstrap.headeritem.BootstrapJsHeaderItem;


public abstract class AbstractBootstrapPage<T> extends GenericWebPage<T>
{

	public AbstractBootstrapPage()
	{
		super();
	}

	public AbstractBootstrapPage(PageParameters parameters)
	{
		super(parameters);
	}

	public AbstractBootstrapPage(IModel<T> model)
	{
		super(model);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new Label("pageTitle", this.getPageTitleModel()));
	}

	@Override
	public void renderHead(IHeaderResponse response)
	{
		super.renderHead(response);

		if (this.includeBootstrapJavaScript()) {
			response.render(new BootstrapJsHeaderItem(false));
		}

		if (this.includeBoostrapCss()) {
			response.render(new BootstrapCssHeaderItem());
		}
	}

	protected boolean includeBootstrapJavaScript()
	{
		return true;
	}

	protected boolean includeBoostrapCss()
	{
		return true;
	}

	protected abstract IModel<String> getPageTitleModel();

}
