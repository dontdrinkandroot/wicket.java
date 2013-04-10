package net.dontdrinkandroot.wicket.bootstrap.component.modal;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;


public abstract class AbstractBaseModalPanel<T> extends GenericPanel<T> {

	public AbstractBaseModalPanel(String id) {

		super(id);
		this.setOutputMarkupId(true);
	}


	public AbstractBaseModalPanel(String id, IModel<T> model) {

		super(id, model);
		this.setOutputMarkupId(true);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.MODAL));
		this.add(new CssClassAppender(BootstrapCssClass.HIDE));
		this.add(new CssClassAppender(BootstrapCssClass.FADE));
	}


	protected Component createBody(String id) {

		return new WebMarkupContainer(id);
	}


	protected Component createFooter(String id) {

		return new WebMarkupContainer(id);
	}


	protected abstract IModel<String> createHeadingModel();


	public CharSequence getHideScript() {

		return String.format("$('%s').modal('hide');", this.getMarkupId());
	}


	public CharSequence getShowScript() {

		return String.format("$('%s').modal('show');", this.getMarkupId());
	}


	public CharSequence getToggleScript() {

		return String.format("$('%s').modal('toggle');", this.getMarkupId());
	}
}
