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
package net.dontdrinkandroot.wicket.model.java.time.temporal;

import net.dontdrinkandroot.wicket.model.AbstractChainedModel;
import org.apache.wicket.model.IModel;

import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class DateTimeFormatterModel extends AbstractChainedModel<TemporalAccessor, String>
{
    // TODO: Maybe refactor this into an IComponentAssignedModel in order to use the locale of the attached component.

    private String pattern;

    private Locale locale;

    public DateTimeFormatterModel(IModel<? extends TemporalAccessor> parent)
    {
        super(parent);
    }

    public DateTimeFormatterModel(IModel<? extends TemporalAccessor> parent, String pattern)
    {
        super(parent);
        this.pattern = pattern;
    }

    public DateTimeFormatterModel(IModel<? extends TemporalAccessor> parent, String pattern, Locale locale)
    {
        super(parent);
        this.pattern = pattern;
        this.locale = locale;
    }

    @Override
    public String getObject()
    {
        if ((null == this.getParent()) || (null == this.getParentObject())) {
            return "n/a";
        }

        if (null == this.pattern) {
            return this.getParentObject().toString();
        }

        DateTimeFormatter dateTimeFormatter;
        if (null == this.locale) {
            dateTimeFormatter = DateTimeFormatter.ofPattern(this.pattern);
        } else {
            dateTimeFormatter = DateTimeFormatter.ofPattern(this.pattern, this.locale);
        }

        return dateTimeFormatter.format(this.getParentObject());
    }
}
