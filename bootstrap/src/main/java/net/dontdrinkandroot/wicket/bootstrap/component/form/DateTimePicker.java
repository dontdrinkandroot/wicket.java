/**
 * Copyright (C) 2012, 2013 Philip W. Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.dontdrinkandroot.wicket.bootstrap.component.form;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

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
import org.apache.wicket.markup.html.form.FormComponentPanel;
import org.apache.wicket.model.IModel;


public class DateTimePicker extends FormComponentPanel<Date> {

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
						new IntegerRangeListModel(minYear, maxYear),
						Integer.class) {

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
						new ShortMonthChoiceRenderer(this.getLocale()),
						Integer.class) {

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
						this.getModel()), Integer.class) {

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
						new IntegerRangeListModel(0, 23),
						Integer.class) {

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
						new IntegerRangeListModel(0, 59),
						Integer.class) {

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
						new IntegerRangeListModel(0, 59),
						Integer.class) {

					@Override
					protected void onSelectionChanged(AjaxRequestTarget target) {

						DateTimePicker.this.onSecondChanged(target);
						DateTimePicker.this.onDateTimeChanged(target);
					}
				};
		this.add(this.secondChoice);
	}


	@Override
	protected void convertInput() {

		GregorianCalendar calendar = new GregorianCalendar();

		calendar.set(Calendar.YEAR, this.yearChoice.getConvertedInput());
		calendar.set(Calendar.MONTH, this.monthChoice.getConvertedInput());
		calendar.set(Calendar.DAY_OF_MONTH, this.dayChoice.getConvertedInput());
		calendar.set(Calendar.HOUR_OF_DAY, this.hourChoice.getConvertedInput());
		calendar.set(Calendar.MINUTE, this.minuteChoice.getConvertedInput());
		calendar.set(Calendar.SECOND, this.secondChoice.getConvertedInput());

		this.setConvertedInput(calendar.getTime());
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
