package net.dontdrinkandroot.wicket.bootstrap.component.panel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.component.basic.Heading;

import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;


public class PanelHeading extends GenericPanel<String> {

	public PanelHeading(String id, IModel<String> model, Heading.Level level) {

		super(id, model);

		Heading heading = new Heading("heading", model, level);
		heading.add(new CssClassAppender(BootstrapCssClass.PANEL_TITLE));
		this.add(heading);
	}
}
