package net.dontdrinkandroot.wicket.model.date;

import java.util.Calendar;
import java.util.Date;

import org.apache.wicket.model.IModel;


public class DateDayModel extends AbstractDateCalendarModel<Integer> {

	public DateDayModel(IModel<Date> parent) {

		super(parent);
	}


	@Override
	protected Integer getFromCalendar(Calendar calendar) {

		return calendar.get(Calendar.DAY_OF_MONTH);
	}


	@Override
	protected void setToCalendar(Integer object, Calendar calendar) {

		calendar.set(Calendar.DAY_OF_MONTH, object);
	}

}
