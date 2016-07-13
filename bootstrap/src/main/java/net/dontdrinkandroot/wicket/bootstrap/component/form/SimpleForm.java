package net.dontdrinkandroot.wicket.bootstrap.component.form;

import org.apache.wicket.Component;
import org.apache.wicket.IQueueRegion;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.panel.IMarkupSourcingStrategy;
import org.apache.wicket.markup.html.panel.PanelMarkupSourcingStrategy;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.feedback.FeedbackPanel;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupActions;


public class SimpleForm<T> extends BootstrapForm<T> implements IQueueRegion
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
		this.populateFormGroups(formGroupView);
		this.add(formGroupView);

		Component formGroupActions = this.createActionsView("actions");
		this.add(formGroupActions);
	}

	protected Component createActionsView(String id)
	{
		FormGroupActions<Void> formGroupActions = new FormGroupActions<Void>(id) {

			@Override
			protected void populateActions(RepeatingView actionView)
			{
				SimpleForm.this.populateActions(actionView);
			}
		};
		return formGroupActions;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected IMarkupSourcingStrategy newMarkupSourcingStrategy()
	{
		return new PanelMarkupSourcingStrategy(false);
	}

	@Override
	protected void onComponentTag(ComponentTag tag)
	{
		tag.setName("form");
		super.onComponentTag(tag);
	}

	protected void populateFormGroups(RepeatingView formGroupView)
	{
		/* Hook */
	}

	protected void populateActions(RepeatingView buttonView)
	{
		/* Hook */
	}

	public FeedbackPanel getFeedbackPanel()
	{
		return this.feedbackPanel;
	}
}
