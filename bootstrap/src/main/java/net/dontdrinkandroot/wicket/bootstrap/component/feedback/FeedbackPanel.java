package net.dontdrinkandroot.wicket.bootstrap.component.feedback;

import java.io.Serializable;

import net.dontdrinkandroot.wicket.bootstrap.css.AlertStyle;
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


	@Override
	protected Component newMessageDisplayComponent(String id, FeedbackMessage message) {

		Serializable serializable = message.getMessage();
		Label label = new Label(id, serializable == null ? "" : serializable.toString());
		label.setEscapeModelStrings(this.getEscapeModelStrings());
		label.setOutputMarkupId(false);

		return label;
	}

}
