package net.dontdrinkandroot.wicketexample.web.component.bootstrap;

import net.dontdrinkandroot.wicket.bootstrap.component.button.DisablingSubmitButtonLink;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.GenericPanel;


public class FormDemo extends GenericPanel<Void> {

	public FormDemo(String id) {

		super(id);

		Form<Void> disablingSubmitForm = new Form<Void>("disablingSubmitForm");
		disablingSubmitForm.setOutputMarkupId(true);
		this.add(disablingSubmitForm);

		DisablingSubmitButtonLink<Void> submitLink = new DisablingSubmitButtonLink<Void>("submitLink") {

			@Override
			protected void onSubmit(AjaxRequestTarget target, Form<?> form) {

				try {
					Thread.sleep(2000L);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		};
		submitLink.setButtonStyle(ButtonStyle.PRIMARY);
		disablingSubmitForm.add(submitLink);
	}
}
