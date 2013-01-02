package net.dontdrinkandroot.wicket.model.date;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.wicket.model.IModel;


public abstract class AbstractDateCalendarModel<T> implements IModel<T> {

	private GregorianCalendar calendar;

	private final IModel<Date> dateModel;


	public AbstractDateCalendarModel(IModel<Date> dateModel) {

		this.dateModel = dateModel;
		this.calendar = new GregorianCalendar();
	}


	@Override
	public T getObject() {

		if (this.calendar == null) {
			this.calendar = new GregorianCalendar();
		}
		this.calendar.setTime(this.getDate());
		return this.getFromCalendar(this.calendar);
	}


	@Override
	public void setObject(T object) {

		if (this.calendar == null) {
			this.calendar = new GregorianCalendar();
		}
		this.setToCalendar(object, this.calendar);
		this.setDate(this.calendar.getTime());
	}


	@Override
	public void detach() {

		this.calendar = null;
	}


	private Date getDate() {

		return this.dateModel.getObject();
	}


	private void setDate(Date date) {

		this.dateModel.setObject(date);
	}


	protected abstract void setToCalendar(T object, Calendar calendar);


	protected abstract T getFromCalendar(Calendar calendar);

}
