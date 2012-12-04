package net.dontdrinkandroot.wicketexample.web.page.bootstrap;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class ProgressPage extends AbstractBootstrapPage<Void> {

	public ProgressPage(PageParameters parameters) {

		super(parameters);
	}


	@Override
	protected IModel<String> getPageTitleModel() {

		return new Model<String>("Progress Bar Demo");
	}

}
