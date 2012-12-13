package net.dontdrinkandroot.wicket.bootstrap.component.button;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.behavior.ButtonBehavior;
import net.dontdrinkandroot.wicket.bootstrap.behavior.DisabledCssBehavior;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonSize;
import net.dontdrinkandroot.wicket.bootstrap.css.ButtonStyle;
import net.dontdrinkandroot.wicket.component.TypedWebMarkupContainer;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.model.AbstractReadOnlyModel;
import org.apache.wicket.model.IModel;


public class AbstractButtonLink<T> extends TypedWebMarkupContainer<T> {

	private IModel<String> labelModel;

	private ButtonStyle buttonStyle;

	private ButtonSize buttonSize;


	public AbstractButtonLink(String id) {

		super(id);
	}


	public AbstractButtonLink(String id, IModel<T> model) {

		super(id, model);
	}


	public AbstractButtonLink(String id, IModel<T> model, IModel<String> labelModel) {

		super(id, model);

		this.labelModel = labelModel;
	}


	public AbstractButtonLink<T> setButtonStyle(ButtonStyle buttonStyle) {

		this.buttonStyle = buttonStyle;
		return this;
	}


	public AbstractButtonLink<T> setButtonSize(ButtonSize buttonSize) {

		this.buttonSize = buttonSize;
		return this;
	}


	@Override
	protected void onInitialize() {

		super.onInitialize();

		this.add(new ButtonBehavior());
		this.add(new CssClassAppender(this.getButtonStyleModel()));
		this.add(new CssClassAppender(this.getButtonSizeModel()));
		this.add(new DisabledCssBehavior());
	}


	protected IModel<ButtonStyle> getButtonStyleModel() {

		return new AbstractReadOnlyModel<ButtonStyle>() {

			@Override
			public ButtonStyle getObject() {

				return AbstractButtonLink.this.buttonStyle;
			}
		};
	}


	protected IModel<ButtonSize> getButtonSizeModel() {

		return new AbstractReadOnlyModel<ButtonSize>() {

			@Override
			public ButtonSize getObject() {

				return AbstractButtonLink.this.buttonSize;
			}
		};
	}


	/**
	 * Helper methods that both checks whether the link is enabled and whether the action ENABLE is
	 * allowed.
	 * 
	 * @return whether the link should be rendered as enabled
	 */
	protected boolean isLinkEnabled() {

		return this.isEnabledInHierarchy();
	}


	@Override
	protected void onComponentTag(ComponentTag tag) {

		super.onComponentTag(tag);

		/* Set value to label if input */
		if (tag.getName().equalsIgnoreCase("input") && this.labelModel != null) {
			tag.put("value", this.labelModel.getObject());
		}
	}


	@Override
	public void onComponentTagBody(MarkupStream markupStream, ComponentTag openTag) {

		super.onComponentTagBody(markupStream, openTag);

		/* Set body to label if a */
		if (this.labelModel != null
				&& (openTag.getName().equalsIgnoreCase("a") || openTag.getName().equalsIgnoreCase("button"))) {
			this.replaceComponentTagBody(markupStream, openTag, this.labelModel.getObject());
		}
	}


	protected void disableLink(final ComponentTag tag) {

		/* if the tag is an anchor proper */
		if (tag.getName().equalsIgnoreCase("a")
				|| tag.getName().equalsIgnoreCase("link")
				|| tag.getName().equalsIgnoreCase("area")) {

			/* Remove any href from the old link */
			tag.remove("href");

			/* Remove onclick from the old link */
			tag.remove("onclick");
		}

		/* if the tag is a button or input */
		else if ("button".equalsIgnoreCase(tag.getName()) || "input".equalsIgnoreCase(tag.getName())) {
			tag.put("disabled", "disabled");
		}
	}

}
