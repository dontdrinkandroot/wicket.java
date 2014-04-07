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
package net.dontdrinkandroot.wicket.component.form;

import java.util.Calendar;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.choicerenderer.ShortMonthChoiceRenderer;
import net.dontdrinkandroot.wicket.css.CoreCssClass;
import net.dontdrinkandroot.wicket.model.IntegerRangeListModel;
import net.dontdrinkandroot.wicket.model.calendar.CalendarDayModel;
import net.dontdrinkandroot.wicket.model.calendar.CalendarHourModel;
import net.dontdrinkandroot.wicket.model.calendar.CalendarMinuteModel;
import net.dontdrinkandroot.wicket.model.calendar.CalendarMonthModel;
import net.dontdrinkandroot.wicket.model.calendar.CalendarSecondModel;
import net.dontdrinkandroot.wicket.model.calendar.CalendarYearModel;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;


public class DateTimePicker extends GenericPanel<Calendar> {

	private final AjaxDropDownChoice<Integer> yearChoice;

	private final AjaxDropDownChoice<Integer> monthChoice;

	private final AjaxDropDownChoice<Integer> dayChoice;

	private final IntegerRangeListModel dayRangeModel;

	private final AjaxDropDownChoice<Integer> hourChoice;

	private final AjaxDropDownChoice<Integer> minuteChoice;

	private final AjaxDropDownChoice<Integer> secondChoice;


	public DateTimePicker(String id, IModel<Calendar> model, int minYear, int maxYear) {

		super(id, model);

		this.add(new CssClassAppender(CoreCssClass.DATE_PICKER));

		this.dayRangeModel =
				new IntegerRangeListModel(1, this.getModelObject().getActualMaximum(Calendar.DAY_OF_MONTH));

		this.yearChoice =
				new AjaxDropDownChoice<Integer>(
						"year",
						new CalendarYearModel(this.getModel()),
						new IntegerRangeListModel(minYear, maxYear)) {

					@Override
					protected void onSelectionChanged(AjaxRequestTarget target) {

						DateTimePicker.this.onYearChanged(target);
						DateTimePicker.this.onDateTimeChanged(target);
					};
				};
		this.add(this.yearChoice);

		this.monthChoice =
				new AjaxDropDownChoice<Integer>(
						"month",
						new CalendarMonthModel(this.getModel()),
						new IntegerRangeListModel(0, 11),
						new ShortMonthChoiceRenderer(this.getLocale())) {

					@Override
					protected void onSelectionChanged(AjaxRequestTarget target) {

						DateTimePicker.this.dayRangeModel.setMax(DateTimePicker.this.getModelObject().getActualMaximum(
								Calendar.DAY_OF_MONTH));
						target.add(DateTimePicker.this.dayChoice);
						DateTimePicker.this.onMonthChanged(target);
						DateTimePicker.this.onDateTimeChanged(target);
					}
				};
		this.add(this.monthChoice);

		this.dayChoice =
				new AjaxDropDownChoice<Integer>("day", new CalendarDayModel(this.getModel()), this.dayRangeModel) {

					@Override
					protected void onSelectionChanged(AjaxRequestTarget target) {

						DateTimePicker.this.onDayChanged(target);
						DateTimePicker.this.onDateTimeChanged(target);
					}
				};
		this.add(this.dayChoice);

		this.hourChoice =
				new AjaxDropDownChoice<Integer>(
						"hour",
						new CalendarHourModel(this.getModel()),
						new IntegerRangeListModel(0, 23)) {

					@Override
					protected void onSelectionChanged(AjaxRequestTarget target) {

						DateTimePicker.this.onHourChanged(target);
						DateTimePicker.this.onDateTimeChanged(target);
					}
				};
		this.add(this.hourChoice);

		this.minuteChoice =
				new AjaxDropDownChoice<Integer>(
						"minute",
						new CalendarMinuteModel(this.getModel()),
						new IntegerRangeListModel(0, 59)) {

					@Override
					protected void onSelectionChanged(AjaxRequestTarget target) {

						DateTimePicker.this.onMinuteChanged(target);
						DateTimePicker.this.onDateTimeChanged(target);
					}
				};
		this.add(this.minuteChoice);

		this.secondChoice =
				new AjaxDropDownChoice<Integer>(
						"second",
						new CalendarSecondModel(this.getModel()),
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
