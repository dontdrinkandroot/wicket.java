package net.dontdrinkandroot.wicket.model.date;

import java.util.Calendar;
import java.util.Date;

import org.apache.wicket.model.IModel;


public class DateSecondModel extends AbstractDateCalendarModel<Integer> {

	public DateSecondModel(IModel<Date> parent) {

		super(parent);
	}


	@Override
	protected Integer getFromCalendar(Calendar calendar) {

		return calendar.get(Calendar.SECOND);
	}


	@Override
	protected void setToCalendar(Integer object, Calendar calendar) {

		calendar.set(Calendar.SECOND, object);
	}

}
