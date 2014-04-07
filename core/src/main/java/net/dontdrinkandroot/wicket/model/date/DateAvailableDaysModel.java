/**
 * Copyright (C) 2012, 2013 Philip W. Sorst <philip@sorst.net>
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

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.wicket.model.IModel;


public class DateAvailableDaysModel extends AbstractDateCalendarModel<List<Integer>> {

	private Integer currentMonth;

	private List<Integer> list;


	public DateAvailableDaysModel(IModel<Date> parent) {

		super(parent);
	}


	@Override
	protected void setToCalendar(List<Integer> object, Calendar calendar) {

		/* Noop */
	}


	@Override
	protected List<Integer> getFromCalendar(Calendar calendar) {

		int calendarMonth = calendar.get(Calendar.MONTH);
		if (this.currentMonth == null) {
			this.currentMonth = calendarMonth;
		} else if (this.currentMonth.intValue() != calendarMonth) {
			this.currentMonth = calendarMonth;
			this.list = null;
		}

		if (this.list == null) {
			this.list = new ArrayList<Integer>();
			for (int i = 1; i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
				this.list.add(i);
			}
		}

		return this.list;
	}


	@Override
	public void detach() {

		super.detach();
		this.currentMonth = null;
		this.list = null;
	}
}
