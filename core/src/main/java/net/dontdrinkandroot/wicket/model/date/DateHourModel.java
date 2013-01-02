package net.dontdrinkandroot.wicket.model.date;

import java.util.Calendar;
import java.util.Date;

import org.apache.wicket.model.IModel;


public class DateHourModel extends AbstractDateCalendarModel<Integer> {

	public DateHourModel(IModel<Date> parent) {

		super(parent);
	}


	@Override
	protected Integer getFromCalendar(Calendar calendar) {

		return calendar.get(Calendar.HOUR_OF_DAY);
	}


	@Override
	protected void setToCalendar(Integer object, Calendar calendar) {

		calendar.set(Calendar.HOUR_OF_DAY, object);
	}

}
