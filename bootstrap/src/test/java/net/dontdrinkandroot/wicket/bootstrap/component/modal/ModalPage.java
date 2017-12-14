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
package net.dontdrinkandroot.wicket.bootstrap.component.modal;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ModalRequestBehavior;
import net.dontdrinkandroot.wicket.bootstrap.event.CreateAndOpenModalRequest;
import net.dontdrinkandroot.wicket.bootstrap.event.OpenModalRequest;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.WebPage;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ModalPage extends WebPage
{
    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        WebMarkupContainer modalContainer = new WebMarkupContainer("modal");
        modalContainer.setOutputMarkupId(true);
        this.add(modalContainer);
        this.add(new ModalRequestBehavior("modal"));

        AjaxLink<Void> openModalLink = new AjaxLink<Void>("openModalLink")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                this.send(this.getPage(), Broadcast.EXACT, new OpenModalRequest(target, new SimpleModal("modal")));
            }
        };
        this.add(openModalLink);

        AjaxLink<Void> createAndOpenModalLink = new AjaxLink<Void>("createAndOpenModalLink")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                this.send(
                        this.getPage(),
                        Broadcast.EXACT,
                        new CreateAndOpenModalRequest<>(target, SimpleModal.class)
                );
            }
        };
        this.add(createAndOpenModalLink);
    }
}
