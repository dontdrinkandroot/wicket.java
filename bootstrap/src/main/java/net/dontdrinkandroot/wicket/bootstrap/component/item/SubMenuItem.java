package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropDownMenu;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;


public abstract class SubMenuItem extends AbstractItem<String> {

	public SubMenuItem(String id, IModel<String> labelModel) {

		super(id, labelModel);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.DROPDOWN_SUBMENU));
		this.add(new Label("label", this.getModel()));
		this.add(new DropDownMenu("dropDownMenu") {

			@Override
			protected void createItems(RepeatingView itemView) {

				SubMenuItem.this.createItems(itemView);
			}
		});
	}


	protected abstract void createItems(RepeatingView itemView);
}
