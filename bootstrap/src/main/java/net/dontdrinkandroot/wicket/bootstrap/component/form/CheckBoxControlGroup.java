package net.dontdrinkandroot.wicket.bootstrap.component.form;

import org.apache.wicket.markup.html.form.CheckBox;
import org.apache.wicket.model.IModel;


public class CheckBoxControlGroup extends AbstractControlGroup<Boolean, CheckBox> {

	public CheckBoxControlGroup(String id, IModel<Boolean> model, String label) {

		super(id, model, label);
	}


	public CheckBoxControlGroup(String id, IModel<Boolean> model, IModel<String> labelModel) {

		super(id, model, labelModel);
	}


	@Override
	protected CheckBox createFormComponent(String id) {

		return new CheckBox(id, this.getModel());
	}

}
