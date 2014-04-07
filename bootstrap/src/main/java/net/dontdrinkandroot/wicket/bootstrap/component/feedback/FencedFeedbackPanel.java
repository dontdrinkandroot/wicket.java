package net.dontdrinkandroot.wicket.bootstrap.component.feedback;

import java.io.Serializable;

import net.dontdrinkandroot.wicket.bootstrap.css.AlertStyle;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.css.CssClass;

import org.apache.wicket.Component;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.feedback.IFeedbackMessageFilter;
import org.apache.wicket.markup.html.basic.Label;


public class FencedFeedbackPanel extends org.apache.wicket.feedback.FencedFeedbackPanel {

	public FencedFeedbackPanel(String id) {

		super(id);
	}


	public FencedFeedbackPanel(String id, Component fence) {

		super(id, fence);
	}


	public FencedFeedbackPanel(String id, IFeedbackMessageFilter filter) {

		super(id, filter);
	}


	public FencedFeedbackPanel(String id, Component fence, IFeedbackMessageFilter filter) {

		super(id, fence, filter);
	}


	@Override
	protected String getCSSClass(FeedbackMessage message) {

		int level = message.getLevel();
		CssClass cssClass = this.getClassFromLevel(level);

		String cssString = BootstrapCssClass.ALERT.getClassString();

		if (cssClass != null) {
			cssString += " " + cssClass.getClassString();
		}

		return cssString;
	}


	@Override
	protected Component newMessageDisplayComponent(String id, FeedbackMessage message) {

		Serializable serializable = message.getMessage();
		Label label = new Label(id, serializable == null ? "" : serializable.toString());
		label.setEscapeModelStrings(this.getEscapeModelStrings());
		label.setOutputMarkupId(false);

		return label;
	}


	protected CssClass getClassFromLevel(int level) {

		switch (level) {

			case FeedbackMessage.WARNING:
			case FeedbackMessage.DEBUG:
				return AlertStyle.WARNING;

			case FeedbackMessage.SUCCESS:
				return AlertStyle.SUCCESS;

			case FeedbackMessage.INFO:
				return AlertStyle.INFO;

			case FeedbackMessage.ERROR:
			case FeedbackMessage.FATAL:
				return AlertStyle.DANGER;
		}

		return null;
	}

}
