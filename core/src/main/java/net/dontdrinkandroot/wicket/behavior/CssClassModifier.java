package net.dontdrinkandroot.wicket.behavior;

import net.dontdrinkandroot.wicket.model.StringModel;

import org.apache.wicket.AttributeModifier;


public class CssClassModifier extends AttributeModifier {

	public CssClassModifier(final String style) {

		super("class", new StringModel(style));
	}

}
