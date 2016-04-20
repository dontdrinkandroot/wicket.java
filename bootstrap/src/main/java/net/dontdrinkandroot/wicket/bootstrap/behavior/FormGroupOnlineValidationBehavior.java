package net.dontdrinkandroot.wicket.bootstrap.behavior;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.attributes.ThrottlingSettings;
import org.apache.wicket.ajax.form.AjaxFormComponentUpdatingBehavior;

import net.dontdrinkandroot.wicket.bootstrap.component.form.formgroup.AbstractFormGroup;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.javascript.JQueryScript;


public class FormGroupOnlineValidationBehavior extends AjaxFormComponentUpdatingBehavior
{

	private ThrottlingSettings throttlingSettings;

	private AbstractFormGroup<?, ?> formGroup;


	public FormGroupOnlineValidationBehavior(String event, AbstractFormGroup<?, ?> formGroup)
	{
		super(event);
		this.formGroup = formGroup;
	}

	public FormGroupOnlineValidationBehavior(
			String event,
			AbstractFormGroup<?, ?> formGroup,
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
				new JQueryScript(this.formGroup).addClass(BootstrapCssClass.HAS_SUCCESS.getClassString()).toString());
		target.appendJavaScript(
				new JQueryScript(this.formGroup).removeClass(BootstrapCssClass.HAS_ERROR.getClassString()).toString());
		target.add(this.formGroup.getHelpBlock());
	}

	@Override
	protected void onError(AjaxRequestTarget target, RuntimeException e)
	{
		super.onError(target, e);
		target.appendJavaScript(
				new JQueryScript(this.formGroup).removeClass(
						BootstrapCssClass.HAS_SUCCESS.getClassString()).toString());
		target.appendJavaScript(
				new JQueryScript(this.formGroup).addClass(BootstrapCssClass.HAS_ERROR.getClassString()).toString());
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
