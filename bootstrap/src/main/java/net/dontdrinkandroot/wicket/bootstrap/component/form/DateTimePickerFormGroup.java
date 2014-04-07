package net.dontdrinkandroot.wicket.bootstrap.component.form;

import java.util.Date;

import org.apache.wicket.model.IModel;


public class DateTimePickerFormGroup extends AbstractFormGroup<Date, DateTimePicker> {

	private final int maxYear;

	private final int minYear;


	public DateTimePickerFormGroup(String id, IModel<Date> model, String label, int minYear, int maxYear) {

		super(id, model, label);
		this.minYear = minYear;
		this.maxYear = maxYear;
		this.createComponents();
	}


	@Override
	protected DateTimePicker createFormComponent(String id) {

		return new DateTimePicker(id, this.getModel(), this.minYear, this.maxYear);
	}

}
