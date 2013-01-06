package net.dontdrinkandroot.wicket.bootstrap.component.item;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;


public class LabelItem extends AbstractLinkItem {

	public LabelItem(String id, IModel<String> model) {

		super(id, model);
	}


	@Override
	protected Component createLink(String id) {

		return new Label(id, this.getModel());
	}

}
