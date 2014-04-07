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
package net.dontdrinkandroot.wicket.bootstrap.component.pagination;

import org.apache.wicket.ajax.markup.html.AjaxLink;
import org.apache.wicket.markup.ComponentTag;


public abstract class AbstractAjaxPageLink extends AjaxLink<Void> {

	public AbstractAjaxPageLink(String id) {

		super(id);
		this.setBeforeDisabledLink("");
		this.setAfterDisabledLink("");
	}


	@Override
	protected void disableLink(ComponentTag tag) {

		tag.setName("span");

		/* Remove any href from the old link */
		tag.remove("href");

		/* Remove onclick from the old link */
		tag.remove("onclick");
	}
}
