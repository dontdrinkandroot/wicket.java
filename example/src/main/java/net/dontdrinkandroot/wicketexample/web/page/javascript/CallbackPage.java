package net.dontdrinkandroot.wicketexample.web.page.javascript;

import org.apache.wicket.ajax.AbstractDefaultAjaxBehavior;
import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.behavior.AttributeAppender;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class CallbackPage extends AbstractJavascriptPage<Void> {

	public CallbackPage(final PageParameters parameters) {

		super(parameters);

		final Label label = new Label("label", "Click me to call wicket!");
		label.setOutputMarkupId(true);

		WebMarkupContainer callBackItem = new WebMarkupContainer("callBackItem");
		callBackItem.setOutputMarkupId(true);
		callBackItem.add(label);

		final AbstractDefaultAjaxBehavior callBackBehaviour = new AbstractDefaultAjaxBehavior() {

			@Override
			protected void respond(final AjaxRequestTarget target) {

				label.setDefaultModel(new Model<String>("Yeah I was just called from Javascript!"));
				target.add(label);
			}
		};
		callBackItem.add(callBackBehaviour);

		callBackItem.add(new AttributeAppender("onclick", new Model<String>() {

			@Override
			public String getObject() {

				return callBackBehaviour.getCallbackScript().toString();
			}
		}, ""));

		this.add(callBackItem);
	}

}
