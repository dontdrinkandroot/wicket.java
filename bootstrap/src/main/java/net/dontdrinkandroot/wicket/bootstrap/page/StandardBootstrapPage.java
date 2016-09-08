/*
 * Copyright (C) 2012-2016 Philip Washington Sorst <philip@sorst.net>
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

import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FencedFeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.modal.Modal;
import net.dontdrinkandroot.wicket.bootstrap.component.navbar.NavBar;
import net.dontdrinkandroot.wicket.bootstrap.event.CreateAndOpenModalRequest;
import net.dontdrinkandroot.wicket.bootstrap.event.ModalRequest;
import net.dontdrinkandroot.wicket.bootstrap.event.OpenModalRequest;
import org.apache.wicket.Component;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.util.string.Strings;

import java.lang.reflect.InvocationTargetException;

public abstract class StandardBootstrapPage<T> extends BootstrapPage<T>
{

    public static final String MODAL_ID = "modal";

    private FeedbackPanel feedbackPanel;

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
        super.onInitialize();

        this.add(this.createModal(StandardBootstrapPage.MODAL_ID));

        Component navBar = this.createNavBar("navBar");
        this.add(navBar);

        Label pageHeading = new Label("pageHeading", this.pageHeadingModel);

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
        pageHeader.add(pageHeading);
        pageHeader.add(primaryActionView);

        this.feedbackPanel = this.createFeedbackPanel("feedback");
        this.feedbackPanel.setOutputMarkupId(true);
        this.add(this.feedbackPanel);

        this.add(this.createFooter("footer"));
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

    protected Component createNavBar(String id)
    {
        NavBar navBar = new NavBar(id)
        {
            @Override
            protected Component createBrand(String id)
            {
                return StandardBootstrapPage.this.createBrand(id);
            }

            @Override
            protected void populateNavbarLeftItems(RepeatingView navbarLeftItemView)
            {
                StandardBootstrapPage.this.populateNavbarLeftItems(navbarLeftItemView);
            }

            @Override
            protected Component createForm(String id)
            {
                return StandardBootstrapPage.this.createNavBarForm(id);
            }

            @Override
            protected void populateNavbarRightItems(RepeatingView navbarRightItemView)
            {
                StandardBootstrapPage.this.populateNavbarRightItems(navbarRightItemView);
            }
        };
        return navBar;
    }

    protected Component createBrand(String id)
    {
        WebMarkupContainer brandLink = new WebMarkupContainer(id);
        brandLink.setVisible(false);
        return brandLink;
    }

    protected void populateNavbarLeftItems(RepeatingView itemView)
    {
        /* Overwrite to populate navbar items on left side */
    }

    protected Component createNavBarForm(String id)
    {
        WebMarkupContainer navBarForm = new WebMarkupContainer(id);
        navBarForm.setVisible(false);

        return navBarForm;
    }

    protected void populateNavbarRightItems(RepeatingView itemView)
    {
        /* Overwrite to populate navbar items on right side */
    }

    protected Component createFooter(String id)
    {
        return new WebMarkupContainer(id).setVisible(false);
    }

    public FeedbackPanel getFeedbackPanel()
    {
        return this.feedbackPanel;
    }

    @Override
    public void onEvent(IEvent<?> event)
    {
        super.onEvent(event);

        if (event.getPayload() instanceof ModalRequest) {
            if (event.getPayload() instanceof OpenModalRequest) {
                OpenModalRequest openModalRequest = (OpenModalRequest) event.getPayload();
                AjaxRequestTarget target = openModalRequest.getTarget();
                Modal<?> modal = openModalRequest.getModal();
                if (!StandardBootstrapPage.MODAL_ID.equals(modal.getId())) {
                    throw new WicketRuntimeException("Unexpected Modal ID");
                }
                this.replace(modal);
                target.add(modal);
                target.appendJavaScript(modal.getShowScript());
            }
            if (event.getPayload() instanceof CreateAndOpenModalRequest<?>) {
                CreateAndOpenModalRequest<?> openModalRequest = (CreateAndOpenModalRequest<?>) event.getPayload();
                Class<? extends Modal<?>> modalClass = openModalRequest.getModalClass();
                IModel<?> model = openModalRequest.getModel();
                AjaxRequestTarget target = openModalRequest.getTarget();
                try {
                    Modal<?> modal;
                    if (null == model) {
                        modal = modalClass.getConstructor(String.class).newInstance(StandardBootstrapPage.MODAL_ID);
                    } else {
                        modal = modalClass.getConstructor(String.class, IModel.class).newInstance(
                                StandardBootstrapPage.MODAL_ID,
                                model
                        );
                    }
                    this.replace(modal);
                    target.add(modal);
                    target.appendJavaScript(modal.getShowScript());
                } catch (
                        InstantiationException
                                | IllegalAccessException
                                | IllegalArgumentException
                                | InvocationTargetException
                                | NoSuchMethodException
                                | SecurityException e
                        ) {
                    throw new WicketRuntimeException(e);
                }
            }
        }
    }
}
