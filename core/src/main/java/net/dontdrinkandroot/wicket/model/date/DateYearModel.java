package net.dontdrinkandroot.wicket.model.date;

import java.util.Calendar;
import java.util.Date;

import org.apache.wicket.model.IModel;


public class DateYearModel extends AbstractDateCalendarModel<Integer> {

	public DateYearModel(IModel<Date> parent) {

		super(parent);
	}


	@Override
	protected Integer getFromCalendar(Calendar calendar) {

		return calendar.get(Calendar.YEAR);
	}


	@Override
	protected void setToCalendar(Integer object, Calendar calendar) {

		calendar.set(Calendar.YEAR, object);
	}

}
