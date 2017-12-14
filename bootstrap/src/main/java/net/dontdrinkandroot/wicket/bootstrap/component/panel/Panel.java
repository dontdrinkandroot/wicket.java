/*
 * Copyright (C) 2012-2017 Philip Washington Sorst <philip@sorst.net>
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

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.behavior.PanelBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.PanelStyle;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @param <T> Type of the Model Object.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class Panel<T> extends GenericPanel<T>
{
    public static final String BODY_ID = "body";

    public static final String HEADING_ID = "heading";

    public static final String FOOTER_ID = "footer";

    public static final String AFTER_BODY_ID = "afterBody";

    private PanelBehavior panelBehavior = new PanelBehavior(this.createStyleModel());

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
        this.add(this.panelBehavior);

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
        this.panelBehavior.setStyle(style);
        return this;
    }

    public PanelStyle getPanelStyle()
    {
        return this.panelBehavior.getStyle();
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

    protected IModel<PanelStyle> createStyleModel()
    {
        return Model.of(PanelStyle.DEFAULT);
    }
}
