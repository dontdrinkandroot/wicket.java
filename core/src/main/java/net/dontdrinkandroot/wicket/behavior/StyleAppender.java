package net.dontdrinkandroot.wicket.behavior;

import net.dontdrinkandroot.wicket.model.StringModel;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;


/**
 * Appends the given style to the style attribute of an element.
 */
public class StyleAppender extends AttributeAppender {

	private static final long serialVersionUID = 793104976029930067L;


	public StyleAppender(final String style) {

		super("style", new StringModel(style), ";");
	}


	public StyleAppender(IModel<?> styleModel) {

		super("style", styleModel, ";");
	}

}
