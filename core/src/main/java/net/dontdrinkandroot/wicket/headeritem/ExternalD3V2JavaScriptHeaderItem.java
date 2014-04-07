/**
 * Copyright (C) 2012, 2013 Philip W. Sorst <philip@sorst.net>
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
package net.dontdrinkandroot.wicket.headeritem;

import org.apache.wicket.markup.head.JavaScriptUrlReferenceHeaderItem;


public class ExternalD3V2JavaScriptHeaderItem extends JavaScriptUrlReferenceHeaderItem {

	public ExternalD3V2JavaScriptHeaderItem(boolean defer) {

		super("http://d3js.org/d3.v2.min.js", "d3", defer, null, null);
	}

}
