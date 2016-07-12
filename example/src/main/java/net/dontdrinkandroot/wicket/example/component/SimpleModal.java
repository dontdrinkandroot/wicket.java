package net.dontdrinkandroot.wicket.example.component;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.bootstrap.component.modal.Modal;


public class SimpleModal extends Modal<Void>
{

	public SimpleModal(String id)
	{
		super(id);
	}

	@Override
	protected IModel<String> createHeadingModel()
	{
		return Model.of("This is a simple Modal");
	}

}
