package net.dontdrinkandroot.wicket.bootstrap.component.form;

import java.util.Date;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.component.button.DropDownChoiceButton;
import net.dontdrinkandroot.wicket.choicerenderer.ShortMonthChoiceRenderer;
import net.dontdrinkandroot.wicket.css.CoreCssClass;
import net.dontdrinkandroot.wicket.model.IntegerRangeListModel;
import net.dontdrinkandroot.wicket.model.date.DateAvailableDaysModel;
import net.dontdrinkandroot.wicket.model.date.DateDayModel;
import net.dontdrinkandroot.wicket.model.date.DateHourModel;
import net.dontdrinkandroot.wicket.model.date.DateMinuteModel;
import net.dontdrinkandroot.wicket.model.date.DateMonthModel;
import net.dontdrinkandroot.wicket.model.date.DateSecondModel;
import net.dontdrinkandroot.wicket.model.date.DateYearModel;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;


public class DateTimePicker extends GenericPanel<Date> {

	private final DropDownChoiceButton<Integer> yearChoice;

	private final DropDownChoiceButton<Integer> monthChoice;

	private final DropDownChoiceButton<Integer> dayChoice;

	private final DropDownChoiceButton<Integer> hourChoice;

	private final DropDownChoiceButton<Integer> minuteChoice;

	private final DropDownChoiceButton<Integer> secondChoice;


	public DateTimePicker(String id, final IModel<Date> model, int minYear, int maxYear) {

		super(id, model);

		this.add(new CssClassAppender(CoreCssClass.DATE_PICKER));

		this.yearChoice =
				new DropDownChoiceButton<Integer>(
						"year",
						new DateYearModel(this.getModel()),
						new IntegerRangeListModel(minYear, maxYear)) {

					@Override
					protected void onSelectionChanged(AjaxRequestTarget target) {

						DateTimePicker.this.onYearChanged(target);
						DateTimePicker.this.onDateTimeChanged(target);
					};
				};
		this.add(this.yearChoice);

		this.monthChoice =
				new DropDownChoiceButton<Integer>(
						"month",
						new DateMonthModel(this.getModel()),
						new IntegerRangeListModel(0, 11),
						new ShortMonthChoiceRenderer(this.getLocale())) {

					@Override
					protected void onSelectionChanged(AjaxRequestTarget target) {

						target.add(DateTimePicker.this.dayChoice);
						DateTimePicker.this.onMonthChanged(target);
						DateTimePicker.this.onDateTimeChanged(target);
					}
				};
		this.add(this.monthChoice);

		this.dayChoice =
				new DropDownChoiceButton<Integer>("day", new DateDayModel(this.getModel()), new DateAvailableDaysModel(
						this.getModel())) {

					@Override
					protected void onSelectionChanged(AjaxRequestTarget target) {

						DateTimePicker.this.onDayChanged(target);
						DateTimePicker.this.onDateTimeChanged(target);
					}
				};
		this.add(this.dayChoice);

		this.hourChoice =
				new DropDownChoiceButton<Integer>(
						"hour",
						new DateHourModel(this.getModel()),
						new IntegerRangeListModel(0, 23)) {

					@Override
					protected void onSelectionChanged(AjaxRequestTarget target) {

						DateTimePicker.this.onHourChanged(target);
						DateTimePicker.this.onDateTimeChanged(target);
					}
				};
		this.add(this.hourChoice);

		this.minuteChoice =
				new DropDownChoiceButton<Integer>(
						"minute",
						new DateMinuteModel(this.getModel()),
						new IntegerRangeListModel(0, 59)) {

					@Override
					protected void onSelectionChanged(AjaxRequestTarget target) {

						DateTimePicker.this.onMinuteChanged(target);
						DateTimePicker.this.onDateTimeChanged(target);
					}
				};
		this.add(this.minuteChoice);

		this.secondChoice =
				new DropDownChoiceButton<Integer>(
						"second",
						new DateSecondModel(this.getModel()),
						new IntegerRangeListModel(0, 59)) {

					@Override
					protected void onSelectionChanged(AjaxRequestTarget target) {

						DateTimePicker.this.onSecondChanged(target);
						DateTimePicker.this.onDateTimeChanged(target);
					}
				};
		this.add(this.secondChoice);
	}


	protected void onYearChanged(AjaxRequestTarget target) {

	}


	protected void onMonthChanged(AjaxRequestTarget target) {

	}


	protected void onDayChanged(AjaxRequestTarget target) {

	}


	protected void onHourChanged(AjaxRequestTarget target) {

	}


	protected void onMinuteChanged(AjaxRequestTarget target) {

	}


	protected void onSecondChanged(AjaxRequestTarget target) {

	}


	protected void onDateTimeChanged(AjaxRequestTarget target) {

	}
}
