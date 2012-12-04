package net.dontdrinkandroot.wicket.bootstrap.page;

import net.dontdrinkandroot.wicket.bootstrap.css.BoostrapResponsiveCssResourceReference;

import org.apache.wicket.markup.head.CssHeaderItem;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.StringHeaderItem;
import org.apache.wicket.model.IModel;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public abstract class ResponsiveBootstrapPage<T> extends AbstractBootstrapPage<T> {

	public ResponsiveBootstrapPage() {

		super();
	}


	public ResponsiveBootstrapPage(PageParameters parameters) {

		super(parameters);
	}


	public ResponsiveBootstrapPage(IModel<T> model) {

		super(model);
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);

		response.render(StringHeaderItem.forString("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />\n"));
		if (this.includeBoostrapCss()) {
			response.render(CssHeaderItem.forReference(new BoostrapResponsiveCssResourceReference()));
		}
	}
}
