package net.dontdrinkandroot.wicket.component.calendar;

import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;


public class DaySelectionTable extends GenericPanel<Integer>
{

	public IModel<Integer> yearModel;

	public IModel<Integer> monthModel;


	public DaySelectionTable(String id, IModel<Integer> model, IModel<Integer> yearModel, IModel<Integer> monthModel)
	{
		super(id, model);

		this.yearModel = yearModel;
		this.monthModel = monthModel;
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
	}

}
