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
package net.dontdrinkandroot.wicket.bootstrap.component.panel;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.component.basic.Heading;
import net.dontdrinkandroot.wicket.component.basic.Heading.Level;


public class SimplePanel<T> extends Panel<T>
{

	private final IModel<String> headingModel;

	private final Level headingLevel;


	public SimplePanel(String id, IModel<String> headingModel, Heading.Level headingLevel)
	{
		super(id);

		this.headingModel = headingModel;
		this.headingLevel = headingLevel;
	}

	public SimplePanel(String id, IModel<T> model, IModel<String> headingModel, Heading.Level headingLevel)
	{
		super(id, model);

		this.headingModel = headingModel;
		this.headingLevel = headingLevel;
	}

	@Override
	protected Component createFooterComponent(String id)
	{
		final WebMarkupContainer footerContainer = new WebMarkupContainer(id);
		footerContainer.setVisible(false);

		return footerContainer;
	}

	@Override
	protected Component createAfterBodyComponent(String id)
	{
		final WebMarkupContainer afterBodyContainer = new WebMarkupContainer(id);
		afterBodyContainer.setVisible(false);

		return afterBodyContainer;
	}

	@Override
	protected Component createHeadingComponent(String id)
	{
		return new PanelHeading(id, this.headingModel, this.headingLevel);
	}

}
