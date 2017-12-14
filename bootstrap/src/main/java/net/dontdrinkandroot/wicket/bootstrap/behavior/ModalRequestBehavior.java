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
package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.bootstrap.component.modal.Modal;
import net.dontdrinkandroot.wicket.bootstrap.event.CreateAndOpenModalRequest;
import net.dontdrinkandroot.wicket.bootstrap.event.ModalRequest;
import net.dontdrinkandroot.wicket.bootstrap.event.OpenModalRequest;
import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.model.IModel;

import java.lang.reflect.InvocationTargetException;

/**
 * Handles {@link net.dontdrinkandroot.wicket.bootstrap.event.ModalRequest} Events.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ModalRequestBehavior extends Behavior
{
    private String targetId;

    public ModalRequestBehavior(String targetId)
    {
        super();
        this.targetId = targetId;
    }

    @Override
    public void bind(Component component)
    {
        super.bind(component);
        if (!(component instanceof MarkupContainer)) {
            throw new WicketRuntimeException("Can only bind to a markup container");
        }
    }

    @Override
    public void onEvent(Component component, IEvent<?> event)
    {
        super.onEvent(component, event);

        if (event.getPayload() instanceof ModalRequest) {
            ModalRequest modalRequest = (ModalRequest) event.getPayload();
            Modal<?> modal = this.extractModal(modalRequest);
            AjaxRequestTarget target = modalRequest.getTarget();
            ((MarkupContainer) component).replace(modal);
            target.add(modal);
            target.appendJavaScript(modal.getShowScript());
        }
    }

    private Modal<?> extractModal(ModalRequest modalRequest)
    {
        if (modalRequest instanceof OpenModalRequest) {
            OpenModalRequest openModalRequest = (OpenModalRequest) modalRequest;
            return this.createModal(openModalRequest);
        }

        if (modalRequest instanceof CreateAndOpenModalRequest<?>) {
            CreateAndOpenModalRequest<?> openModalRequest = (CreateAndOpenModalRequest<?>) modalRequest;
            return this.createModal(openModalRequest);
        }

        throw new WicketRuntimeException(String.format(
                "Unknown Modal Request: %s",
                modalRequest.getClass().getCanonicalName()
        ));
    }

    private Modal<?> createModal(OpenModalRequest openModalRequest)
    {
        Modal<?> modal = openModalRequest.getModal();
        if (!this.targetId.equals(modal.getId())) {
            throw new WicketRuntimeException("Unexpected Modal ID");
        }

        return modal;
    }

    private Modal<?> createModal(CreateAndOpenModalRequest<?> openModalRequest)
    {
        Class<? extends Modal<?>> modalClass = openModalRequest.getModalClass();
        IModel<?> model = openModalRequest.getModel();
        try {
            if (null == model) {
                return modalClass.getConstructor(String.class).newInstance(this.targetId);
            } else {
                return modalClass.getConstructor(String.class, IModel.class).newInstance(
                        this.targetId,
                        model
                );
            }
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
