package net.dontdrinkandroot.wicket.bootstrap.component.modal;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;


public abstract class Modal<T> extends GenericPanel<T>
{

	public Modal(String id)
	{
		super(id);
	}

	public Modal(String id, IModel<T> model)
	{
		super(id, model);
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.setOutputMarkupId(true);
		this.add(new CssClassAppender(BootstrapCssClass.MODAL));
		this.add(new CssClassAppender(BootstrapCssClass.FADE));

		Label headingLabel = new Label("heading", this.createHeadingModel());
		headingLabel.add(new CssClassAppender(BootstrapCssClass.MODAL_TITLE));
		this.add(headingLabel);

		this.addFooter();
	}

	protected void addFooter()
	{
		this.add(this.createFooter("footer"));

	}

	protected Component createFooter(String id)
	{
		WebMarkupContainer footer = new WebMarkupContainer(id);
		footer.setVisible(false);

		return footer;
	}

	public CharSequence getHideScript()
	{
		return String.format("$('#%s').modal('hide');", this.getMarkupId());
	}

	public CharSequence getShowScript()
	{
		return String.format("$('#%s').modal({'show': true, 'backdrop':'static'});", this.getMarkupId());
	}

	public CharSequence getToggleScript()
	{
		return String.format("$('#%s').modal('toggle');", this.getMarkupId());
	}

	protected abstract IModel<String> createHeadingModel();
}
