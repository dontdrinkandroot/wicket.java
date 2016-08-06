package net.dontdrinkandroot.wicket.bootstrap.event;

import org.apache.wicket.ajax.AjaxRequestTarget;


public class ModalRequest
{

	private AjaxRequestTarget target;


	public ModalRequest(AjaxRequestTarget target)
	{
		this.target = target;
	}

	public AjaxRequestTarget getTarget()
	{
		return this.target;
	}
}
