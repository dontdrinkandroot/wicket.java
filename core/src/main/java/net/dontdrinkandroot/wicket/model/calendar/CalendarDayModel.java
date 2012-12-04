package net.dontdrinkandroot.wicket.model.calendar;

import java.util.Calendar;

import net.dontdrinkandroot.wicket.model.AbstractChainedModel;

import org.apache.wicket.model.IModel;


public class CalendarDayModel extends AbstractChainedModel<Calendar, Integer> {

	public CalendarDayModel(IModel<? extends Calendar> parent) {

		super(parent);
	}


	@Override
	public Integer getObject() {

		return this.getParentObject().get(Calendar.DAY_OF_MONTH);
	}


	@Override
	public void setObject(Integer object) {

		this.getParentObject().set(Calendar.DAY_OF_MONTH, object.intValue());
	}

}
