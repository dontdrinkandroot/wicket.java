package net.dontdrinkandroot.wicket.bootstrap.behavior.form;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.bootstrap.css.ColumnSize;
import net.dontdrinkandroot.wicket.model.CssClassToggleModel;


public class FormStyleBehavior extends Behavior
{

	private ColumnSize labelSize;

	private boolean inline = false;


	@Override
	public void bind(Component component)
	{
		super.bind(component);
		component.add(new CssClassAppender(new CssClassToggleModel(BootstrapCssClass.FORM_HORIZONTAL) {

			@Override
			protected boolean isActive()
			{
				return FormStyleBehavior.this.isHorizontal();
			}
		}));
		component.add(new CssClassAppender(new CssClassToggleModel(BootstrapCssClass.FORM_INLINE) {

			@Override
			protected boolean isActive()
			{
				return FormStyleBehavior.this.isInline();
			}
		}));
	}

	public boolean isInline()
	{
		return this.inline;
	}

	public boolean isHorizontal()
	{
		return null != this.labelSize;
	}

	public FormStyleBehavior setHorizontal(ColumnSize labelSize)
	{
		this.inline = false;
		this.labelSize = labelSize;
		return this;
	}

	public FormStyleBehavior setInline(boolean inline)
	{
		this.inline = inline;
		this.labelSize = null;
		return this;
	}

	public ColumnSize getLabelSize()
	{
		return this.labelSize;
	}

	public ColumnSize getContainerSize()
	{
		return this.labelSize.getInverseColumnSize();
	}

}
