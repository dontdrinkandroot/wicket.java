package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.css.BadgeStyle;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class BadgeBehavior extends Behavior {

	private IModel<BadgeStyle> badgeStyleModel = new Model<BadgeStyle>();


	public BadgeBehavior() {

	}


	public BadgeBehavior(BadgeStyle labelStyle) {

		this.badgeStyleModel = Model.of(labelStyle);
	}


	public BadgeBehavior(IModel<BadgeStyle> labelStyleModel) {

		this.badgeStyleModel = labelStyleModel;
	}


	public BadgeStyle getBadgeStyle() {

		return this.badgeStyleModel.getObject();
	}


	protected IModel<BadgeStyle> getBadgeStyleModel() {

		return this.badgeStyleModel;
	}


	@Override
	public void bind(Component component) {

		super.bind(component);

		component.add(new CssClassAppender(BootstrapCssClass.BADGE));
		component.add(new CssClassAppender(this.getBadgeStyleModel()));
	}
}
