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
package net.dontdrinkandroot.wicket.javascript;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.wicket.Component;


/**
 * Utilities to programmatically assemble simple JQuery Scripts.
 * 
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class JQueryScript implements CharSequence
{

	public static Integer DEFAULT_ANIMATION_DURATION = Integer.valueOf(400);

	public static String DEFAULT_EASING_FUNCTION = "swing";

	public static String TEMPLATE_ANIMATE = ".animate(%s, %d, '%s', function() {%s})";

	public static String TEMPLATE_CHILDREN = ".children(%s)";

	public static String TEMPLATE_HIDE = ".hide(%d, '%s', function() {%s})";

	public static String TEMPLATE_SHOW = ".show(%d, '%s', function() {%s})";

	public static String TEMPLATE_FADEIN = ".fadeIn(%d, '%s', function() {%s})";

	public static String TEMPLATE_FADETOGGLE = ".fadeToggle(%d, '%s', function() {%s})";

	public static String TEMPLATE_FADEOUT = ".fadeOut(%d, '%s', function() {%s})";

	public static String TEMPLATE_TOGGLE = ".toggle(%d, '%s', function() {%s})";

	public static String TEMPLATE_SLIDEDOWN = ".slideDown(%d, '%s', function() {%s})";

	public static String TEMPLATE_SLIDEUP = ".slideUp(%d, '%s', function() {%s})";

	public static String TEMPLATE_SLIDETOGGLE = ".slideToggle(%d, '%s', function() {%s})";

	public static String TEMPLATE_KEYPRESS = ".keypress(function(event) {%s})";

	public static String TEMPLATE_CLICK = ".click(function(event) {%s})";

	protected final StringBuffer scriptBuffer;


	/**
	 * Create a new JQuery Script using this as a selector.
	 */
	public JQueryScript()
	{
		this.scriptBuffer = new StringBuffer("jQuery(this)");
	}

	/**
	 * Create a new JQuery Script using the components markupid as a selector.
	 *
	 * @param component
	 *            The component to be selected.
	 */
	public JQueryScript(final Component component)
	{
		this("#" + component.getMarkupId());
		component.setOutputMarkupId(true);
	}

	/**
	 * Create a new JQuery Script using the given selector.
	 *
	 * @param selector
	 *            The selector to use.
	 */
	public JQueryScript(final String selector)
	{
		this.scriptBuffer = new StringBuffer(String.format("jQuery('%s')", selector));
	}

	@Override
	public String toString()
	{
		return this.scriptBuffer.toString();
	}

	@Override
	public char charAt(int position)
	{
		return this.scriptBuffer.charAt(position);
	}

	@Override
	public int length()
	{
		return this.scriptBuffer.length();
	}

	@Override
	public CharSequence subSequence(int start, int end)
	{
		return this.scriptBuffer.subSequence(start, end);
	}

	/**
	 * Perform a custom animation of a set of CSS properties.
	 *
	 * @param properties
	 *            A map of CSS properties that the animation will move toward.
	 * @return This script for chaining.
	 */
	public JQueryScript animate(final Properties properties)
	{
		return this.animate(properties, null, null, null);
	}

	/**
	 * Perform a custom animation of a set of CSS properties.
	 *
	 * @param properties
	 *            A map of CSS properties that the animation will move toward.
	 * @param duration
	 *            A number determining how long the animation will run (in milliseconds), defaults to 400.
	 * @param easing
	 *            A string indicating which easing function to use for the transition, defaults to "swing".
	 * @param callbackScript
	 *            A script to call once the animation is complete, defaults to an empty script.
	 * @return This script for chaining.
	 */
	public JQueryScript animate(
			final Properties properties,
			final Integer duration,
			final String easing,
			final CharSequence callbackScript)
	{
		this.scriptBuffer.append(
				String.format(
						JQueryScript.TEMPLATE_ANIMATE,
						this.parseProperties(properties),
						this.parseDurationWithDefault(duration),
						this.parseEasingWithDefault(easing),
						this.parseScriptWithDefault(callbackScript)));

		return this;
	}

	/**
	 * Get the children of each element in the set of matched elements, optionally filtered by a selector.
	 *
	 * @param selector
	 *            The selector to use.
	 * @return This script for chaining.
	 */
	public JQueryScript children(final String selector)
	{
		this.scriptBuffer.append(String.format(JQueryScript.TEMPLATE_CHILDREN, this.nullSafeEscapedString(selector)));
		return this;
	}

	/**
	 * Display the matched elements by fading them to opaque.
	 *
	 * @return This script for chaining.
	 */
	public JQueryScript fadeIn()
	{
		return this.fadeIn(null, null, null);
	}

	/**
	 * Display the matched elements by fading them to opaque.
	 *
	 * @param duration
	 *            A number determining how long the animation will run (in milliseconds), defaults to 400.
	 * @param callbackScript
	 *            A script to call once the animation is complete, defaults to an empty script.
	 * @return This script for chaining.
	 */
	public JQueryScript fadeIn(final Integer duration, final CharSequence callbackScript)
	{
		return this.fadeIn(duration, null, callbackScript);
	}

	/**
	 * Display the matched elements by fading them to opaque.
	 *
	 * @param duration
	 *            A number determining how long the animation will run (in milliseconds), defaults to 400.
	 * @param easing
	 *            A string indicating which easing function to use for the transition, defaults to "swing".
	 * @param callbackScript
	 *            A script to call once the animation is complete, defaults to an empty script.
	 * @return This script for chaining.
	 */
	public JQueryScript fadeIn(final Integer duration, final String easing, final CharSequence callbackScript)
	{
		Integer actualDuration = JQueryScript.DEFAULT_ANIMATION_DURATION;
		if (duration != null) {
			actualDuration = duration;
		}

		String actualEasing = JQueryScript.DEFAULT_EASING_FUNCTION;
		if (easing != null) {
			actualEasing = easing;
		}

		CharSequence actualCallbackScript = "";
		if (callbackScript != null) {
			actualCallbackScript = callbackScript;
		}

		this.scriptBuffer.append(
				String.format(JQueryScript.TEMPLATE_FADEIN, actualDuration, actualEasing, actualCallbackScript));

		return this;
	}

	/**
	 * Hide the matched elements by fading them to transparent.
	 *
	 * @return This script for chaining.
	 */
	public JQueryScript fadeOut()
	{
		return this.fadeOut(null, null, null);
	}

	/**
	 * Hide the matched elements by fading them to transparent.
	 *
	 * @param duration
	 *            A number determining how long the animation will run (in milliseconds), defaults to 400.
	 * @param easing
	 *            A string indicating which easing function to use for the transition, defaults to "swing".
	 * @param callbackScript
	 *            A script to call once the animation is complete, defaults to an empty script.
	 * @return This script for chaining.
	 */
	public JQueryScript fadeOut(final Integer duration, final String easing, final String callbackScript)
	{
		Integer actualDuration = JQueryScript.DEFAULT_ANIMATION_DURATION;
		if (duration != null) {
			actualDuration = duration;
		}

		String actualEasing = JQueryScript.DEFAULT_EASING_FUNCTION;
		if (easing != null) {
			actualEasing = easing;
		}

		String actualCallbackScript = "";
		if (callbackScript != null) {
			actualCallbackScript = callbackScript;
		}

		this.scriptBuffer.append(
				String.format(JQueryScript.TEMPLATE_FADEOUT, actualDuration, actualEasing, actualCallbackScript));

		return this;
	}

	/**
	 * Display or hide the matched elements by animating their opacity.
	 *
	 * @param duration
	 *            A number determining how long the animation will run (in milliseconds), defaults to 400.
	 * @param easing
	 *            A string indicating which easing function to use for the transition, defaults to "swing".
	 * @param callbackScript
	 *            A script to call once the animation is complete, defaults to an empty script.
	 * @return This script for chaining.
	 */
	public JQueryScript fadeToggle()
	{
		return this.fadeToggle(null, null, null);
	}

	/**
	 * Display or hide the matched elements by animating their opacity.
	 *
	 * @param duration
	 *            A number determining how long the animation will run (in milliseconds), defaults to 400.
	 * @param easing
	 *            A string indicating which easing function to use for the transition, defaults to "swing".
	 * @param callbackScript
	 *            A script to call once the animation is complete, defaults to an empty script.
	 * @return This script for chaining.
	 */
	public JQueryScript fadeToggle(final Integer duration, final String easing, final String callbackScript)
	{
		Integer actualDuration = JQueryScript.DEFAULT_ANIMATION_DURATION;
		if (duration != null) {
			actualDuration = duration;
		}

		String actualEasing = JQueryScript.DEFAULT_EASING_FUNCTION;
		if (easing != null) {
			actualEasing = easing;
		}

		String actualCallbackScript = "";
		if (callbackScript != null) {
			actualCallbackScript = callbackScript;
		}

		this.scriptBuffer.append(
				String.format(JQueryScript.TEMPLATE_FADETOGGLE, actualDuration, actualEasing, actualCallbackScript));

		return this;
	}

	/**
	 * Hide the matched elements.
	 *
	 * @return This script for chaining.
	 */
	public JQueryScript hide()
	{
		return this.hide(null, null, null);
	}

	/**
	 * Hide the matched elements.
	 *
	 * @param duration
	 *            A number determining how long the animation will run (in milliseconds), defaults to 0 (hiding
	 *            immediately).
	 * @param easing
	 *            A string indicating which easing function to use for the transition, defaults to "swing".
	 * @param callbackScript
	 *            A script to call once the animation is complete, defaults to an empty script.
	 * @return This script for chaining.
	 */
	public JQueryScript hide(final Integer duration, final String easing, final String callbackScript)
	{
		Integer actualDuration = Integer.valueOf(0);
		if (duration != null) {
			actualDuration = duration;
		}

		String actualEasing = JQueryScript.DEFAULT_EASING_FUNCTION;
		if (easing != null) {
			actualEasing = easing;
		}

		String actualCallbackScript = "";
		if (callbackScript != null) {
			actualCallbackScript = callbackScript;
		}

		this.scriptBuffer.append(
				String.format(JQueryScript.TEMPLATE_HIDE, actualDuration, actualEasing, actualCallbackScript));

		return this;
	}

	public JQueryScript click(String callbackScript)
	{
		String actualCallbackScript = "";
		if (callbackScript != null) {
			actualCallbackScript = callbackScript;
		}

		this.scriptBuffer.append(String.format(JQueryScript.TEMPLATE_CLICK, actualCallbackScript));

		return this;
	}

	/**
	 * Display the matched elements.
	 *
	 * @return This script for chaining.
	 */
	public JQueryScript show()
	{
		return this.show(null, null, null);
	}

	/**
	 * Display the matched elements.
	 *
	 * @param duration
	 *            A number determining how long the animation will run (in milliseconds), defaults to 0 (showing
	 *            immediately).
	 * @param easing
	 *            A string indicating which easing function to use for the transition, defaults to "swing".
	 * @param callbackScript
	 *            A script to call once the animation is complete, defaults to an empty script.
	 * @return This script for chaining.
	 */
	public JQueryScript show(final Integer duration, final String easing, final String callbackScript)
	{
		Integer actualDuration = Integer.valueOf(0);
		if (duration != null) {
			actualDuration = duration;
		}

		String actualEasing = JQueryScript.DEFAULT_EASING_FUNCTION;
		if (easing != null) {
			actualEasing = easing;
		}

		String actualCallbackScript = "";
		if (callbackScript != null) {
			actualCallbackScript = callbackScript;
		}

		this.scriptBuffer.append(
				String.format(JQueryScript.TEMPLATE_SHOW, actualDuration, actualEasing, actualCallbackScript));

		return this;
	}

	/**
	 * Display the matched elements with a sliding motion.
	 *
	 * @return This script for chaining.
	 */
	public JQueryScript slideDown()
	{
		return this.slideDown(null, null, null);
	}

	/**
	 * Display the matched elements with a sliding motion.
	 *
	 * @param duration
	 *            A number determining how long the animation will run (in milliseconds), defaults to 400.
	 * @param easing
	 *            A string indicating which easing function to use for the transition, defaults to "swing".
	 * @param callbackScript
	 *            A script to call once the animation is complete, defaults to an empty script.
	 * @return This script for chaining.
	 */
	public JQueryScript slideDown(final Integer duration, final String easing, final String callbackScript)
	{
		Integer actualDuration = JQueryScript.DEFAULT_ANIMATION_DURATION;
		if (duration != null) {
			actualDuration = duration;
		}

		String actualEasing = JQueryScript.DEFAULT_EASING_FUNCTION;
		if (easing != null) {
			actualEasing = easing;
		}

		String actualCallbackScript = "";
		if (callbackScript != null) {
			actualCallbackScript = callbackScript;
		}

		this.scriptBuffer.append(
				String.format(JQueryScript.TEMPLATE_SLIDEDOWN, actualDuration, actualEasing, actualCallbackScript));

		return this;
	}

	/**
	 * Hide the matched elements with a sliding motion.
	 *
	 * @return This script for chaining.
	 */
	public JQueryScript slideUp()
	{
		return this.slideUp(null, null, null);
	}

	/**
	 * Hide the matched elements with a sliding motion.
	 *
	 * @param duration
	 *            A number determining how long the animation will run (in milliseconds), defaults to 400.
	 * @param easing
	 *            A string indicating which easing function to use for the transition, defaults to "swing".
	 * @param callbackScript
	 *            A script to call once the animation is complete, defaults to an empty script.
	 * @return This script for chaining.
	 */
	public JQueryScript slideUp(final Integer duration, final String easing, final String callbackScript)
	{
		Integer actualDuration = JQueryScript.DEFAULT_ANIMATION_DURATION;
		if (duration != null) {
			actualDuration = duration;
		}

		String actualEasing = JQueryScript.DEFAULT_EASING_FUNCTION;
		if (easing != null) {
			actualEasing = easing;
		}

		String actualCallbackScript = "";
		if (callbackScript != null) {
			actualCallbackScript = callbackScript;
		}

		this.scriptBuffer.append(
				String.format(JQueryScript.TEMPLATE_SLIDEUP, actualDuration, actualEasing, actualCallbackScript));

		return this;
	}

	/**
	 * Display or hide the matched elements with a sliding motion.
	 *
	 * @return This script for chaining.
	 */
	public JQueryScript slideToggle()
	{
		return this.slideToggle(null, null, null);
	}

	/**
	 * Display or hide the matched elements with a sliding motion.
	 *
	 * @param duration
	 *            A number determining how long the animation will run (in milliseconds), defaults to 400.
	 * @param easing
	 *            A string indicating which easing function to use for the transition, defaults to "swing".
	 * @param callbackScript
	 *            A script to call once the animation is complete, defaults to an empty script.
	 * @return This script for chaining.
	 */
	public JQueryScript slideToggle(final Integer duration, final String easing, final String callbackScript)
	{
		Integer actualDuration = JQueryScript.DEFAULT_ANIMATION_DURATION;
		if (duration != null) {
			actualDuration = duration;
		}

		String actualEasing = JQueryScript.DEFAULT_EASING_FUNCTION;
		if (easing != null) {
			actualEasing = easing;
		}

		String actualCallbackScript = "";
		if (callbackScript != null) {
			actualCallbackScript = callbackScript;
		}

		this.scriptBuffer.append(
				String.format(JQueryScript.TEMPLATE_SLIDETOGGLE, actualDuration, actualEasing, actualCallbackScript));

		return this;
	}

	/**
	 * Display or hide the matched elements.
	 *
	 * @return This script for chaining.
	 */
	public JQueryScript toggle()
	{
		return this.toggle(null, null, null);
	}

	/**
	 * Display or hide the matched elements.
	 *
	 * @param duration
	 *            A number determining how long the animation will run (in milliseconds), defaults to 0 (toggling
	 *            immediately).
	 * @param easing
	 *            A string indicating which easing function to use for the transition, defaults to "swing".
	 * @param callbackScript
	 *            A script to call once the animation is complete, defaults to an empty script.
	 * @return This script for chaining.
	 */
	public JQueryScript toggle(final Integer duration, final String easing, final String callbackScript)
	{
		Integer actualDuration = Integer.valueOf(0);
		if (duration != null) {
			actualDuration = duration;
		}

		String actualEasing = JQueryScript.DEFAULT_EASING_FUNCTION;
		if (easing != null) {
			actualEasing = easing;
		}

		String actualCallbackScript = "";
		if (callbackScript != null) {
			actualCallbackScript = callbackScript;
		}

		this.scriptBuffer.append(
				String.format(JQueryScript.TEMPLATE_TOGGLE, actualDuration, actualEasing, actualCallbackScript));

		return this;
	}

	private Integer parseDurationWithDefault(final Integer duration)
	{
		if (duration != null) {
			return duration;
		} else {
			return JQueryScript.DEFAULT_ANIMATION_DURATION;
		}
	}

	private String parseEasingWithDefault(final String easing)
	{
		if (easing != null) {
			return easing;
		} else {
			return JQueryScript.DEFAULT_EASING_FUNCTION;
		}
	}

	private CharSequence parseScriptWithDefault(final CharSequence callbackScript)
	{
		if (callbackScript == null) {
			return "";
		} else {
			return callbackScript;
		}
	}

	private CharSequence parseProperties(final Properties properties)
	{
		final StringBuffer sb = new StringBuffer("{");

		if (properties != null) {
			final Iterator<Entry<Object, Object>> propIt = properties.entrySet().iterator();
			while (propIt.hasNext()) {
				final Entry<Object, Object> propertyEntry = propIt.next();
				sb.append("'").append(propertyEntry.getKey()).append("'").append(": ").append("'").append(
						propertyEntry.getValue()).append("'");
				if (propIt.hasNext()) {
					sb.append(", ");
				}
			}
		}

		sb.append("}");

		return sb;
	}

	private String nullSafeEscapedString(final String s)
	{

		if (s == null) {
			return "";
		} else {
			return "'" + s + "'";
		}
	}

	// TODO refactor
	public JQueryScript siblings(final String selector)
	{
		this.scriptBuffer.append(".siblings(" + this.nullSafeEscapedString(selector) + ")");
		return this;
	}

	// TODO refactor
	public JQueryScript removeClass(final String string)
	{
		this.scriptBuffer.append(".removeClass('" + string + "')");
		return this;
	}

	// TODO refactor
	public JQueryScript addClass(final String string)
	{
		this.scriptBuffer.append(".addClass('" + string + "')");
		return this;
	}

	public JQueryScript append(String script)
	{
		this.scriptBuffer.append(script);
		return this;
	}

}
