package net.dontdrinkandroot.wicket.model.progress;

import net.dontdrinkandroot.utils.progressmonitor.ProgressStatus;
import net.dontdrinkandroot.wicket.model.AbstractChainedModel;

import org.apache.wicket.model.IModel;


public class ProgressStatusMessageModel extends AbstractChainedModel<ProgressStatus, String> {

	public ProgressStatusMessageModel(IModel<? extends ProgressStatus> parent) {

		super(parent);
	}


	@Override
	public String getObject() {

		return this.getParent().getObject().getMessage();
	}

}
