package net.dontdrinkandroot.wicket.model.date;

import java.util.Calendar;
import java.util.Date;

import org.apache.wicket.model.IModel;


public class DateMinuteModel extends AbstractDateCalendarModel<Integer> {

	public DateMinuteModel(IModel<Date> parent) {

		super(parent);
	}


	@Override
	protected Integer getFromCalendar(Calendar calendar) {

		return calendar.get(Calendar.MINUTE);
	}


	@Override
	protected void setToCalendar(Integer object, Calendar calendar) {

		calendar.set(Calendar.MINUTE, object);
	}

}
