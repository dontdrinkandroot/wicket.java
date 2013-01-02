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
			for (int i = 0; i <= calendar.getActualMaximum(Calendar.DAY_OF_MONTH); i++) {
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
