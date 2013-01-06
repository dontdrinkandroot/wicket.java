package net.dontdrinkandroot.wicket.bootstrap.component.badge;

import net.dontdrinkandroot.wicket.bootstrap.behavior.BadgeBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.BadgeStyle;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;


public class WarningBadge extends Label {

	public WarningBadge(String id) {

		super(id);
	}


	public WarningBadge(String id, IModel<?> model) {

		super(id, model);
	}


	public WarningBadge(String id, String label) {

		super(id, label);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();
		this.add(new BadgeBehavior(BadgeStyle.WARNING));
	}

}
