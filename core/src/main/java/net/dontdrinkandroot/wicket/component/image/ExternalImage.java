package net.dontdrinkandroot.wicket.component.image;

import java.net.URL;

import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.html.WebComponent;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;


public class ExternalImage extends WebComponent {

	public ExternalImage(String id, String urlString) {

		super(id, new Model<String>(urlString));
		this.setEscapeModelStrings(false);
	}


	public ExternalImage(final String id, final IModel<URL> urlModel) {

		super(id, urlModel);
		this.setEscapeModelStrings(false);
	}


	@Override
	protected void onComponentTag(final ComponentTag tag) {

		super.onComponentTag(tag);

		this.checkComponentTag(tag, "img");
		tag.put("src", this.getDefaultModelObjectAsString());
	}
}
