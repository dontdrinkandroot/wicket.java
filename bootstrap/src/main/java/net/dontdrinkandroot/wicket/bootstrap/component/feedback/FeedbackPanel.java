package net.dontdrinkandroot.wicket.bootstrap.component.feedback;

import java.io.Serializable;

import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import net.dontdrinkandroot.wicket.css.CssClass;

import org.apache.wicket.Component;
import org.apache.wicket.feedback.FeedbackMessage;
import org.apache.wicket.markup.html.basic.Label;


public class FeedbackPanel extends org.apache.wicket.markup.html.panel.FeedbackPanel {

	public FeedbackPanel(String id) {

		super(id);
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


	protected CssClass getClassFromLevel(int level) {

		switch (level) {

			case FeedbackMessage.WARNING:
			case FeedbackMessage.DEBUG:
				break;

			case FeedbackMessage.SUCCESS:
				return BootstrapCssClass.ALERT_SUCCESS;

			case FeedbackMessage.INFO:
				return BootstrapCssClass.ALERT_INFO;

			case FeedbackMessage.ERROR:
			case FeedbackMessage.FATAL:
				return BootstrapCssClass.ALERT_ERROR;
		}

		return null;
	}


	@Override
	protected Component newMessageDisplayComponent(String id, FeedbackMessage message) {

		Serializable serializable = message.getMessage();
		Label label = new Label(id, serializable == null ? "" : serializable.toString());
		label.setEscapeModelStrings(this.getEscapeModelStrings());
		label.setOutputMarkupId(false);

		return label;
	}

}
