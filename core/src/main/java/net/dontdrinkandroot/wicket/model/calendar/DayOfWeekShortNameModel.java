package net.dontdrinkandroot.wicket.model.calendar;

import java.text.DateFormatSymbols;
import java.util.Locale;

import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.model.AbstractChainedModel;


public class DayOfWeekShortNameModel extends AbstractChainedModel<Integer, String>
{

	private Locale locale;


	public DayOfWeekShortNameModel(IModel<? extends Integer> parent, Locale locale)
	{
		super(parent);
		this.locale = locale;
	}

	@Override
	public String getObject()
	{
		Integer dayOfWeek = this.getParentObject();
		if (null == dayOfWeek) {
			return null;
		}

		DateFormatSymbols symbols = new DateFormatSymbols(this.locale);
		String[] names = symbols.getShortWeekdays();

		return names[dayOfWeek.intValue()];
	}

}
