package net.dontdrinkandroot.wicket.bootstrap.component.form;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.markup.html.form.Form;
import org.apache.wicket.markup.html.panel.GenericPanel;
import org.apache.wicket.markup.repeater.RepeatingView;
import org.apache.wicket.model.IModel;


public class ActionFormGroup<T> extends GenericPanel<T> {

	private WebMarkupContainer spaceHolder;

	private WebMarkupContainer actionContainer;


	public ActionFormGroup(String id) {

		super(id);
	}


	public ActionFormGroup(String id, IModel<T> model) {

		super(id, model);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new CssClassAppender(BootstrapCssClass.FORM_GROUP));
		this.spaceHolder = new WebMarkupContainer("spaceHolder");
		this.add(this.spaceHolder);

		this.actionContainer = new WebMarkupContainer("actionContainer");
		this.add(this.actionContainer);

		RepeatingView actionView = new RepeatingView("action");
		this.createActions(actionView);
		this.actionContainer.add(actionView);

		Form<?> form = this.getForm();
		if (form instanceof FormHorizontal) {
			this.spaceHolder.add(new CssClassAppender(((FormHorizontal<?>) form).getLabelColumnSize()));
			this.actionContainer.add(new CssClassAppender(((FormHorizontal<?>) form).getFormComponentColumnSize()));
		}
	}


	protected void createActions(RepeatingView actionView) {

	}


	public Form<?> getForm() {

		Form<?> form = Form.findForm(this);
		if (form == null) {
			throw new WicketRuntimeException("Could not find Form parent for " + this);
		}
		return form;
	}

}
