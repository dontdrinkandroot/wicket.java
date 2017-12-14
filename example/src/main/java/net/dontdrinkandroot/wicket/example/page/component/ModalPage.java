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
package net.dontdrinkandroot.wicket.example.page.component;

import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxButton;
import net.dontdrinkandroot.wicket.bootstrap.event.CreateAndOpenModalRequest;
import net.dontdrinkandroot.wicket.example.component.SimpleAjaxFormModal;
import net.dontdrinkandroot.wicket.example.component.SimpleFormModal;
import net.dontdrinkandroot.wicket.example.component.SimpleModal;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

public class ModalPage extends ComponentPage
{
    public ModalPage(PageParameters parameters)
    {
        super(parameters);
    }

    @Override
    protected IModel<String> createPageHeadingModel()
    {
        return Model.of("Modals");
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new AjaxButton<Void>("openStandardModalButton")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                this.send(this, Broadcast.BUBBLE, new CreateAndOpenModalRequest<>(target, SimpleModal.class));
            }
        }.setBody(Model.of("Standard Modal")));

        this.add(new AjaxButton<Void>("openFormModalButton")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                this.send(this, Broadcast.BUBBLE, new CreateAndOpenModalRequest<>(target, SimpleFormModal.class));
            }
        }.setBody(Model.of("Form Modal")));

        this.add(new AjaxButton<Void>("openAjaxFormModalButton")
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                this.send(this, Broadcast.BUBBLE, new CreateAndOpenModalRequest<>(target, SimpleAjaxFormModal.class));
            }
        }.setBody(Model.of("Ajax Form Modal")));
    }
}
