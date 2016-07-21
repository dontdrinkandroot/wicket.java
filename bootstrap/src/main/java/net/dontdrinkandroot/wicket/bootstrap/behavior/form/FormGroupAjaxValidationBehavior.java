package net.dontdrinkandroot.wicket.bootstrap.behavior.form;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.FormGroupValidatable;
import net.dontdrinkandroot.wicket.bootstrap.css.ValidationState;
import net.dontdrinkandroot.wicket.javascript.JQueryScript;


public class FormGroupAjaxValidationBehavior extends AjaxFormComponentUpdatingBehavior
{

	private ThrottlingSettings throttlingSettings;

	private FormGroupValidatable<?, ?> formGroup;


	public FormGroupAjaxValidationBehavior(String event, FormGroupValidatable<?, ?> formGroup)
	{
		super(event);
		this.formGroup = formGroup;
	}

	public FormGroupAjaxValidationBehavior(
			String event,
			FormGroupValidatable<?, ?> formGroup,
			ThrottlingSettings throttlingSettings)
	{
		super(event);
		this.throttlingSettings = throttlingSettings;
		this.formGroup = formGroup;
	}

	@Override
	protected void onUpdate(AjaxRequestTarget target)
	{
		target.appendJavaScript(
				new JQueryScript(this.formGroup).addClass(ValidationState.SUCCESS.getClassString()).toString());
		target.appendJavaScript(
				new JQueryScript(this.formGroup).removeClass(ValidationState.ERROR.getClassString()).toString());
		target.add(this.formGroup.getHelpBlock());
	}

	@Override
	protected void onError(AjaxRequestTarget target, RuntimeException e)
	{
		super.onError(target, e);
		target.appendJavaScript(
				new JQueryScript(this.formGroup).removeClass(ValidationState.SUCCESS.getClassString()).toString());
		target.appendJavaScript(
				new JQueryScript(this.formGroup).addClass(ValidationState.ERROR.getClassString()).toString());
		target.add(this.formGroup.getHelpBlock());
	}

	@Override
	protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
	{
		super.updateAjaxAttributes(attributes);
		if (null != this.throttlingSettings) {
			attributes.setThrottlingSettings(this.throttlingSettings);
		}
	}

}
