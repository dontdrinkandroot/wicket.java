package net.dontdrinkandroot.wicket.choicerenderer;

import java.text.DateFormatSymbols;
import java.util.Locale;

import org.apache.wicket.markup.html.form.IChoiceRenderer;


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
