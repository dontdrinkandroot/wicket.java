package net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup;

import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.component.form.BootstrapForm;
import net.dontdrinkandroot.wicket.css.CssClass;


public class FormGroupStatic extends GenericPanel<String>
{

	private IModel<String> labelModel;

	private Label label;

	private WebMarkupContainer contentContainer;

	private Label content;


	public FormGroupStatic(String id, IModel<String> labelModel, IModel<String> contentModel)
	{
		super(id, contentModel);
		this.labelModel = labelModel;
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.label = new Label("label", this.labelModel);
		this.add(this.label);

		this.contentContainer = new WebMarkupContainer("contentContainer");
		this.add(this.contentContainer);

		this.content = new Label("content", this.getModel());
		this.contentContainer.add(this.content);

		this.label.add(new CssClassAppender(new AbstractReadOnlyModel<CssClass>() {

			@Override
			public CssClass getObject()
			{
				Form<?> form = Form.findForm(FormGroupStatic.this);
				if ((null != form)
						&& (form instanceof BootstrapForm)
						&& (null != ((BootstrapForm<?>) form).getLabelColumnSize())) {
					return ((BootstrapForm<?>) form).getLabelColumnSize();
				}
				return null;
			}
		}));
		this.contentContainer.add(new CssClassAppender(new AbstractReadOnlyModel<CssClass>() {

			@Override
			public CssClass getObject()
			{
				Form<?> form = Form.findForm(FormGroupStatic.this);
				if ((null != form)
						&& (form instanceof BootstrapForm)
						&& (null != ((BootstrapForm<?>) form).getFormComponentColumnSize())) {
					return ((BootstrapForm<?>) form).getFormComponentColumnSize();
				}
				return null;
			}
		}));
	}

}
