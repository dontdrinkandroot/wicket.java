package net.dontdrinkandroot.wicket.bootstrap.component.item;

import org.apache.wicket.Component;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public abstract class AbstractLinkItem<T> extends AbstractItem<T> {

	protected final IModel<String> labelModel;


	public AbstractLinkItem(String id, IModel<String> labelModel) {

		super(id);
		this.labelModel = labelModel;
	}


	public AbstractLinkItem(String id, String label) {

		super(id);
		this.labelModel = new Model<String>(label);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		Component link = this.createLink("link");
		this.add(link);
	}


	protected abstract Component createLink(String id);
}
