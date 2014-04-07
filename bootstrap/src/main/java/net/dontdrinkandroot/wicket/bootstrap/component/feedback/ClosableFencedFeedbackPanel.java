package net.dontdrinkandroot.wicket.bootstrap.component.feedback;

import org.apache.wicket.Component;
import org.apache.wicket.feedback.IFeedbackMessageFilter;


public class ClosableFencedFeedbackPanel extends FencedFeedbackPanel {

	public ClosableFencedFeedbackPanel(String id) {

		super(id);
	}


	public ClosableFencedFeedbackPanel(String id, Component fence) {

		super(id, fence);
	}


	public ClosableFencedFeedbackPanel(String id, IFeedbackMessageFilter filter) {

		super(id, filter);
	}


	public ClosableFencedFeedbackPanel(String id, Component fence, IFeedbackMessageFilter filter) {

		super(id, fence, filter);
	}
}
