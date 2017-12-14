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
package net.dontdrinkandroot.wicket.extras.page;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ModalRequestBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.Navbar;
import net.dontdrinkandroot.wicket.bootstrap.page.BootstrapPage;
import net.dontdrinkandroot.wicket.model.ConcatenatingStringModel;
import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.Strings;

public abstract class StandardBootstrapPage<T> extends BootstrapPage<T>
{
    public static final String MODAL_ID = "modal";

    private FeedbackPanel feedbackPanel;

    private Label pageHeading;

    private IModel<String> pageHeadingModel;

    public StandardBootstrapPage()
    {
        super();
    }

    public StandardBootstrapPage(PageParameters parameters)
    {
        super(parameters);
    }

    public StandardBootstrapPage(IModel<T> model)
    {
        super(model);
    }

    @Override
    protected void onInitialize()
    {
        this.pageHeadingModel = this.createPageHeadingModel();

        super.onInitialize();

        this.add(this.createModal(StandardBootstrapPage.MODAL_ID));

        Component navBar = this.createNavbar("navbar");
        this.add(navBar);

        this.pageHeading = new Label("pageHeading", this.pageHeadingModel);

        final RepeatingView primaryActionView = new RepeatingView("primaryAction");
        this.populatePrimaryActions(primaryActionView);

        WebMarkupContainer pageHeader = new WebMarkupContainer("pageHeader")
        {
            @Override
            protected void onConfigure()
            {
                super.onConfigure();

                boolean hasHeading = (null != StandardBootstrapPage.this.pageHeadingModel)
                        && !Strings.isEmpty(StandardBootstrapPage.this.pageHeadingModel.getObject());
                boolean hasPrimaryActions = primaryActionView.size() > 0;
                this.setVisible(hasHeading || hasPrimaryActions);
            }
        };
        this.add(pageHeader);
        pageHeader.add(this.pageHeading);
        pageHeader.add(primaryActionView);

        this.feedbackPanel = this.createFeedbackPanel("feedback");
        this.feedbackPanel.setOutputMarkupId(true);
        this.add(this.feedbackPanel);

        this.add(this.createFooter("footer"));

        this.add(new ModalRequestBehavior(MODAL_ID));
    }

    @Override
    protected Component createPageTitle(String id)
    {
        return new Label(id, this.createPageTitleModel());
    }

    private Component createModal(String id)
    {
        WebMarkupContainer modalContainer = new WebMarkupContainer(id);
        modalContainer.setOutputMarkupId(true);

        return modalContainer;
    }

    protected FeedbackPanel createFeedbackPanel(String id)
    {
        return new FencedFeedbackPanel(id);
    }

    protected void populatePrimaryActions(RepeatingView primaryActionView)
    {
        /* Overwrite in order to add primary actions */
    }

    protected Component createNavbar(String id)
    {
        return new Navbar(id);
    }

    protected Component createFooter(String id)
    {
        return new WebMarkupContainer(id).setVisible(false);
    }

    public FeedbackPanel getFeedbackPanel()
    {
        return this.feedbackPanel;
    }

    public Label getPageHeading()
    {
        return this.pageHeading;
    }

    protected IModel<String> createPageTitlePrefixModel()
    {
        return new Model<>();
    }

    protected IModel<String> createPageTitleModel()
    {
        return new ConcatenatingStringModel(this.createPageTitlePrefixModel(), " - ", this.pageHeadingModel);
    }

    protected abstract IModel<String> createPageHeadingModel();
}
