package net.dontdrinkandroot.wicket.bootstrap.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.model.CssClassToggleModel;


public class NavTabsBehavior extends Behavior
{

	private IModel<Boolean> justifiedModel = Model.of(Boolean.FALSE);


	@Override
	public void bind(Component component)
	{
		super.bind(component);

		component.add(new CssClassAppender(BootstrapCssClass.NAV));
		component.add(new CssClassAppender(BootstrapCssClass.NAV_TABS));
		component.add(
				new CssClassAppender(new CssClassToggleModel(this.justifiedModel, BootstrapCssClass.NAV_JUSTIFIED)));
	}

	public void setJustified(boolean justified)
	{
		this.justifiedModel.setObject(justified);
	}
}
