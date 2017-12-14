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
package net.dontdrinkandroot.wicket.bootstrap.component.item;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.model.IModel;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class AjaxLinkItem<T> extends AbstractLinkItem<T, AjaxLink<T>>
{
    public AjaxLinkItem(String id, IModel<String> labelModel)
    {
        super(id, labelModel);
    }

    @Override
    protected AjaxLink<T> createLink(String id)
    {
        return new AjaxLink<T>(id, this.getModel())
        {
            @Override
            public void onClick(AjaxRequestTarget target)
            {
                AjaxLinkItem.this.onClick(target);
            }
        };
    }

    protected abstract void onClick(AjaxRequestTarget target);
}
