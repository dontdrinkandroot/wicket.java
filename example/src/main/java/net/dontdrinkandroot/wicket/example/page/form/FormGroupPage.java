package net.dontdrinkandroot.wicket.example.page.form;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.behavior.form.FormStyleBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.item.AjaxLinkItem;
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeStack;


public class FormGroupPage extends FormPage
{

	protected FormStyleBehavior formStyleBehavior = new FormStyleBehavior().setHorizontal(ColumnSizeStack.FORM_DEFAULT);


	public FormGroupPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return Model.of("Form Groups and Form Styles");
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		RepeatingView styleItemView = new RepeatingView("styleItem");
		this.add(styleItemView);

		styleItemView.add(new AjaxLinkItem(styleItemView.newChildId(), Model.of("Default")) {

			@Override
			protected void onClick(AjaxRequestTarget target)
			{
				FormGroupPage.this.formStyleBehavior.reset();
				this.setResponsePage(this.getPage());
			}

			@Override
			protected boolean isActive()
			{
				return !FormGroupPage.this.formStyleBehavior.isInline()
						&& !FormGroupPage.this.formStyleBehavior.isHorizontal();
			}
		});
		styleItemView.add(new AjaxLinkItem(styleItemView.newChildId(), Model.of("Horizontal")) {

			@Override
			protected void onClick(AjaxRequestTarget target)
			{
				FormGroupPage.this.formStyleBehavior.setHorizontal(ColumnSizeStack.FORM_DEFAULT);
				this.setResponsePage(this.getPage());
			}

			@Override
			protected boolean isActive()
			{
				return FormGroupPage.this.formStyleBehavior.isHorizontal();
			}
		});
		styleItemView.add(new AjaxLinkItem(styleItemView.newChildId(), Model.of("Inline")) {

			@Override
			protected void onClick(AjaxRequestTarget target)
			{
				FormGroupPage.this.formStyleBehavior.setInline(true);
				this.setResponsePage(this.getPage());
			}

			@Override
			protected boolean isActive()
			{
				return FormGroupPage.this.formStyleBehavior.isInline();
			}
		});

		Form<Void> form = new Form<Void>("form");
		form.add(this.formStyleBehavior);
		this.add(form);

		RepeatingView formGroupView = new RepeatingView("formGroup");
		this.populateFormGroups(form, formGroupView);
		form.add(formGroupView);
	}
}
