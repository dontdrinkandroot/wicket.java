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
package net.dontdrinkandroot.wicket.model;

import org.apache.wicket.model.IModel;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class AbstractChainedModel<P, T> implements ChainedModel<P, T>
{
    private final IModel<? extends P> parent;

    public AbstractChainedModel(final IModel<? extends P> parent)
    {
        this.parent = parent;
    }

    @Override
    public void detach()
    {
        if (null != this.parent) {
            this.parent.detach();
        }
    }

    public IModel<? extends P> getParent()
    {
        return this.parent;
    }

    public P getParentObject()
    {
        if (this.parent == null) {
            return null;
        }

        return this.parent.getObject();
    }

    @Override
    public void setObject(final T object)
    {
        throw new RuntimeException("Chained Model, cannot set Object, must override method in order to do so");
    }
}
