package net.dontdrinkandroot.wicket.bootstrap.component.badge;

import net.dontdrinkandroot.wicket.bootstrap.behavior.BadgeBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.BadgeStyle;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;


public class ImportantBadge extends Label {

	public ImportantBadge(String id) {

		super(id);
	}


	public ImportantBadge(String id, IModel<?> model) {

		super(id, model);
	}


	public ImportantBadge(String id, String label) {

		super(id, label);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();
		this.add(new BadgeBehavior(BadgeStyle.IMPORTANT));
	}

}
