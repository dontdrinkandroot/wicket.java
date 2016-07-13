package net.dontdrinkandroot.wicket.bootstrap.component.form;

import org.apache.wicket.model.IModel;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.ColumnSize;
import net.dontdrinkandroot.wicket.css.CssClass;


public class BootstrapForm<T> extends org.apache.wicket.markup.html.form.Form<T>
{

	private ColumnSize labelColumnSize;

	private ColumnSize formComponentColumnSize;


	public BootstrapForm(String id)
	{
		super(id);
	}

	public BootstrapForm(String id, IModel<T> model)
	{
		super(id, model);
	}

	public BootstrapForm<T> setInline()
	{
		this.add(new CssClassAppender(BootstrapCssClass.FORM_INLINE));

		return this;
	}

	public BootstrapForm<T> setHorizontal(ColumnSize labelColumnSize)
	{
		this.add(new CssClassAppender(BootstrapCssClass.FORM_HORIZONTAL));
		this.labelColumnSize = labelColumnSize;
		this.formComponentColumnSize = labelColumnSize.getInverseColumnSize();

		return this;
	}

	public CssClass getLabelColumnSize()
	{
		return this.labelColumnSize;
	}

	public CssClass getFormComponentColumnSize()
	{
		return this.formComponentColumnSize;
	}

}
