package net.dontdrinkandroot.wicket.bootstrap.component.label;

import net.dontdrinkandroot.wicket.bootstrap.behavior.LabelBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.LabelStyle;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;


public class InverseLabel extends Label {

	public InverseLabel(String id) {

		super(id);
	}


	public InverseLabel(String id, IModel<?> model) {

		super(id, model);
	}


	public InverseLabel(String id, String label) {

		super(id, label);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();
		this.add(new LabelBehavior(LabelStyle.INVERSE));
	}

}
