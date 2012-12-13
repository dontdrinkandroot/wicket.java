package net.dontdrinkandroot.wicketexample.web.page.bootstrap;

import net.dontdrinkandroot.wicket.bootstrap.component.label.DefaultLabel;
import net.dontdrinkandroot.wicket.bootstrap.component.label.ImportantLabel;
import net.dontdrinkandroot.wicket.bootstrap.component.label.InfoLabel;
import net.dontdrinkandroot.wicket.bootstrap.component.label.InverseLabel;
import net.dontdrinkandroot.wicket.bootstrap.component.label.SuccessLabel;
import net.dontdrinkandroot.wicket.bootstrap.component.label.WarningLabel;

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class LabelBadgePage extends AbstractBootstrapPage<Void> {

	public LabelBadgePage(PageParameters parameters) {

		super(parameters);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new DefaultLabel("defaultLabel", Model.of("Default")));
		this.add(new InfoLabel("infoLabel", Model.of("Info")));
		this.add(new SuccessLabel("successLabel", Model.of("Success")));
		this.add(new WarningLabel("warningLabel", Model.of("Warning")));
		this.add(new InverseLabel("inverseLabel", Model.of("Inverse")));
		this.add(new ImportantLabel("importantLabel", Model.of("Important")));
	}


	@Override
	protected IModel<String> getPageTitleModel() {

		return new Model<String>("Label & Badge Demo");
	}

}
