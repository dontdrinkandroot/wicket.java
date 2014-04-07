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
package net.dontdrinkandroot.wicket.bootstrap.headeritem;

import java.util.Arrays;

import org.apache.wicket.Application;
import org.apache.wicket.markup.head.HeaderItem;
import org.apache.wicket.markup.head.JavaScriptHeaderItem;
import org.apache.wicket.markup.head.JavaScriptUrlReferenceHeaderItem;
import org.apache.wicket.request.resource.ResourceReference;
import org.apache.wicket.resource.JQueryResourceReference;


public class BootstrapJsHeaderItem extends JavaScriptUrlReferenceHeaderItem {

	public BootstrapJsHeaderItem(boolean defer) {

		super("http://netdna.bootstrapcdn.com/bootstrap/3.1.1/js/bootstrap.min.js", "bootstrap.js", defer, null, null);
	}


	@Override
	public Iterable<? extends HeaderItem> getDependencies() {

		final ResourceReference backingLibraryReference;
		if (Application.exists()) {
			backingLibraryReference = Application.get().getJavaScriptLibrarySettings().getJQueryReference();
		} else {
			backingLibraryReference = JQueryResourceReference.get();
		}

		return Arrays.asList(JavaScriptHeaderItem.forReference(backingLibraryReference));
	}
}
