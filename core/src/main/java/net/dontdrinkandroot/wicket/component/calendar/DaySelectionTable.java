package net.dontdrinkandroot.wicket.component.calendar;

import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.wicket.Component;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.css.SimpleCssClass;


public class DaySelectionTable extends GenericPanel<Integer>
{

	public IModel<Integer> yearModel;

	public IModel<Integer> monthModel;

	private RepeatingView headingCellRepeater;

	private RepeatingView rowRepeater;

	private List<Integer> weekDayOrder;


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

		this.add(new CssClassAppender("month"));
		this.setOutputMarkupId(true);
		this.weekDayOrder = this.createWeekDayOrder();

		this.headingCellRepeater = new RepeatingView("headingCell");
		this.add(this.headingCellRepeater);

		this.rowRepeater = new RepeatingView("row");
		this.add(this.rowRepeater);

		DateFormatSymbols symbols = DateFormatSymbols.getInstance(this.getLocale());
		String[] shortWeekdays = symbols.getShortWeekdays();

		this.headingCellRepeater.add(new Label(this.headingCellRepeater.newChildId(), ""));
		for (Integer weekDayNumber : this.weekDayOrder) {
			Label label = new Label(this.headingCellRepeater.newChildId(), shortWeekdays[weekDayNumber]);
			label.add(new CssClassAppender("day-of-week"));
			this.headingCellRepeater.add(label);
		}
	}

	@Override
	protected void onBeforeRender()
	{
		super.onBeforeRender();

		this.rowRepeater.removeAll();

		Calendar referenceCalendar = GregorianCalendar.getInstance(this.getLocale());
		referenceCalendar.set(this.yearModel.getObject(), this.monthModel.getObject(), 1);

		int minDayOfMonth = referenceCalendar.getActualMinimum(Calendar.DAY_OF_MONTH);
		int maxDayOfMonth = referenceCalendar.getActualMaximum(Calendar.DAY_OF_MONTH);

		if ((this.getModelObject() != null) && (maxDayOfMonth < this.getModelObject())) {
			this.setModelObject(null);
		}

		Calendar startDate = (Calendar) referenceCalendar.clone();

		Calendar endDate = (Calendar) referenceCalendar.clone();
		endDate.set(Calendar.DAY_OF_MONTH, maxDayOfMonth);

		int startWeek = startDate.get(Calendar.WEEK_OF_YEAR);
		int endWeek = endDate.get(Calendar.WEEK_OF_YEAR);

		/* Wrap around */
		if ((startWeek == 53) || (startWeek == 52)) {
			startWeek = 0;
		}

		// TODO: We have a problem if the year starts with week 53

		for (int currentWeek = startWeek; (currentWeek <= endWeek); currentWeek++) {

			WebMarkupContainer rowContainer = new WebMarkupContainer(this.rowRepeater.newChildId());
			this.rowRepeater.add(rowContainer);

			RepeatingView cellRepeater = new RepeatingView("cell");
			rowContainer.add(cellRepeater);

			WebMarkupContainer cellContainer = new WebMarkupContainer(cellRepeater.newChildId());
			cellRepeater.add(cellContainer);

			cellContainer.add(new Label("link", currentWeek).setRenderBodyOnly(true));
			cellContainer.add(new CssClassAppender("week-of-year"));

			for (Integer currentWeekDay : this.weekDayOrder) {

				referenceCalendar.setWeekDate(this.yearModel.getObject(), currentWeek, currentWeekDay.intValue());
				final int currentDay = referenceCalendar.get(Calendar.DAY_OF_MONTH);
				int currentMonth = referenceCalendar.get(Calendar.MONTH);

				cellContainer = new WebMarkupContainer(cellRepeater.newChildId());
				cellRepeater.add(cellContainer);

				if (currentMonth == this.monthModel.getObject().intValue()) {
					Component link = this.createLink(currentDay);
					cellContainer.add(link);
				} else {
					cellContainer.add(new Label("link", currentDay).setRenderBodyOnly(true));
				}

				this.applyCellStyle(cellContainer, currentMonth, currentDay);
			}
		}

	}

	@Override
	protected void onComponentTag(ComponentTag tag)
	{
		super.onComponentTag(tag);
		tag.setName("table");
	}

	protected void applyCellStyle(WebMarkupContainer cellContainer, int currentMonth, int currentDay)
	{
		cellContainer.add(new CssClassAppender("day"));
		if (currentMonth == this.monthModel.getObject().intValue()) {
			if ((null != this.getModelObject()) && (currentDay == this.getModelObject().intValue())) {
				cellContainer.add(new CssClassAppender(new SimpleCssClass("active")));
			}
		} else {
			cellContainer.add(new CssClassAppender(new SimpleCssClass("disabled")));
		}
	}

	protected Component createLink(final int currentDay)
	{
		AjaxLink<Integer> link = new AjaxLink<Integer>("link", new Model<Integer>(currentDay)) {

			@Override
			public void onClick(AjaxRequestTarget target)
			{
				DaySelectionTable.this.onDaySelected(target, currentDay);
			}

		};
		link.setBody(new Model<Integer>(currentDay));

		return link;
	}

	protected List<Integer> createWeekDayOrder()
	{
		List<Integer> weekDayOrder = new ArrayList<Integer>();
		int firstDayOfWeek = GregorianCalendar.getInstance(this.getLocale()).getFirstDayOfWeek();
		for (int i = 0; i < 7; i++) {
			weekDayOrder.add((((firstDayOfWeek + i) - 1) % 7) + 1);
		}

		return weekDayOrder;
	}

	protected void onDaySelected(AjaxRequestTarget target, int currentDay)
	{
		this.setModelObject(currentDay);
		target.add(this);
	}

}
