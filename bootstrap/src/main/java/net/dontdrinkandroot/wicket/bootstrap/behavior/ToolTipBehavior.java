package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;

import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.model.IModel;


public class ToolTipBehavior extends Behavior {

	private final IModel<String> textModel;

	private Position position;

	private Integer delay;


	public ToolTipBehavior(IModel<String> textModel) {

		this.textModel = textModel;
	}


	public ToolTipBehavior setDelay(Integer delay) {

		this.delay = delay;
		return this;
	}


	public ToolTipBehavior setPosition(Position position) {

		this.position = position;
		return this;
	}


	@Override
	public void onConfigure(Component component) {

		component.add(new AttributeModifier("title", this.textModel));
		component.add(new CssClassAppender("has-tooltip"));

		if (this.position != null) {
			component.add(new AttributeModifier("data-placement", this.position.name().toLowerCase()));
		}

		if (this.delay != null) {
			component.add(new AttributeModifier("data-delay", this.delay));
		}
	};


	@Override
	public void renderHead(Component component, IHeaderResponse response) {

		super.renderHead(component, response);

		response.render(OnDomReadyHeaderItem.forScript("$('.has-tooltip').tooltip();"));
	}


	public enum Position {
		TOP,
		BOTTOM,
		LEFT,
		RIGHT;
	}

}
