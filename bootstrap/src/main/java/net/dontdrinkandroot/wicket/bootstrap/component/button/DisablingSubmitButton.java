package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;


public abstract class DisablingSubmitButton extends AjaxSubmitLink
{

	protected ButtonBehavior buttonBehavior = new ButtonBehavior();

	private IModel<String> loadingTextModel = new Model<String>("Submitting...");


	public DisablingSubmitButton(String id)
	{
		super(id);
	}

	public DisablingSubmitButton(String id, IModel<String> loadingTextModel)
	{
		super(id);
		this.loadingTextModel = loadingTextModel;
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new AttributeModifier("data-loading-text", this.getLoadingTextModel()));
		this.add(this.getButtonBehavior());
	}

	@Override
	protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
	{
		super.updateAjaxAttributes(attributes);

		attributes.getAjaxCallListeners().add(new AjaxCallListener() {

			@Override
			public CharSequence getBeforeHandler(Component component)
			{
				return "console.log(attrs)";
			}

			@Override
			public CharSequence getAfterHandler(Component component)
			{
				StringBuffer sb = new StringBuffer();
				sb.append("$('#" + DisablingSubmitButton.this.getMarkupId() + "').button('loading');");
				sb.append("$('#"
						+ DisablingSubmitButton.this.getForm().getMarkupId()
						+ " input').attr('disabled', 'disabled');");
				sb.append("$('#"
						+ DisablingSubmitButton.this.getForm().getMarkupId()
						+ " textarea').attr('disabled', 'disabled');");
				sb.append("$('#"
						+ DisablingSubmitButton.this.getForm().getMarkupId()
						+ " select').attr('disabled', 'disabled');");

				return sb.toString();
			}

			@Override
			public CharSequence getCompleteHandler(Component component)
			{
				StringBuffer sb = new StringBuffer();
				sb.append("$('#" + DisablingSubmitButton.this.getMarkupId() + "').button('reset');");
				sb.append("$('#"
						+ DisablingSubmitButton.this.getForm().getMarkupId()
						+ " input').removeAttr('disabled');");
				sb.append("$('#"
						+ DisablingSubmitButton.this.getForm().getMarkupId()
						+ " textarea').removeAttr('disabled');");
				sb.append("$('#"
						+ DisablingSubmitButton.this.getForm().getMarkupId()
						+ " select').removeAttr('disabled');");

				return sb.toString();
			}
		});
	}

	public ButtonBehavior getButtonBehavior()
	{
		return this.buttonBehavior;
	}

	public IModel<String> getLoadingTextModel()
	{
		return this.loadingTextModel;
	}

}
