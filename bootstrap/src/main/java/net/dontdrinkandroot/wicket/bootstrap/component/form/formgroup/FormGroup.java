package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.Component;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.css.CssClass;


public class FormGroup<T> extends GenericPanel<T>
{

	protected IModel<String> labelModel;

	private boolean labelScreenReaderOnly = false;


	public FormGroup(String id)
	{
		super(id);
	}

	public FormGroup(String id, IModel<String> labelModel)
	{
		super(id);
		this.labelModel = labelModel;
	}

	public FormGroup(String id, IModel<String> labelModel, IModel<T> model)
	{
		super(id, model);
		this.labelModel = labelModel;
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.FORM_GROUP));
	}

	protected Component createLabel(String id)
	{
		Label label = new Label(id, this.labelModel);
		label.add(new CssClassAppender(new AbstractReadOnlyModel<CssClass>() {

			@Override
			public CssClass getObject()
			{
				if (FormGroup.this.labelScreenReaderOnly) {
					return BootstrapCssClass.SR_ONLY;
				}
				return null;
			}
		}));

		return label;
	}

	protected WebMarkupContainer createContainer(String id)
	{
		return new WebMarkupContainer(id);
	}

	public FormGroup<T> setLabelScreenReaderOnly(boolean labelScreenReaderOnly)
	{
		this.labelScreenReaderOnly = labelScreenReaderOnly;
		return this;
	}
}
