package net.dontdrinkandroot.wicket.model;

import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.css.CssClass;


public class CssClassToggleModel extends AbstractReadOnlyModel<CssClass>
{

	private IModel<Boolean> toggleModel;

	private CssClass activeClass;

	private CssClass inactiveClass;


	public CssClassToggleModel(CssClass activeClass)
	{
		this.toggleModel = Model.of(true);
		this.activeClass = activeClass;
	}

	public CssClassToggleModel(IModel<Boolean> toggleModel, CssClass activeClass)
	{
		this.toggleModel = toggleModel;
		this.activeClass = activeClass;
	}

	public CssClassToggleModel(IModel<Boolean> toggleModel, CssClass activeClass, CssClass inactiveClass)
	{
		this.toggleModel = toggleModel;
		this.activeClass = activeClass;
		this.inactiveClass = inactiveClass;
	}

	@Override
	public CssClass getObject()
	{
		if (this.isActive()) {
			return this.activeClass;
		} else {
			return this.inactiveClass;
		}
	}

	protected boolean isActive()
	{
		return this.toggleModel.getObject().booleanValue();
	}

	@Override
	public void detach()
	{
		super.detach();
		if (null != this.toggleModel) {
			this.toggleModel.detach();
		}
	}

}
