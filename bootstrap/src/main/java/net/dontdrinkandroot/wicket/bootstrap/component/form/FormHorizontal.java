package net.dontdrinkandroot.wicket.bootstrap.component.form;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.css.CssClass;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.model.IModel;


public class FormHorizontal<T> extends Form<T> {

	private final CssClass labelColumnSize;

	private final CssClass formComponentColumnSize;


	public FormHorizontal(String id, CssClass labelColumnSize, CssClass formComponentColumnSize) {

		super(id);
		this.labelColumnSize = labelColumnSize;
		this.formComponentColumnSize = formComponentColumnSize;
	}


	public FormHorizontal(
			final String id,
			final IModel<T> model,
			CssClass labelColumnSize,
			CssClass formComponentColumnSize) {

		super(id, model);
		this.labelColumnSize = labelColumnSize;
		this.formComponentColumnSize = formComponentColumnSize;
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();
		this.add(new CssClassAppender(BootstrapCssClass.FORM_HORIZONTAL));
		this.add(new AttributeModifier("role", "form"));
	}


	public CssClass getLabelColumnSize() {

		return this.labelColumnSize;
	}


	public CssClass getFormComponentColumnSize() {

		return this.formComponentColumnSize;
	}

}
