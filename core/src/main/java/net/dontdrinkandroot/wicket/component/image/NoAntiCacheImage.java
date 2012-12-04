package net.dontdrinkandroot.wicket.component.image;

import org.apache.wicket.markup.html.image.Image;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.request.resource.IResource;
import org.apache.wicket.request.resource.ResourceReference;


public class NoAntiCacheImage extends Image {

	private static final long serialVersionUID = 1L;


	public NoAntiCacheImage(final String id, final ResourceReference resourceReference) {

		super(id, resourceReference, null);
	}


	public NoAntiCacheImage(
			final String id,
			final ResourceReference resourceReference,
			final PageParameters resourceParameters) {

		super(id, resourceReference, resourceParameters);
	}


	public NoAntiCacheImage(final String id, final IResource imageResource) {

		super(id, imageResource);
	}


	public NoAntiCacheImage(final String id, final IModel<?> model) {

		super(id, model);
	}


	public NoAntiCacheImage(final String id, final String string) {

		this(id, new Model<String>(string));
	}


	@Override
	protected boolean shouldAddAntiCacheParameter() {

		return false;
	}

}
