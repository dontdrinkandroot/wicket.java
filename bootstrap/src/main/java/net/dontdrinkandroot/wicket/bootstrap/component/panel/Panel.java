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
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.PanelStyle;


public abstract class Panel<T> extends GenericPanel<T>
{

	public static final String BODY_ID = "body";

	public static final String HEADING_ID = "heading";

	public static final String FOOTER_ID = "footer";

	public static final String AFTER_BODY_ID = "afterBody";

	private final IModel<PanelStyle> styleModel = Model.of(PanelStyle.DEFAULT);

	protected Component heading;

	protected Component footer;

	protected Component afterBody;


	public Panel(final String id)
	{
		this(id, null);
	}

	public Panel(final String id, final IModel<T> model)
	{
		super(id, model);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.PANEL));
		this.add(new CssClassAppender(this.styleModel));

		this.heading = this.createHeading(Panel.HEADING_ID);
		this.heading.add(new CssClassAppender(BootstrapCssClass.PANEL_HEADING));
		this.add(this.heading);

		this.afterBody = this.createAfterBody(Panel.AFTER_BODY_ID);
		this.add(this.afterBody);

		this.footer = this.createFooter(Panel.FOOTER_ID);
		this.footer.add(new CssClassAppender(BootstrapCssClass.PANEL_FOOTER));
		this.add(this.footer);
	}

	public Panel<T> setPanelStyle(PanelStyle style)
	{
		this.styleModel.setObject(style);
		return this;
	}

	public PanelStyle getPanelStyle()
	{
		return this.styleModel.getObject();
	}

	protected Component createHeading(String id)
	{
		final WebMarkupContainer headingContainer = new WebMarkupContainer(id);
		headingContainer.setVisible(false);

		return headingContainer;
	}

	protected Component createAfterBody(String id)
	{
		final WebMarkupContainer afterBodyContainer = new WebMarkupContainer(id);
		afterBodyContainer.setVisible(false);

		return afterBodyContainer;
	}

	protected Component createFooter(String id)
	{
		final WebMarkupContainer footerContainer = new WebMarkupContainer(id);
		footerContainer.setVisible(false);

		return footerContainer;
	}
}
