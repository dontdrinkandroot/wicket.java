package net.dontdrinkandroot.wicket.model.calendar;

import java.util.Calendar;

import net.dontdrinkandroot.wicket.model.AbstractChainedModel;

import org.apache.wicket.model.IModel;


public class CalendarMonthModel extends AbstractChainedModel<Calendar, Integer> {

	public CalendarMonthModel(IModel<? extends Calendar> parent) {

		super(parent);
	}


	@Override
	public Integer getObject() {

		return this.getParentObject().get(Calendar.MONTH);
	}


	@Override
	public void setObject(Integer month) {

		int oldDay = this.getParentObject().get(Calendar.DAY_OF_MONTH);

		this.getParentObject().set(Calendar.DAY_OF_MONTH, 1);
		this.getParentObject().set(Calendar.MONTH, month.intValue());

		int maxDay = this.getParentObject().getActualMaximum(Calendar.DAY_OF_MONTH);

		this.getParentObject().set(Calendar.DAY_OF_MONTH, Math.min(oldDay, maxDay));
	}

}
