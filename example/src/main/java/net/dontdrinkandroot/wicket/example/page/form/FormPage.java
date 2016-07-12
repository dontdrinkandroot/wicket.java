package net.dontdrinkandroot.wicket.example.page.form;

import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupPasswordTextField;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupStatic;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupTextField;
import net.dontdrinkandroot.wicket.example.page.DecoratorPage;


public abstract class FormPage extends DecoratorPage<Void>
{

	public FormPage(PageParameters parameters)
	{
		super(parameters);
	}

	@Override
	protected IModel<String> createPageTitlePrefixModel()
	{
		return Model.of("Forms");
	}

	protected void populateFormGroups(RepeatingView formGroupView)
	{
		formGroupView.add(
				new FormGroupStatic(
						formGroupView.newChildId(),
						Model.of("FormGroupStatic"),
						Model.of("A static label")));
		formGroupView.add(
				new FormGroupTextField<String>(
						formGroupView.newChildId(),
						Model.of("FormGroupTextField"),
						Model.of("")));
		formGroupView.add(
				new FormGroupPasswordTextField(
						formGroupView.newChildId(),
						Model.of("FormGroupPasswordTextField"),
						Model.of("")));
	}
}
