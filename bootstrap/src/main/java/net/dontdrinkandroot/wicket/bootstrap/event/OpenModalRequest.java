package net.dontdrinkandroot.wicket.bootstrap.event;

import org.apache.wicket.ajax.AjaxRequestTarget;

import net.dontdrinkandroot.wicket.bootstrap.component.modal.Modal;


public class OpenModalRequest extends ModalRequest
{

	private Modal<?> modal;


	public OpenModalRequest(AjaxRequestTarget target, Modal<?> modal)
	{
		super(target);
		this.modal = modal;
	}

	public Modal<?> getModal()
	{
		return this.modal;
	}
}
