package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.LabelStyle;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class LabelBehavior extends Behavior {

	private IModel<LabelStyle> labelStyleModel;


	public LabelBehavior() {

	}


	public LabelBehavior(LabelStyle labelStyle) {

		this.labelStyleModel = Model.of(labelStyle);
	}


	public LabelBehavior(IModel<LabelStyle> labelStyleModel) {

		this.labelStyleModel = labelStyleModel;
	}


	@Override
	public void bind(Component component) {

		super.bind(component);

		component.add(new CssClassAppender(BootstrapCssClass.LABEL));
		component.add(new CssClassAppender(this.labelStyleModel));
	}
}
