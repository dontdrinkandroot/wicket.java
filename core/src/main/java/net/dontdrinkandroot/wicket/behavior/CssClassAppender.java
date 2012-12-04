package net.dontdrinkandroot.wicket.behavior;

import net.dontdrinkandroot.wicket.css.CssClass;
import net.dontdrinkandroot.wicket.model.CssClassClassStringModel;
import net.dontdrinkandroot.wicket.model.StringModel;

import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.model.IModel;


public class CssClassAppender extends AttributeAppender {

	public CssClassAppender(final String classToAdd) {

		super("class", new StringModel(classToAdd), " ");
	}


	public CssClassAppender(CssClass cssClass) {

		super("class", new StringModel(cssClass.getClassString()), " ");
	}


	public CssClassAppender(IModel<? extends CssClass> cssClassModel) {

		super("class", new CssClassClassStringModel(cssClassModel), " ");
	}

}
