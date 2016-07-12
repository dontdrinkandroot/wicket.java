package net.dontdrinkandroot.wicket.example.page.component;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxButtonLink;
import net.dontdrinkandroot.wicket.bootstrap.event.OpenModalRequest;
import net.dontdrinkandroot.wicket.example.component.SimpleFormModal;
import net.dontdrinkandroot.wicket.example.component.SimpleModal;


public class ModalPage extends ComponentPage
{

	public ModalPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return Model.of("Modals");
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();
		this.add(new AjaxButtonLink<Void>("openStandardModalButton") {

			@Override
			public void onClick(AjaxRequestTarget target)
			{
				this.send(this, Broadcast.BUBBLE, new OpenModalRequest<Void>(target, SimpleModal.class));
			}
		}.setBody(Model.of("Standard Modal")));

		this.add(new AjaxButtonLink<Void>("openFormModalButton") {

			@Override
			public void onClick(AjaxRequestTarget target)
			{
				this.send(this, Broadcast.BUBBLE, new OpenModalRequest<Void>(target, SimpleFormModal.class));
			}
		}.setBody(Model.of("Form Modal")));
	}

}
