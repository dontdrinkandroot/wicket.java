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
package net.dontdrinkandroot.wicket.bootstrap.event;

import net.dontdrinkandroot.wicket.bootstrap.component.modal.Modal;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

/**
 * @param <T> Type of the modal model object.
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class CreateAndOpenModalRequest<T> extends ModalRequest
{
    private IModel<T> model;

    private Class<? extends Modal<?>> modalClass;

    public <C extends Modal<T>> CreateAndOpenModalRequest(AjaxRequestTarget target, Class<C> modalClass)
    {
        super(target);
        this.modalClass = modalClass;
    }

    public <C extends Modal<T>> CreateAndOpenModalRequest(
            AjaxRequestTarget target,
            Class<C> modalClass,
            IModel<T> model
    )
    {
        super(target);
        this.modalClass = modalClass;
        this.model = model;
    }

    public Class<? extends Modal<?>> getModalClass()
    {
        return this.modalClass;
    }

    public IModel<T> getModel()
    {
        return this.model;
    }
}
