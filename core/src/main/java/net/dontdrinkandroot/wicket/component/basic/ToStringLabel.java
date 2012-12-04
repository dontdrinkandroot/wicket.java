package net.dontdrinkandroot.wicket.component.basic;

import java.io.Serializable;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.MarkupStream;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.markup.parser.XmlTag.TagType;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class ToStringLabel extends WebComponent {

	public <T extends Serializable> ToStringLabel(final String id, T label) {

		this(id, new Model<T>(label));
	}


	public <T extends Serializable> ToStringLabel(final String id, IModel<T> model) {

		super(id, model);
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	public void onComponentTagBody(final MarkupStream markupStream, final ComponentTag openTag) {

		this.replaceComponentTagBody(markupStream, openTag, this.getDefaultModelObjectAsString());
	}


	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void onComponentTag(ComponentTag tag) {

		super.onComponentTag(tag);

		if (tag.isOpenClose()) {
			// always transform the tag to <span></span> so even labels defined as <span/> render
			tag.setType(TagType.OPEN);
		}
	}
}
