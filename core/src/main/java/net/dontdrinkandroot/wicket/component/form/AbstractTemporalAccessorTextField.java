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
package net.dontdrinkandroot.wicket.component.form;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.form.TextField;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.convert.IConverter;
import org.apache.wicket.util.value.IValueMap;

import java.io.Serializable;
import java.time.temporal.TemporalAccessor;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class AbstractTemporalAccessorTextField<T extends TemporalAccessor & Serializable> extends TextField<T>
{
    private IModel<T> minModel = new Model<>();

    private IModel<T> maxModel = new Model<>();

    public AbstractTemporalAccessorTextField(String id, Class<T> type)
    {
        super(id, type);
    }

    public AbstractTemporalAccessorTextField(String id, IModel<T> model, Class<T> type)
    {
        super(id, model, type);
    }

    public void setMin(T min)
    {
        this.minModel.setObject(min);
    }

    public void setMax(T max)
    {
        this.maxModel.setObject(max);
    }

    public void setMinModel(IModel<T> minModel)
    {
        this.minModel = minModel;
    }

    public void setMaxModel(IModel<T> maxModel)
    {
        this.maxModel = maxModel;
    }

    @Override
    protected void onComponentTag(ComponentTag tag)
    {
        super.onComponentTag(tag);

        IConverter<T> converter = this.getConverter(this.getType());
        IValueMap attributes = tag.getAttributes();
        final T min = this.minModel.getObject();
        if (min != null) {
            attributes.put("min", converter.convertToString(min, this.getLocale()));
        } else {
            attributes.remove("min");
        }

        final T max = this.maxModel.getObject();
        if (max != null) {
            attributes.put("max", converter.convertToString(max, this.getLocale()));
        } else {
            attributes.remove("max");
        }
    }
}
