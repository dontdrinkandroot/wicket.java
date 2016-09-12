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
package net.dontdrinkandroot.wicket.extras.model.calendar;

import net.dontdrinkandroot.wicket.model.AbstractChainedModel;
import org.apache.wicket.model.IModel;

import java.text.DateFormatSymbols;
import java.util.Locale;

public class DayOfWeekShortNameModel extends AbstractChainedModel<Integer, String>
{
    private Locale locale;

    public DayOfWeekShortNameModel(IModel<? extends Integer> parent, Locale locale)
    {
        super(parent);
        this.locale = locale;
    }

    @Override
    public String getObject()
    {
        Integer dayOfWeek = this.getParentObject();
        if (null == dayOfWeek) {
            return null;
        }

        DateFormatSymbols symbols = new DateFormatSymbols(this.locale);
        String[] names = symbols.getShortWeekdays();

        return names[dayOfWeek];
    }
}
