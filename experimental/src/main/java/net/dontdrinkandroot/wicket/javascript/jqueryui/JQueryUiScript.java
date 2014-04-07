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
package net.dontdrinkandroot.wicket.javascript.jqueryui;

import net.dontdrinkandroot.wicket.javascript.JQueryScript;

import org.apache.wicket.Component;


public class JQueryUiScript extends JQueryScript {

	public static Integer DEFAULT_ANIMATION_DURATION = Integer.valueOf(400);

	public static String DEFAULT_EASING_FUNCTION = "swing";

	public static String BUTTON_TEMPLATE = ".button()";

	public static String BUTTONSET_TEMPLATE = ".buttonset()";

	public static String SLIDER_TEMPLATE = ".slider(%d, '%s', function() {%s})";

	public static String SELECTMENU_TEMPLATE = ".selectmenu()";

	public static String PROGRESSBAR_VALUE_TEMPLATE = ".progressbar({value: %d})";

	public static String PROGRESSBAR_TEMPLATE = ".progressbar()";


	public JQueryUiScript() {

		super();
	}


	public JQueryUiScript(final Component component) {

		super(component);
	}


	public JQueryUiScript(final String selector) {

		super(selector);
	}


	public JQueryUiScript button() {

		this.scriptBuffer.append(String.format(JQueryUiScript.BUTTON_TEMPLATE));
		return this;
	}


	public JQueryScript selectMenu() {

		this.scriptBuffer.append(JQueryUiScript.SELECTMENU_TEMPLATE);
		return this;
	}


	public JQueryScript progressBar(Integer value) {

		this.scriptBuffer.append(String.format(JQueryUiScript.PROGRESSBAR_VALUE_TEMPLATE, value));
		return this;
	}


	public JQueryScript progressBar() {

		this.scriptBuffer.append(JQueryUiScript.PROGRESSBAR_TEMPLATE);
		return this;
	}


	public JQueryScript buttonset() {

		this.scriptBuffer.append(JQueryUiScript.BUTTONSET_TEMPLATE);
		return this;
	}

}
