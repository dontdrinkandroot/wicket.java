package net.dontdrinkandroot.wicket.model;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class AppendingStringModel extends AbstractChainedModel<String, String>
{

	private IModel<String> appendStringModel;


	public AppendingStringModel(IModel<? extends String> parent, String appendString)
	{
		super(parent);
		this.appendStringModel = Model.of(appendString);
	}

	public AppendingStringModel(IModel<? extends String> parent, IModel<String> appendStringModel)
	{
		super(parent);
		this.appendStringModel = appendStringModel;
	}

	@Override
	public String getObject()
	{
		return this.getParentObject() + this.appendStringModel.getObject();
	}

}
