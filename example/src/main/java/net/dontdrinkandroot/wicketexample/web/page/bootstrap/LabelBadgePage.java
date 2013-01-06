package net.dontdrinkandroot.wicketexample.web.page.bootstrap;

import net.dontdrinkandroot.wicket.bootstrap.component.badge.DefaultBadge;
import net.dontdrinkandroot.wicket.bootstrap.component.badge.ImportantBadge;
import net.dontdrinkandroot.wicket.bootstrap.component.badge.InfoBadge;
import net.dontdrinkandroot.wicket.bootstrap.component.badge.InverseBadge;
import net.dontdrinkandroot.wicket.bootstrap.component.badge.SuccessBadge;
import net.dontdrinkandroot.wicket.bootstrap.component.badge.WarningBadge;
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

		this.add(new DefaultBadge("defaultBadge", Model.of("Default")));
		this.add(new InfoBadge("infoBadge", Model.of("Info")));
		this.add(new SuccessBadge("successBadge", Model.of("Success")));
		this.add(new WarningBadge("warningBadge", Model.of("Warning")));
		this.add(new InverseBadge("inverseBadge", Model.of("Inverse")));
		this.add(new ImportantBadge("importantBadge", Model.of("Important")));
	}


	@Override
	protected IModel<String> getPageTitleModel() {

		return new Model<String>("Label & Badge Demo");
	}

}
