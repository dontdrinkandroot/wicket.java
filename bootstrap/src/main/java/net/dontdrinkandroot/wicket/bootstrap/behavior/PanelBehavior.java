package net.dontdrinkandroot.wicket.bootstrap.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.PanelStyle;


public class PanelBehavior extends Behavior
{

	private IModel<PanelStyle> styleModel = Model.of(PanelStyle.DEFAULT);


	public PanelBehavior()
	{
	}

	public PanelBehavior(IModel<PanelStyle> styleModel)
	{
		this.styleModel = styleModel;
	}

	@Override
	public void bind(Component component)
	{
		super.bind(component);
		component.add(new CssClassAppender(BootstrapCssClass.PANEL));
		component.add(new CssClassAppender(this.styleModel));
	}

	public void setStyle(PanelStyle style)
	{
		this.styleModel.setObject(style);
	}

	public PanelStyle getStyle()
	{
		return this.styleModel.getObject();
	}

}
