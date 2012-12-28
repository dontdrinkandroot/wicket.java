package net.dontdrinkandroot.wicket.model.progress;

import net.dontdrinkandroot.utils.progressmonitor.ProgressStatus;
import net.dontdrinkandroot.wicket.model.AbstractChainedModel;

import org.apache.wicket.model.IModel;


public class ProgressStatusPercentModel extends AbstractChainedModel<ProgressStatus, Integer> {

	public ProgressStatusPercentModel(IModel<? extends ProgressStatus> parent) {

		super(parent);
	}


	@Override
	public Integer getObject() {

		if (this.getParent() == null) {
			return 0;
		}
		return this.getParent().getObject().getProgress();
	}

}
