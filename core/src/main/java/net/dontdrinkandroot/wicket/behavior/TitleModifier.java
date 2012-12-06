package net.dontdrinkandroot.wicket.behavior;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


/**
 * Sets the <tt>title</tt> attribute of an element.
 */
public class TitleModifier extends AttributeModifier {

	public TitleModifier(IModel<?> replaceModel) {

		super("title", replaceModel);
	}


	public TitleModifier(String titleString) {

		super("title", new Model<String>(titleString));
	}

}
