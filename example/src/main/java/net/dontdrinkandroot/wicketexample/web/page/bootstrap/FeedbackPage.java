package net.dontdrinkandroot.wicketexample.web.page.bootstrap;

import net.dontdrinkandroot.wicket.javascript.JQueryScript;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class FeedbackPage extends AbstractBootstrapPage<Void> {

	public FeedbackPage(PageParameters parameters) {

		super(parameters);

		this.debug("Debug Message");
		this.info("Info Message");
		this.warn("Warning Message");
		this.error("Error Message");

		this.add(new AjaxLink<Void>("debug") {

			@Override
			public void onClick(AjaxRequestTarget target) {

				this.debug("Debug message");
				target.add(FeedbackPage.this.getFeedbackPanel());
				target.appendJavaScript(new JQueryScript(FeedbackPage.this.getFeedbackPanel()).fadeOut(5000, null, null).toString());
			}

		});

		this.add(new AjaxLink<Void>("info") {

			@Override
			public void onClick(AjaxRequestTarget target) {

				this.info("Info message");
				target.add(FeedbackPage.this.getFeedbackPanel());
				target.appendJavaScript(new JQueryScript(FeedbackPage.this.getFeedbackPanel()).fadeOut(5000, null, null).toString());
			}

		});

		this.add(new AjaxLink<Void>("warn") {

			@Override
			public void onClick(AjaxRequestTarget target) {

				this.warn("Warn message");
				target.add(FeedbackPage.this.getFeedbackPanel());
				target.appendJavaScript(new JQueryScript(FeedbackPage.this.getFeedbackPanel()).fadeOut(5000, null, null).toString());
			}

		});

		this.add(new AjaxLink<Void>("error") {

			@Override
			public void onClick(AjaxRequestTarget target) {

				this.error("Error message");
				target.add(FeedbackPage.this.getFeedbackPanel());
				target.appendJavaScript(new JQueryScript(FeedbackPage.this.getFeedbackPanel()).fadeOut(5000, null, null).toString());
			}

		});
	}
}
