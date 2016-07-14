package net.dontdrinkandroot.wicket.model;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class ConcatenatingStringModel extends AbstractChainedModel<String, String>
{

	private IModel<String> suffixModel;

	private String separator;


	public ConcatenatingStringModel(IModel<? extends String> parent, String appendString)
	{
		super(parent);
		this.suffixModel = Model.of(appendString);
	}

	public ConcatenatingStringModel(IModel<? extends String> parent, IModel<String> appendStringModel)
	{
		super(parent);
		this.suffixModel = appendStringModel;
	}

	public ConcatenatingStringModel(IModel<? extends String> parent, String separator, IModel<String> appendStringModel)
	{
		super(parent);
		this.suffixModel = appendStringModel;
		this.separator = separator;
	}

	@Override
	public String getObject()
	{
		String prefix = this.getParentObject();
		if (null == this.suffixModel) {
			return prefix;
		}
		String suffix = this.suffixModel.getObject();

		StringBuffer concatenatedString = new StringBuffer();
		if (null != prefix) {
			concatenatedString.append(prefix);
		}
		if ((null != this.separator) && (null != prefix) && (null != suffix)) {
			concatenatedString.append(this.separator);
		}
		if (null != suffix) {
			concatenatedString.append(suffix);
		}

		return concatenatedString.toString();
	}

}
