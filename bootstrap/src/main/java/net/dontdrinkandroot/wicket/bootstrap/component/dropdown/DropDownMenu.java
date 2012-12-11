package net.dontdrinkandroot.wicket.bootstrap.component.dropdown;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.panel.Panel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.Model;


public abstract class DropDownMenu extends Panel {

	public DropDownMenu(String id) {

		super(id);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.DROPDOWN_MENU));
		this.add(new AttributeModifier("role", Model.of("menu")));
		// TODO: include aria-labelledby

		RepeatingView itemView = new RepeatingView("item");
		this.createItems(itemView);
		this.add(itemView);
	}


	protected abstract void createItems(RepeatingView itemView);

}
