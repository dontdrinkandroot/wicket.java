package net.dontdrinkandroot.wicket.example.page.form;

import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.component.form.BootstrapForm;
import net.dontdrinkandroot.wicket.bootstrap.css.ColumnSize;


public class HorizontalFormPage extends FormPage
{

	public HorizontalFormPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected IModel<String> createPageHeadingModel()
	{
		return Model.of("Hoirzontal Form");
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		BootstrapForm<Void> form = new BootstrapForm<Void>("form");
		form.setHorizontal(ColumnSize.MD_4, ColumnSize.MD_8);
		this.add(form);

		RepeatingView formGroupView = new RepeatingView("formGroup");
		this.populateFormGroups(form, formGroupView);
		form.add(formGroupView);
	}

}
