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
package net.dontdrinkandroot.wicket.model.java.time.temporal;

import net.dontdrinkandroot.wicket.model.AbstractChainedModel;
import org.apache.wicket.Component;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IComponentAssignedModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.IWrapModel;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class DateTimeFormatterModel extends AbstractChainedModel<TemporalAccessor, String> implements IComponentAssignedModel<String>
{
    private String pattern;

    private ZoneId zoneId;

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

    public DateTimeFormatterModel(IModel<? extends TemporalAccessor> parent, String pattern, ZoneId zoneId)
    {
        super(parent);

        this.pattern = pattern;
        this.zoneId = zoneId;
    }

    @Override
    public String getObject()
    {
        return this.getObject(this.locale);
    }

    private String getObject(Locale locale)
    {
        if ((null == this.getParent()) || (null == this.getParentObject())) {
            return null;
        }

        if (null == this.pattern) {
            return this.getParentObject().toString();
        }

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(this.pattern);

        if (null != locale) {
            dateTimeFormatter = dateTimeFormatter.withLocale(locale);
        }

        if (null != this.zoneId) {
            dateTimeFormatter = dateTimeFormatter.withZone(this.zoneId);
        }

        return dateTimeFormatter.format(this.getParentObject());
    }

    @Override
    public IWrapModel<String> wrapOnAssignment(Component component)
    {
        return new AssignmentWrapper(component);
    }

    public DateTimeFormatterModel setLocale(Locale locale)
    {
        this.locale = locale;
        return this;
    }

    private class AssignmentWrapper extends AbstractReadOnlyModel<String> implements IWrapModel<String>
    {
        private Component component;

        public AssignmentWrapper(Component component)
        {
            this.component = component;
        }

        @Override
        public String getObject()
        {
            return DateTimeFormatterModel.this.getObject(this.component.getLocale());
        }

        @Override
        public IModel<?> getWrappedModel()
        {
            return DateTimeFormatterModel.this;
        }

        @Override
        public void detach()
        {
            super.detach();
            DateTimeFormatterModel.this.detach();
        }
    }
}
