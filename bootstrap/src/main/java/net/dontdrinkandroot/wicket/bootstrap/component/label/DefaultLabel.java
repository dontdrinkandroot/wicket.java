package net.dontdrinkandroot.wicket.bootstrap.component.label;

import net.dontdrinkandroot.wicket.bootstrap.behavior.LabelBehavior;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;


public class DefaultLabel extends Label {

	public DefaultLabel(String id) {

		super(id);
	}


	public DefaultLabel(String id, IModel<?> model) {

		super(id, model);
	}


	public DefaultLabel(String id, String label) {

		super(id, label);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();
		this.add(new LabelBehavior());
	}

}
