package net.dontdrinkandroot.wicketexample.web.page.event;

import net.dontdrinkandroot.wicketexample.web.page.DecoratorWidePage;

import org.apache.wicket.ajax.AjaxRequestTarget;
import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.event.Broadcast;
import org.apache.wicket.event.IEvent;
import org.apache.wicket.markup.html.panel.FeedbackPanel;
import org.apache.wicket.request.mapper.parameter.PageParameters;


public class EventPage extends DecoratorWidePage<Void> {

	public EventPage(PageParameters parameters) {

		super(parameters);

		final FeedbackPanel feedbackPanel = new FeedbackPanel("eventFeedbackPanel") {

			int count = 0;


			@Override
			public void onEvent(IEvent<?> event) {

				System.out.println(event.getSource());

				if (event.getPayload() instanceof AjaxRequestTarget) {
					this.info(this.count++ + " times clicked");
					AjaxRequestTarget target = (AjaxRequestTarget) event.getPayload();
					target.add(this);
				}
			}
		};
		feedbackPanel.setOutputMarkupId(true);
		this.add(feedbackPanel);

		AjaxLink<Void> eventLink = new AjaxLink<Void>("eventLink") {

			@Override
			public void onClick(AjaxRequestTarget target) {

				this.send(feedbackPanel, Broadcast.EXACT, target);
			}
		};
		this.add(eventLink);

	}

}
