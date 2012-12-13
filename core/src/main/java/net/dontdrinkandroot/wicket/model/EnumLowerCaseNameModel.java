package net.dontdrinkandroot.wicket.model;

import org.apache.wicket.model.IModel;


/**
 * Returns the name of an enum in lower case or null if not set.
 */
public class EnumLowerCaseNameModel extends AbstractChainedModel<Enum<?>, String> {

	public EnumLowerCaseNameModel(IModel<? extends Enum<?>> parent) {

		super(parent);
	}


	@Override
	public String getObject() {

		if (this.getParent() == null) {
			return null;
		}

		if (this.getParentObject() == null) {
			return null;
		}

		return this.getParentObject().name().toLowerCase();
	}

}
