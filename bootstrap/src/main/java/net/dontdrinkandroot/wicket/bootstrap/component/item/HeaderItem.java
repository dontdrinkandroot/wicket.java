package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;


public class HeaderItem extends Label {

	public HeaderItem(String id, IModel<String> labelModel) {

		super(id, labelModel);
		this.add(new CssClassAppender(BootstrapCssClass.NAV_HEADER));
	}

}
