package net.dontdrinkandroot.wicket.bootstrap.component.badge;

import net.dontdrinkandroot.wicket.bootstrap.behavior.BadgeBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.BadgeStyle;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;


public class InfoBadge extends Label {

	public InfoBadge(String id) {

		super(id);
	}


	public InfoBadge(String id, IModel<?> model) {

		super(id, model);
	}


	public InfoBadge(String id, String label) {

		super(id, label);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();
		this.add(new BadgeBehavior(BadgeStyle.INFO));
	}

}
