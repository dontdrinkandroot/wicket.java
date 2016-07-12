package net.dontdrinkandroot.wicket.bootstrap.event;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.bootstrap.component.modal.Modal;


public class OpenModalRequest<T>
{

	private IModel<T> model;

	private Class<? extends Modal<?>> modalClass;

	private AjaxRequestTarget target;


	public <C extends Modal<T>> OpenModalRequest(AjaxRequestTarget target, Class<C> modalClass)
	{
		this.target = target;
		this.modalClass = modalClass;
	}

	public <C extends Modal<T>> OpenModalRequest(AjaxRequestTarget target, Class<C> modalClass, IModel<T> model)
	{
		this.target = target;
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

	public AjaxRequestTarget getTarget()
	{
		return this.target;
	}
}
