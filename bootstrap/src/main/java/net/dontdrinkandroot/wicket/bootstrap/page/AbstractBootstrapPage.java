package net.dontdrinkandroot.wicket.bootstrap.page;

import net.dontdrinkandroot.wicket.bootstrap.css.BoostrapCssResourceReference;
import net.dontdrinkandroot.wicket.bootstrap.javascript.BootstrapResourceReference;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptReferenceHeaderItem;
import org.apache.wicket.markup.html.GenericWebPage;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public abstract class AbstractBootstrapPage<T> extends GenericWebPage<T> {

	public AbstractBootstrapPage() {

		super();
	}


	public AbstractBootstrapPage(PageParameters parameters) {

		super(parameters);
	}


	public AbstractBootstrapPage(IModel<T> model) {

		super(model);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new Label("pageTitle", this.getPageTitleModel()));
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);

		if (this.includeBootstrapJavaScript()) {

			JavaScriptReferenceHeaderItem bootstrapJsItem =
					JavaScriptHeaderItem.forReference(new BootstrapResourceReference(), "bootstrap");

			response.render(bootstrapJsItem);
		}

		if (this.includeBoostrapCss()) {
			response.render(CssHeaderItem.forReference(new BoostrapCssResourceReference()));
		}
	}


	protected boolean includeBootstrapJavaScript() {

		return true;
	}


	protected boolean includeBoostrapCss() {

		return true;
	}


	protected abstract IModel<String> getPageTitleModel();

}
