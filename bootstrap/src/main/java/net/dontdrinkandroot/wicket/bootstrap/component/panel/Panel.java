package net.dontdrinkandroot.wicket.bootstrap.component.panel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.PanelStyle;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public abstract class Panel<T> extends GenericPanel<T> {

	private final IModel<PanelStyle> styleModel = Model.of(PanelStyle.DEFAULT);


	public Panel(final String id) {

		this(id, null);
	}


	public Panel(final String id, final IModel<T> model) {

		super(id, model);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.PANEL));
		this.add(new CssClassAppender(this.styleModel));

		Component headingComponent = this.createHeadingComponent("heading");
		headingComponent.add(new CssClassAppender(BootstrapCssClass.PANEL_HEADING));
		this.add(headingComponent);

		this.add(this.createAfterBodyComponent("afterBody"));

		Component footerComponent = this.createFooterComponent("footer");
		footerComponent.add(new CssClassAppender(BootstrapCssClass.PANEL_FOOTER));
		this.add(footerComponent);
	}


	public Panel<T> setPanelStyle(PanelStyle style) {

		this.styleModel.setObject(style);
		return this;
	}


	public PanelStyle getPanelStyle() {

		return this.styleModel.getObject();
	}


	protected abstract Component createFooterComponent(String id);


	protected abstract Component createAfterBodyComponent(String id);


	protected abstract Component createHeadingComponent(String id);
}
