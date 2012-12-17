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
 * Prepends and/or appends an Icon to the body of the attached component.
 */
public class IconBehavior extends AbstractTransformerBehavior {

	private final static Pattern PATTERN = Pattern.compile("(<.*?>)(.*)(</.*?>)", Pattern.DOTALL);

	private IModel<InvertibleIconClass> beforeIconModel;

	private IModel<InvertibleIconClass> afterIconModel;


	public IconBehavior() {

	}


	public IconBehavior(IModel<InvertibleIconClass> beforeIconModel) {

		this.beforeIconModel = beforeIconModel;
	}


	public IconBehavior(InvertibleIconClass beforeIcon) {

		this.setBeforeIcon(beforeIcon);
	}


	@Override
	public CharSequence transform(Component component, CharSequence output) throws Exception {

		boolean hasBeforeIcon = this.getBeforeIconModel() != null && this.getBeforeIconModel().getObject() != null;
		boolean hasAfterIcon = this.getAfterIconModel() != null && this.getAfterIconModel().getObject() != null;

		/* Abort early if no icon is requested */
		if (!hasBeforeIcon && !hasAfterIcon) {
			return output;
		}

		Matcher matcher = IconBehavior.PATTERN.matcher(output);
		if (!matcher.matches()) {
			throw new WicketRuntimeException(String.format(
					"IconBehavior applied to a component that does not have a body: %s",
					output));
		}

		String open = matcher.group(1);
		String body = matcher.group(2);
		String close = matcher.group(3);

		boolean isBodyEmpty = Strings.isEmpty(body);

		StringBuffer before = new StringBuffer();
		if (this.getBeforeIconModel() != null && this.getBeforeIconModel().getObject() != null) {
			before.append("<i class=\"");
			before.append(this.getBeforeIconModel().getObject().getClassString());
			before.append("\">");
			before.append("</i>");
			if (!isBodyEmpty || hasAfterIcon) {
				before.append(" ");
			}
		}

		StringBuffer after = new StringBuffer();
		if (this.getAfterIconModel() != null && this.getAfterIconModel().getObject() != null) {
			if (!isBodyEmpty) {
				after.append(" ");
			}
			after.append("<i class=\"");
			after.append(this.getAfterIconModel().getObject().getClassString());
			after.append("\">");
			after.append("</i>");
		}

		return new StringBuffer(open).append(before).append(body).append(after).append(close);
	}


	public InvertibleIconClass getBeforeIcon() {

		return this.getBeforeIconModel().getObject();
	}


	public IconBehavior setBeforeIcon(InvertibleIconClass beforeIcon) {

		if (beforeIcon == null) {
			this.beforeIconModel = null;
			return this;
		}

		if (this.beforeIconModel == null) {
			this.beforeIconModel = Model.of(beforeIcon);
		} else {
			this.beforeIconModel.setObject(beforeIcon);
		}

		return this;
	}


	public IconBehavior setBeforeIconModel(IModel<InvertibleIconClass> beforeIconModel) {

		this.beforeIconModel = beforeIconModel;

		return this;
	}


	public InvertibleIconClass getAfterIcon() {

		return this.getAfterIconModel().getObject();
	}


	public IconBehavior setAfterIcon(InvertibleIconClass afterIcon) {

		if (afterIcon == null) {
			this.afterIconModel = null;
			return this;
		}

		if (this.afterIconModel == null) {
			this.afterIconModel = Model.of(afterIcon);
		} else {
			this.afterIconModel.setObject(afterIcon);
		}

		return this;
	}


	public void setAfterIconModel(IModel<InvertibleIconClass> afterIconModel) {

		this.afterIconModel = afterIconModel;
	}


	protected IModel<InvertibleIconClass> getBeforeIconModel() {

		return this.beforeIconModel;
	}


	protected IModel<InvertibleIconClass> getAfterIconModel() {

		return this.afterIconModel;
	}
}
