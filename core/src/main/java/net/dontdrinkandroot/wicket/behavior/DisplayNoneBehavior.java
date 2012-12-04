package net.dontdrinkandroot.wicket.behavior;

import net.dontdrinkandroot.wicket.model.StringModel;

import org.apache.wicket.behavior.AttributeAppender;


public class DisplayNoneBehavior extends AttributeAppender {

	public DisplayNoneBehavior() {

		super("style", new StringModel("display: none"), ";");
	}

}
