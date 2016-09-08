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
package net.dontdrinkandroot.wicket.model.date;

import org.apache.wicket.model.IModel;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public abstract class AbstractDateCalendarModel<T> implements IModel<T> {

    private GregorianCalendar calendar;

    private final IModel<Date> dateModel;

    public AbstractDateCalendarModel(IModel<Date> dateModel)
    {

        this.dateModel = dateModel;
        this.calendar = new GregorianCalendar();
    }

    @Override
    public T getObject()
    {

        if (this.calendar == null) {
            this.calendar = new GregorianCalendar();
        }
        this.calendar.setTime(this.getDate());
        return this.getFromCalendar(this.calendar);
    }

    @Override
    public void setObject(T object)
    {

        if (this.calendar == null) {
            this.calendar = new GregorianCalendar();
        }
        this.setToCalendar(object, this.calendar);
        this.setDate(this.calendar.getTime());
    }

    @Override
    public void detach()
    {

        this.calendar = null;
    }

    private Date getDate()
    {

        return this.dateModel.getObject();
    }

    private void setDate(Date date)
    {

        this.dateModel.setObject(date);
    }

    protected abstract void setToCalendar(T object, Calendar calendar);

    protected abstract T getFromCalendar(Calendar calendar);

}
