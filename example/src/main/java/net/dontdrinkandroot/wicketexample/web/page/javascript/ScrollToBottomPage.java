package net.dontdrinkandroot.wicketexample.web.page.javascript;

import net.dontdrinkandroot.wicket.behavior.ajax.ScrollToBottomBehavior;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.html.WebMarkupContainer;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class ScrollToBottomPage extends AbstractJavascriptPage<Void> {

	public ScrollToBottomPage(final PageParameters parameters) {

		super(parameters);
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		WebMarkupContainer scrollContainer = new WebMarkupContainer("scrollContainer");
		scrollContainer.setMarkupId("scrollContainer");
		scrollContainer.setOutputMarkupId(true);
		this.add(scrollContainer);

		this.add(new ScrollToBottomBehavior(0) {

			@Override
			protected void respond(AjaxRequestTarget target) {

				target.appendJavaScript("alert('hier')");
			}
		});
	}


	@Override
	public void renderHead(IHeaderResponse response) {

		super.renderHead(response);

		// response.render(CssHeaderItem.forCSS(
		// "#scrollContainer { height: 300px; overflow-y: scroll; };",
		// "scrollContainerStyle"));
	}

}
