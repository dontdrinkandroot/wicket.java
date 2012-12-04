package net.dontdrinkandroot.wicket.behavior;

import net.dontdrinkandroot.wicket.model.StringModel;

import org.apache.wicket.behavior.AttributeAppender;


public class AddOnClickScriptBehavior extends AttributeAppender {

	private static final long serialVersionUID = 6000872232041944136L;


	public AddOnClickScriptBehavior(final String script) {

		super("onclick", new StringModel(script), " ");
	}

}
