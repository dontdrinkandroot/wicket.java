package net.dontdrinkandroot.wicket.bootstrap.component.button;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.ajax.attributes.AjaxCallListener;
import org.apache.wicket.ajax.attributes.AjaxRequestAttributes;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public abstract class DisablingSubmitButtonLink<T> extends AjaxSubmitButtonLink<T> {

	private final IModel<String> loadingTextModel = new Model<String>("Submitting...");


	public DisablingSubmitButtonLink(String id) {

		super(id);
	}


	public DisablingSubmitButtonLink(String id, IModel<T> model, String label) {

		this(id, model, new Model<String>(label));
	}


	public DisablingSubmitButtonLink(String id, IModel<T> model, IModel<String> labelModel) {

		super(id, model, labelModel);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new AttributeModifier("data-loading-text", this.loadingTextModel));
	}


	@Override
	protected void updateAjaxAttributes(AjaxRequestAttributes attributes) {

		super.updateAjaxAttributes(attributes);
		attributes.getAjaxCallListeners().add(new AjaxCallListener() {

			@Override
			public CharSequence getBeforeHandler(Component component) {

				return "console.log('beforeHandler');";
			}


			@Override
			public CharSequence getPrecondition(Component component) {

				return "console.log('precondition');";
			}


			@Override
			public CharSequence getAfterHandler(Component component) {

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
			public CharSequence getSuccessHandler(Component component) {

				return "console.log('successHandler');";
			}


			@Override
			public CharSequence getFailureHandler(Component component) {

				return "console.log('failureHandler');";
			}


			@Override
			public CharSequence getCompleteHandler(Component component) {

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

	// @Override
	// protected IAjaxCallDecorator getAjaxCallDecorator() {
	//
	// return new AjaxCallDecorator() {
	//
	// @Override
	// public CharSequence decorateScript(Component c, CharSequence script) {
	//
	// StringBuffer sb = new StringBuffer();
	// sb.append("$('#" + DisablingSubmitButtonLink.this.getMarkupId() +
	// "').attr('disabled', 'disabled');");
	//
	// // sb.append("$('#"
	// // + DisablingSubmitButtonLink.this.getForm().getMarkupId()
	// // + " input').attr('disabled', 'disabled');");
	// // sb.append("$('#"
	// // + DisablingSubmitButtonLink.this.getForm().getMarkupId()
	// // + " textarea').attr('disabled', 'disabled');");
	// // sb.append("$('#"
	// // + DisablingSubmitButtonLink.this.getForm().getMarkupId()
	// // + " select').attr('disabled', 'disabled');");
	// //
	// return sb.toString() + script;
	// }
	//
	//
	// @Override
	// public CharSequence decorateOnFailureScript(Component c, CharSequence script) {
	//
	// StringBuffer sb = new StringBuffer();
	// sb.append("$('#" + DisablingSubmitButtonLink.this.getMarkupId() +
	// "').removeAttr('disabled');");
	//
	// // sb.append("$('#"
	// // + DisablingSubmitButtonLink.this.getForm().getMarkupId()
	// // + " input').removeAttr('disabled');");
	// // sb.append("$('#"
	// // + DisablingSubmitButtonLink.this.getForm().getMarkupId()
	// // + " textarea').removeAttr('disabled');");
	// // sb.append("$('#"
	// // + DisablingSubmitButtonLink.this.getForm().getMarkupId()
	// // + " select').removeAttr('disabled');");
	// //
	// return sb.toString() + script;
	// }
	//
	//
	// @Override
	// public CharSequence decorateOnSuccessScript(Component c, CharSequence script) {
	//
	// StringBuffer sb = new StringBuffer();
	// sb.append("$('#" + DisablingSubmitButtonLink.this.getMarkupId() +
	// "').removeAttr('disabled');");
	//
	// // sb.append("$('#"
	// // + DisablingSubmitButtonLink.this.getForm().getMarkupId()
	// // + " input').removeAttr('disabled');");
	// // sb.append("$('#"
	// // + DisablingSubmitButtonLink.this.getForm().getMarkupId()
	// // + " textarea').removeAttr('disabled');");
	// // sb.append("$('#"
	// // + DisablingSubmitButtonLink.this.getForm().getMarkupId()
	// // + " select').removeAttr('disabled');");
	// //
	// return sb.toString() + script;
	// }
	// };
	// }

}
