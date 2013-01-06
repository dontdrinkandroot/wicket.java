package net.dontdrinkandroot.wicket.bootstrap.component.badge;

import net.dontdrinkandroot.wicket.bootstrap.behavior.BadgeBehavior;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;


public class DefaultBadge extends Label {

	public DefaultBadge(String id) {

		super(id);
	}


	public DefaultBadge(String id, IModel<?> model) {

		super(id, model);
	}


	public DefaultBadge(String id, String label) {

		super(id, label);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();
		this.add(new BadgeBehavior());
	}

}
