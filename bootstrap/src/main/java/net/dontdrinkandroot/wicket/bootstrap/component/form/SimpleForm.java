package net.dontdrinkandroot.wicket.bootstrap.component.form;

import org.apache.wicket.IQueueRegion;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.IMarkupFragment;
import org.apache.wicket.markup.html.MarkupUtil;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.IMarkupSourcingStrategy;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.html.panel.PanelMarkupSourcingStrategy;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FeedbackPanel;


public class SimpleForm<T> extends Form<T> implements IQueueRegion
{

	private FeedbackPanel feedbackPanel;


	public SimpleForm(String id)
	{
		super(id);
	}

	public SimpleForm(String id, IModel<T> model)
	{
		super(id, model);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.feedbackPanel = new FeedbackPanel("feedback");
		this.feedbackPanel.setOutputMarkupId(true);
		this.add(this.feedbackPanel);

		RepeatingView formGroupView = new RepeatingView("formGroup");
		this.populateFormGroupView(formGroupView);
		this.add(formGroupView);

		RepeatingView buttonView = new RepeatingView("button");
		this.populateButtonView(buttonView);
		this.add(buttonView);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IMarkupSourcingStrategy newMarkupSourcingStrategy()
	{
		return new PanelMarkupSourcingStrategy(false);
	}

	/**
	 * Returns the markup inside &lt;wicket:panel&gt; tag. If such tag is not found, all the markup is returned.
	 *
	 * @see IQueueRegion#getRegionMarkup()
	 */
	@Override
	public IMarkupFragment getRegionMarkup()
	{
		IMarkupFragment markup = super.getRegionMarkup();

		if (markup == null) {
			return markup;
		}

		IMarkupFragment panelMarkup = MarkupUtil.findStartTag(markup, Panel.PANEL);

		return panelMarkup != null ? panelMarkup : markup;
	}

	@Override
	protected void onComponentTag(ComponentTag tag)
	{
		tag.setName("form");
		super.onComponentTag(tag);
	}

	protected void populateFormGroupView(RepeatingView formGroupView)
	{
		/* Hook */
	}

	protected void populateButtonView(RepeatingView buttonView)
	{
		/* Hook */
	}

	public FeedbackPanel getFeedbackPanel()
	{
		return this.feedbackPanel;
	}

}
