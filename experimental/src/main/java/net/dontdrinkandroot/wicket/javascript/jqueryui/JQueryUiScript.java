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
