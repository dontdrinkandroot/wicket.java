package net.dontdrinkandroot.wicket.model;

import net.dontdrinkandroot.wicket.css.CssClass;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class CssClassClassStringModel extends AbstractChainedModel<CssClass, String> {

	public CssClassClassStringModel(IModel<? extends CssClass> parent) {

		super(parent);
	}


	public CssClassClassStringModel(CssClass cssClass) {

		super(new Model<CssClass>(cssClass));
	}


	@Override
	public String getObject() {

		if (this.getParentObject() == null || !this.isActive()) {
			return null;
		}

		return this.getParentObject().getClassString();
	}


	protected boolean isActive() {

		return true;
	}

}
