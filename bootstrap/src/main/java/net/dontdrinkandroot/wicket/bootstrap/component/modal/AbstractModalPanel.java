package net.dontdrinkandroot.wicket.bootstrap.component.modal;

import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;


public abstract class AbstractModalPanel<T> extends AbstractBaseModalPanel<T> {

	public AbstractModalPanel(String id) {

		super(id);
	}


	public AbstractModalPanel(String id, IModel<T> model) {

		super(id, model);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new Label("heading", this.createHeadingModel()));
		this.add(this.createBody("body"));
		this.add(this.createFooter("footer"));
	}

}
