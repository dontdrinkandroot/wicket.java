package net.dontdrinkandroot.wicket.bootstrap.component.button;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;


public abstract class ButtonGroup<T> extends GenericPanel<T> {

	public ButtonGroup(String id) {

		super(id);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.BTN_GROUP));

		RepeatingView buttonView = new RepeatingView("button");
		this.createButtons(buttonView);
		this.add(buttonView);
	}


	protected abstract void createButtons(RepeatingView buttonView);

}
