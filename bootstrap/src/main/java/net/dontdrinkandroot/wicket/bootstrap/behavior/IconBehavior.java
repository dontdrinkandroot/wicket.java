package net.dontdrinkandroot.wicket.bootstrap.behavior;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.dontdrinkandroot.wicket.bootstrap.css.InvertibleIconClass;

import org.apache.wicket.Component;
import org.apache.wicket.WicketRuntimeException;
import org.apache.wicket.markup.transformer.AbstractTransformerBehavior;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.util.string.Strings;


/**
 * Prepends and/or appends an Icon to the body of the attached component. Icons are specified by an
 * {@link InvertibleIconClass}.
 * 
 * @author Philip W. Sorst <philip@sorst.net>
 */
public class IconBehavior extends AbstractTransformerBehavior {

	/** Pattern that matches openclose tags and is able to extract the open tag, body and close tag. */
	private final static Pattern PATTERN = Pattern.compile("(<.*?>)(.*)(</.*?>)", Pattern.DOTALL);

	private IModel<InvertibleIconClass> prependIconModel;

	private IModel<InvertibleIconClass> appendIconModel;


	/**
	 * Create an IconBehavior that does not add any Icon initially.
	 */
	public IconBehavior() {

		/* Noop */
	}


	/**
	 * Creates an IconBehavior that prepends the given icon.
	 */
	public IconBehavior(IModel<InvertibleIconClass> beforeIconModel) {

		this.prependIconModel = beforeIconModel;
	}


	/**
	 * Creates an IconBehavior that prepends the given icon.
	 */
	public IconBehavior(InvertibleIconClass beforeIcon) {

		this.setPrependIcon(beforeIcon);
	}


	@Override
	public CharSequence transform(Component component, CharSequence output) throws Exception {

		boolean hasPrependIcon = this.getPrependIconModel() != null && this.getPrependIconModel().getObject() != null;
		boolean hasAppendIcon = this.getAppendIconModel() != null && this.getAppendIconModel().getObject() != null;

		/* Abort early if no icon is requested */
		if (!hasPrependIcon && !hasAppendIcon) {
			return output;
		}

		/*
		 * Fail if there if the component does not have a body and therefore is a single tag (e.g.
		 * <input />)
		 */
		Matcher matcher = IconBehavior.PATTERN.matcher(output);
		if (!matcher.matches()) {
			throw new WicketRuntimeException(String.format(
					"IconBehavior applied to a component that does not have a body: %s",
					output));
		}

		/* Extract the parts */
		String openTag = matcher.group(1);
		String body = matcher.group(2);
		String closeTag = matcher.group(3);
		boolean bodyIsEmpty = Strings.isEmpty(body);

		StringBuffer outputBuffer = new StringBuffer(openTag);

		/* Prepend icon if requested */
		if (hasPrependIcon) {
			outputBuffer.append(this.renderIcon(this.getPrependIconModel()));
			if (!bodyIsEmpty || hasAppendIcon) {
				outputBuffer.append(" ");
			}
		}

		outputBuffer.append(body);

		/* Append icon if requested */
		if (hasAppendIcon) {
			if (!bodyIsEmpty) {
				outputBuffer.append(" ");
			}
			outputBuffer.append(this.renderIcon(this.getAppendIconModel()));
		}

		outputBuffer.append(closeTag);

		return outputBuffer;
	}


	/**
	 * Get the iocn to prepend if set or null.
	 */
	public InvertibleIconClass getPrependIcon() {

		if (this.prependIconModel == null) {
			return null;
		}
		return this.getPrependIconModel().getObject();
	}


	/**
	 * Get the icon to append if set or null.
	 */
	public InvertibleIconClass getAppendIcon() {

		if (this.appendIconModel == null) {
			return null;
		}
		return this.getAppendIconModel().getObject();
	}


	/**
	 * Set the icon to prepend, if it is null no icon will be prepended.
	 */
	public IconBehavior setPrependIcon(InvertibleIconClass beforeIcon) {

		if (beforeIcon == null) {
			this.prependIconModel = null;
			return this;
		}

		if (this.prependIconModel == null) {
			this.prependIconModel = Model.of(beforeIcon);
		} else {
			this.prependIconModel.setObject(beforeIcon);
		}

		return this;
	}


	/**
	 * Set the icon to append, if it is null no icon will be appended.
	 */
	public IconBehavior setAppendIcon(InvertibleIconClass afterIcon) {

		if (afterIcon == null) {
			this.appendIconModel = null;
			return this;
		}

		if (this.appendIconModel == null) {
			this.appendIconModel = Model.of(afterIcon);
		} else {
			this.appendIconModel.setObject(afterIcon);
		}

		return this;
	}


	/**
	 * Set the model of the icon to prepend, if it or its object is null no icon will be prepended.
	 */
	public IconBehavior setPrependIconModel(IModel<InvertibleIconClass> prependIconModel) {

		this.prependIconModel = prependIconModel;
		return this;
	}


	/**
	 * Set the model of the icon to append, if it or its object is null no icon will be prepended.
	 */
	public IconBehavior setAppendIconModel(IModel<InvertibleIconClass> appendIconModel) {

		this.appendIconModel = appendIconModel;
		return this;
	}


	/**
	 * Get the model of the icon to prepend.
	 */
	protected IModel<InvertibleIconClass> getPrependIconModel() {

		return this.prependIconModel;
	}


	/**
	 * Get the model of the icon to append.
	 */
	protected IModel<InvertibleIconClass> getAppendIconModel() {

		return this.appendIconModel;
	}


	/**
	 * Transforms an {@link InvertibleIconClass} Model into an italic tag String with the
	 * corresponding class attributes.
	 */
	protected String renderIcon(IModel<InvertibleIconClass> iconModel) {

		return String.format("<i class=\"%s\"></i>", iconModel.getObject().getClassString());
	}
}
