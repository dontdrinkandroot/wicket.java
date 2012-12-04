package net.dontdrinkandroot.wicket.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.wicket.model.IModel;


public class SimpleDateFormatModel extends AbstractChainedModel<Date, String> {

	private final SimpleDateFormat sdf;


	public SimpleDateFormatModel(IModel<? extends Date> parent, String pattern) {

		super(parent);
		this.sdf = new SimpleDateFormat(pattern);
	}


	@Override
	public String getObject() {

		return this.sdf.format(this.getParentObject());
	}

}
