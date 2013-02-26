package net.dontdrinkandroot.wicket.bootstrap.component.feedback;

import org.apache.wicket.Component;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.FencedFeedbackPanel;
import org.apache.wicket.feedback.IFeedbackMessageFilter;


public class InlineFencedFeedbackPanel extends FencedFeedbackPanel {

	public InlineFencedFeedbackPanel(String id) {

		super(id);
	}


	public InlineFencedFeedbackPanel(String id, Component fence) {

		super(id, fence);
	}


	public InlineFencedFeedbackPanel(String id, IFeedbackMessageFilter filter) {

		super(id, filter);
	}


	public InlineFencedFeedbackPanel(String id, Component fence, IFeedbackMessageFilter filter) {

		super(id, fence, filter);
	}


	@Override
	protected String getCSSClass(FeedbackMessage message) {

		return null;
	}

}
