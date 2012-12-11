package net.dontdrinkandroot.wicket.bootstrap.component.item;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;


public class LabelItem extends AbstractItem<String> {

	public LabelItem(String id, IModel<String> model) {

		super(id, model);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new Label("label", this.getModel()));
	}

}
