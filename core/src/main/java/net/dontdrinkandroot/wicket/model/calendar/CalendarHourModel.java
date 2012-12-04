package net.dontdrinkandroot.wicket.model.calendar;

import java.util.Calendar;

import net.dontdrinkandroot.wicket.model.AbstractChainedModel;

import org.apache.wicket.model.IModel;


public class CalendarHourModel extends AbstractChainedModel<Calendar, Integer> {

	public CalendarHourModel(IModel<? extends Calendar> parent) {

		super(parent);
	}


	@Override
	public Integer getObject() {

		return this.getParentObject().get(Calendar.HOUR_OF_DAY);
	}


	@Override
	public void setObject(Integer object) {

		this.getParentObject().set(Calendar.HOUR_OF_DAY, object.intValue());
	}

}
