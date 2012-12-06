package net.dontdrinkandroot.wicket.behavior;

import net.dontdrinkandroot.wicket.css.CssClass;
import net.dontdrinkandroot.wicket.model.CssClassClassStringModel;
import net.dontdrinkandroot.wicket.model.StringModel;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.model.IModel;


/**
 * Replaces the <tt>class</tt> attribute of an element.
 */
public class CssClassModifier extends AttributeModifier {

	public CssClassModifier(final String classToAdd) {

		super("class", new StringModel(classToAdd));
	}


	public CssClassModifier(CssClass cssClass) {

		super("class", new StringModel(cssClass.getClassString()));
	}


	public CssClassModifier(IModel<? extends CssClass> cssClassModel) {

		super("class", new CssClassClassStringModel(cssClassModel));
	}

}
