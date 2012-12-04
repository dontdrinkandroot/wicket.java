package net.dontdrinkandroot.wicket.model.calendar;

import java.util.Calendar;

import net.dontdrinkandroot.wicket.model.AbstractChainedModel;

import org.apache.wicket.model.IModel;


public class CalendarMinuteModel extends AbstractChainedModel<Calendar, Integer> {

	public CalendarMinuteModel(IModel<? extends Calendar> parent) {

		super(parent);
	}


	@Override
	public Integer getObject() {

		return this.getParentObject().get(Calendar.MINUTE);
	}


	@Override
	public void setObject(Integer object) {

		this.getParentObject().set(Calendar.MINUTE, object.intValue());
	}

}
