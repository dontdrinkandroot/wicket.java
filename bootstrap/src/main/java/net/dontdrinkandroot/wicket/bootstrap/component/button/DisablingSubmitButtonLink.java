/***Copyright(C)2012-2014 Philip W.Sorst<philip @sorst.net>*and individual contributors as indicated*by the @authors tag.**Licensed under the Apache License,Version 2.0(the"License");*you may not use this file except in compliance with the License.*You may obtain a copy of the License at**http://www.apache.org/licenses/LICENSE-2.0
**Unless required by applicable law or agreed to in writing,software*distributed under the License is distributed on an"AS IS"BASIS,*WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,either express or implied.*See the License for the specific language governing permissions and*limitations under the License.*/
package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.ajax.markup.html.form.AjaxSubmitLink;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;


public abstract class DisablingSubmitButtonLink extends AjaxSubmitLink
{

	private IModel<String> loadingTextModel = new Model<String>("Submitting...");

	private ButtonBehavior buttonBehavior;


	public DisablingSubmitButtonLink(String id)
	{
		super(id);
		this.buttonBehavior = new ButtonBehavior();
		this.add(this.getButtonBehavior());
	}

	@Override
	protected void onInitialize()
	{
		super.onInitialize();

		this.add(new AttributeModifier("data-loading-text", this.getLoadingTextModel()));
	}

	@Override
	protected void updateAjaxAttributes(AjaxRequestAttributes attributes)
	{
		super.updateAjaxAttributes(attributes);

		attributes.getAjaxCallListeners().add(new AjaxCallListener() {

			@Override
			public CharSequence getAfterHandler(Component component)
			{
				StringBuffer sb = new StringBuffer();
				sb.append("$('#" + DisablingSubmitButtonLink.this.getMarkupId() + "').button('loading');");
				sb.append("$('#"
						+ DisablingSubmitButtonLink.this.getForm().getMarkupId()
						+ " input').attr('disabled', 'disabled');");
				sb.append("$('#"
						+ DisablingSubmitButtonLink.this.getForm().getMarkupId()
						+ " textarea').attr('disabled', 'disabled');");
				sb.append("$('#"
						+ DisablingSubmitButtonLink.this.getForm().getMarkupId()
						+ " select').attr('disabled', 'disabled');");

				return sb.toString();
			}

			@Override
			public CharSequence getCompleteHandler(Component component)
			{
				StringBuffer sb = new StringBuffer();
				sb.append("$('#" + DisablingSubmitButtonLink.this.getMarkupId() + "').button('reset');");
				sb.append("$('#"
						+ DisablingSubmitButtonLink.this.getForm().getMarkupId()
						+ " input').removeAttr('disabled');");
				sb.append("$('#"
						+ DisablingSubmitButtonLink.this.getForm().getMarkupId()
						+ " textarea').removeAttr('disabled');");
				sb.append("$('#"
						+ DisablingSubmitButtonLink.this.getForm().getMarkupId()
						+ " select').removeAttr('disabled');");

				return sb.toString();
			}
		});
	}

	public IModel<String> getLoadingTextModel()
	{
		return this.loadingTextModel;
	}

	public void setLoadingTextModel(IModel<String> loadingTextModel)
	{
		this.loadingTextModel = loadingTextModel;
	}

	public ButtonBehavior getButtonBehavior()
	{
		return this.buttonBehavior;
	}

}
