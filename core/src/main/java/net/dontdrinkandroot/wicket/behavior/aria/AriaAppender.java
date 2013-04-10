package net.dontdrinkandroot.wicket.behavior.aria;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;


public class AriaAppender extends AttributeAppender {

	public AriaAppender(Aria attribute) {

		super(attribute.getAttribute(), AttributeModifier.VALUELESS_ATTRIBUTE_ADD);
	}


	public AriaAppender(Aria attribute, String value) {

		super(attribute.getAttribute(), value);
	}


	public AriaAppender(Aria attribute, IModel<String> value) {

		super(attribute.getAttribute(), value);
	}

}
