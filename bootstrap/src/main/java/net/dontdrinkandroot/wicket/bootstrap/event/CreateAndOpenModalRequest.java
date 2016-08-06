package net.dontdrinkandroot.wicket.bootstrap.event;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.modal.Modal;


public class CreateAndOpenModalRequest<T> extends ModalRequest
{

	private IModel<T> model;

	private Class<? extends Modal<?>> modalClass;


	public <C extends Modal<T>> CreateAndOpenModalRequest(AjaxRequestTarget target, Class<C> modalClass)
	{
		super(target);
		this.modalClass = modalClass;
	}

	public <C extends Modal<T>> CreateAndOpenModalRequest(
			AjaxRequestTarget target,
			Class<C> modalClass,
			IModel<T> model)
	{
		super(target);
		this.modalClass = modalClass;
		this.model = model;
	}

	public Class<? extends Modal<?>> getModalClass()
	{
		return this.modalClass;
	}

	public IModel<T> getModel()
	{
		return this.model;
	}

}
