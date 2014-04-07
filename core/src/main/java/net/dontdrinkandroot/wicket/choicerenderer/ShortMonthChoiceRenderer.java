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
package net.dontdrinkandroot.wicket.choicerenderer;

import java.text.DateFormatSymbols;
import java.util.Locale;

import org.apache.wicket.markup.html.form.IChoiceRenderer;


/**
 * Choice renderer that converts Integer values to the corresponding shortMonths String, based on
 * the given locale.
 * 
 * @see DateFormatSymbols#getShortMonths()
 */
public class ShortMonthChoiceRenderer implements IChoiceRenderer<Integer> {

	private final String[] months;


	public ShortMonthChoiceRenderer(Locale locale) {

		this.months = new DateFormatSymbols(locale).getShortMonths();
	}


	@Override
	public Object getDisplayValue(Integer object) {

		return this.months[object.intValue()];
	}


	@Override
	public String getIdValue(Integer object, int index) {

		return Integer.toString(index);
	}

}
