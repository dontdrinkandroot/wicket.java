package net.dontdrinkandroot.wicket.example.component;

import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.bootstrap.component.button.AjaxSubmitButton;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupStatic;
import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupTextField;
import net.dontdrinkandroot.wicket.bootstrap.component.modal.FormModal;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;


public class SimpleFormModal extends FormModal<Void>
{

	public SimpleFormModal(String id)
	{
		super(id);
	}

	@Override
	protected IModel<String> createHeadingModel()
	{
		return Model.of("This is a form modal");
	}

	@Override
	protected void populateFormGroups(RepeatingView formGroupView)
	{
		formGroupView.add(
				new FormGroupStatic(
						formGroupView.newChildId(),
						Model.of(FormGroupStatic.class.getSimpleName()),
						Model.of("A static label")));
		formGroupView.add(
				new FormGroupTextField<String>(
						formGroupView.newChildId(),
						Model.of(FormGroupTextField.class.getSimpleName()),
						Model.of("")));
	}

	@Override
	protected void populateFormActions(RepeatingView formActionView)
	{
		formActionView.add(new AjaxSubmitButton(formActionView.newChildId(), this.getForm(), Model.of("Submit")) {
		}.setButtonStyle(ButtonStyle.PRIMARY));
	}

}
