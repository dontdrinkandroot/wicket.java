/**
 * Copyright (C) 2012-2014 Philip W. Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
