package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public abstract class DropDownItem<T> extends AbstractItem<T> {

	public DropDownItem(String id, IModel<String> labelModel) {

		super(id);

		this.add(new Label("label", labelModel));
	}


	public DropDownItem(String id, String label) {

		super(id);

		this.add(new Label("label", new Model<String>(label)));
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.DROPDOWN));
		RepeatingView dropDownItemView = new RepeatingView("dropDownItem");
		this.createDropDownItems(dropDownItemView);
		this.add(dropDownItemView);
	}


	protected abstract void createDropDownItems(RepeatingView itemView);
}
