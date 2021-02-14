package net.dontdrinkandroot.wicket.javascript

import org.apache.wicket.Component
import java.time.Duration
import java.util.*

/**
 * Utilities to programmatically assemble simple JQuery Scripts.
 */
class JQueryScript : CharSequence {

    protected val scriptBuffer: StringBuffer

    override val length: Int
        get() = scriptBuffer.length

    /**
     * Create a new JQuery Script using this as a selector.
     */
    constructor() {
        scriptBuffer = StringBuffer("jQuery(this)")
    }

    /**
     * Create a new JQuery Script using the components markupid as a selector.
     *
     * @param component The component to be selected.
     */
    constructor(component: Component) : this("#" + component.markupId) {
        component.outputMarkupId = true
    }

    /**
     * Create a new JQuery Script using the given selector.
     *
     * @param selector The selector to use.
     */
    constructor(selector: String) {
        scriptBuffer = StringBuffer(String.format("jQuery('%s')", selector))
    }

    override fun toString(): String {
        return scriptBuffer.toString()
    }

    override fun get(index: Int): Char {
        return scriptBuffer[index]
    }

    override fun subSequence(startIndex: Int, endIndex: Int): CharSequence {
        return scriptBuffer.subSequence(startIndex, endIndex)
    }
    /**
     * Perform a custom animation of a set of CSS properties.
     *
     * @param properties     A map of CSS properties that the animation will move toward.
     * @param duration       A number determining how long the animation will run (in milliseconds), defaults to 400.
     * @param easingFunction A string indicating which easing function to use for the transition, defaults to "swing".
     * @param callbackScript A script to call once the animation is complete, defaults to an empty script.
     * @return This script for chaining.
     */
    /**
     * Perform a custom animation of a set of CSS properties.
     *
     * @param properties A map of CSS properties that the animation will move toward.
     * @return This script for chaining.
     */
    @JvmOverloads
    fun animate(
        properties: Properties?,
        duration: Duration? = null,
        easingFunction: EasingFunction? = null,
        callbackScript: CharSequence? = null
    ): JQueryScript {
        scriptBuffer.append(
            String.format(
                TEMPLATE_ANIMATE,
                parseProperties(properties),
                parseDurationWithDefault(duration),
                parseEasingFunctionWithDefault(easingFunction),
                parseScriptWithDefault(callbackScript)
            )
        )
        return this
    }

    /**
     * Triggers the focus event on the selected element.
     *
     * @return This script for chaining.
     */
    fun focus(): JQueryScript {
        scriptBuffer.append(".focus()")
        return this
    }

    /**
     * Get the children of each element in the set of matched elements, optionally filtered by a selector.
     *
     * @param selector The selector to use.
     * @return This script for chaining.
     */
    fun children(selector: String?): JQueryScript {
        scriptBuffer.append(String.format(TEMPLATE_CHILDREN, nullSafeEscapedString(selector)))
        return this
    }

    /**
     * Display the matched elements by fading them to opaque.
     *
     * @return This script for chaining.
     */
    fun fadeIn(): JQueryScript {
        scriptBuffer.append(".fadeIn()")
        return this
    }

    /**
     * Display the matched elements by fading them to opaque.
     *
     * @param duration       A number determining how long the animation will run (in milliseconds), defaults to 400.
     * @param easingFunction A string indicating which easing function to use for the transition, defaults to "swing".
     * @param callbackScript A script to call once the animation is complete, defaults to an empty script.
     * @return This script for chaining.
     */
    fun fadeIn(
        duration: Duration?,
        easingFunction: EasingFunction?,
        callbackScript: CharSequence?
    ): JQueryScript {
        scriptBuffer.append(
            String.format(
                TEMPLATE_FADEIN,
                parseDurationWithDefault(duration),
                parseEasingFunctionWithDefault(easingFunction),
                parseScriptWithDefault(callbackScript)
            )
        )
        return this
    }

    /**
     * Hide the matched elements by fading them to transparent.
     *
     * @return This script for chaining.
     */
    fun fadeOut(): JQueryScript {
        scriptBuffer.append(".fadeOut()")
        return this
    }

    /**
     * Hide the matched elements by fading them to transparent.
     *
     * @param duration       A number determining how long the animation will run (in milliseconds), defaults to 400.
     * @param easingFunction A string indicating which easing function to use for the transition, defaults to "swing".
     * @param callbackScript A script to call once the animation is complete, defaults to an empty script.
     * @return This script for chaining.
     */
    fun fadeOut(
        duration: Duration?,
        easingFunction: EasingFunction?,
        callbackScript: String?
    ): JQueryScript {
        scriptBuffer.append(
            String.format(
                TEMPLATE_FADEOUT,
                parseDurationWithDefault(duration),
                parseEasingFunctionWithDefault(easingFunction),
                parseScriptWithDefault(callbackScript)
            )
        )
        return this
    }

    /**
     * Display or hide the matched elements by animating their opacity.
     *
     * @return This script for chaining.
     */
    fun fadeToggle(): JQueryScript {
        scriptBuffer.append(".fadeToggle()")
        return this
    }

    /**
     * Display or hide the matched elements by animating their opacity.
     *
     * @param duration       A number determining how long the animation will run (in milliseconds), defaults to 400.
     * @param easingFunction A string indicating which easing function to use for the transition, defaults to "swing".
     * @param callbackScript A script to call once the animation is complete, defaults to an empty script.
     * @return This script for chaining.
     */
    fun fadeToggle(
        duration: Duration?,
        easingFunction: EasingFunction?,
        callbackScript: String?
    ): JQueryScript {
        scriptBuffer.append(
            String.format(
                TEMPLATE_FADETOGGLE,
                parseDurationWithDefault(duration),
                parseEasingFunctionWithDefault(easingFunction),
                parseScriptWithDefault(callbackScript)
            )
        )
        return this
    }

    /**
     * Hide the matched elements.
     *
     * @return This script for chaining.
     */
    fun hide(): JQueryScript {
        scriptBuffer.append(".hide()")
        return this
    }

    /**
     * Hide the matched elements.
     *
     * @param duration       A number determining how long the animation will run (in milliseconds), defaults to 0 (hiding
     * immediately).
     * @param easingFunction A string indicating which easing function to use for the transition, defaults to "swing".
     * @param callbackScript A script to call once the animation is complete, defaults to an empty script.
     * @return This script for chaining.
     */
    fun hide(duration: Duration?, easingFunction: EasingFunction?, callbackScript: String?): JQueryScript {
        scriptBuffer
            .append(
                String.format(
                    TEMPLATE_HIDE,
                    parseDurationWithDefault(duration, Duration.ZERO),
                    parseEasingFunctionWithDefault(easingFunction),
                    parseScriptWithDefault(callbackScript)
                )
            )
        return this
    }

    fun click(callbackScript: String?): JQueryScript {
        scriptBuffer.append(
            String.format(
                TEMPLATE_CLICK,
                parseScriptWithDefault(callbackScript)
            )
        )
        return this
    }

    /**
     * Display the matched elements.
     *
     * @return This script for chaining.
     */
    fun show(): JQueryScript {
        scriptBuffer.append(".show()")
        return this
    }

    /**
     * Display the matched elements.
     *
     * @param duration       A number determining how long the animation will run (in milliseconds), defaults to 0 (showing
     * immediately).
     * @param easingFunction A string indicating which easing function to use for the transition, defaults to "swing".
     * @param callbackScript A script to call once the animation is complete, defaults to an empty script.
     * @return This script for chaining.
     */
    fun show(duration: Duration?, easingFunction: EasingFunction?, callbackScript: String?): JQueryScript {
        scriptBuffer
            .append(
                String.format(
                    TEMPLATE_SHOW,
                    parseDurationWithDefault(duration, Duration.ZERO),
                    parseEasingFunctionWithDefault(easingFunction),
                    parseScriptWithDefault(callbackScript)
                )
            )
        return this
    }

    /**
     * Display the matched elements with a sliding motion.
     *
     * @return This script for chaining.
     */
    fun slideDown(): JQueryScript {
        scriptBuffer.append(".slideDown()")
        return this
    }

    /**
     * Display the matched elements with a sliding motion.
     *
     * @param duration       A number determining how long the animation will run (in milliseconds), defaults to 400.
     * @param easingFunction A string indicating which easing function to use for the transition, defaults to "swing".
     * @param callbackScript A script to call once the animation is complete, defaults to an empty script.
     * @return This script for chaining.
     */
    fun slideDown(
        duration: Duration?,
        easingFunction: EasingFunction?,
        callbackScript: String?
    ): JQueryScript {
        scriptBuffer.append(
            String.format(
                TEMPLATE_SLIDEDOWN,
                parseDurationWithDefault(duration),
                parseEasingFunctionWithDefault(easingFunction),
                parseScriptWithDefault(callbackScript)
            )
        )
        return this
    }

    /**
     * Hide the matched elements with a sliding motion.
     *
     * @return This script for chaining.
     */
    fun slideUp(): JQueryScript {
        scriptBuffer.append(".slideUp()")
        return this
    }

    /**
     * Hide the matched elements with a sliding motion.
     *
     * @param duration       A number determining how long the animation will run (in milliseconds), defaults to 400.
     * @param easingFunction A string indicating which easing function to use for the transition, defaults to "swing".
     * @param callbackScript A script to call once the animation is complete, defaults to an empty script.
     * @return This script for chaining.
     */
    fun slideUp(
        duration: Duration?,
        easingFunction: EasingFunction?,
        callbackScript: String?
    ): JQueryScript {
        scriptBuffer.append(
            String.format(
                TEMPLATE_SLIDEUP,
                parseDurationWithDefault(duration),
                parseEasingFunctionWithDefault(easingFunction),
                parseScriptWithDefault(callbackScript)
            )
        )
        return this
    }

    /**
     * Display or hide the matched elements with a sliding motion.
     *
     * @return This script for chaining.
     */
    fun slideToggle(): JQueryScript {
        scriptBuffer.append(".slideToggle()")
        return this
    }

    /**
     * Display or hide the matched elements with a sliding motion.
     *
     * @param duration       A number determining how long the animation will run (in milliseconds), defaults to 400.
     * @param easingFunction A string indicating which easing function to use for the transition, defaults to "swing".
     * @param callbackScript A script to call once the animation is complete, defaults to an empty script.
     * @return This script for chaining.
     */
    fun slideToggle(
        duration: Duration?,
        easingFunction: EasingFunction?,
        callbackScript: String?
    ): JQueryScript {
        scriptBuffer.append(
            String.format(
                TEMPLATE_SLIDETOGGLE,
                parseDurationWithDefault(duration),
                parseEasingFunctionWithDefault(easingFunction),
                parseScriptWithDefault(callbackScript)
            )
        )
        return this
    }

    /**
     * Display or hide the matched elements.
     *
     * @return This script for chaining.
     */
    fun toggle(): JQueryScript {
        scriptBuffer.append(".toggle()")
        return this
    }

    /**
     * Display or hide the matched elements.
     *
     * @param duration       A number determining how long the animation will run (in milliseconds), defaults to 0 (toggling
     * immediately).
     * @param easingFunction A string indicating which easing function to use for the transition, defaults to "swing".
     * @param callbackScript A script to call once the animation is complete, defaults to an empty script.
     * @return This script for chaining.
     */
    fun toggle(
        duration: Duration?,
        easingFunction: EasingFunction?,
        callbackScript: String?
    ): JQueryScript {
        scriptBuffer.append(
            String.format(
                TEMPLATE_TOGGLE,
                parseDurationWithDefault(duration, Duration.ZERO),
                parseEasingFunctionWithDefault(easingFunction),
                parseScriptWithDefault(callbackScript)
            )
        )
        return this
    }

    private fun parseDurationWithDefault(
        duration: Duration?,
        defaultValue: Duration = DEFAULT_ANIMATION_DURATION
    ): Long {
        return duration?.toMillis() ?: defaultValue.toMillis()
    }

    private fun parseEasingFunctionWithDefault(easingFunction: EasingFunction?): String {
        return easingFunction?.denomination ?: DEFAULT_EASING_FUNCTION.denomination
    }

    private fun parseScriptWithDefault(callbackScript: CharSequence?): CharSequence {
        return callbackScript ?: ""
    }

    private fun parseProperties(properties: Properties?): CharSequence {
        val sb = StringBuffer("{")
        if (properties != null) {
            val propIt: Iterator<Map.Entry<Any, Any>> = properties.entries.iterator()
            while (propIt.hasNext()) {
                val propertyEntry = propIt.next()
                sb
                    .append("'")
                    .append(propertyEntry.key)
                    .append("'")
                    .append(": ")
                    .append("'")
                    .append(propertyEntry.value)
                    .append("'")
                if (propIt.hasNext()) {
                    sb.append(", ")
                }
            }
        }
        sb.append("}")
        return sb
    }

    private fun nullSafeEscapedString(s: String?): String {
        return if (null == s) {
            ""
        } else "'$s'"
    }

    fun siblings(selector: String?): JQueryScript {
        scriptBuffer.append(".siblings(" + nullSafeEscapedString(selector) + ")")
        return this
    }

    fun removeClass(string: String): JQueryScript {
        scriptBuffer.append(".removeClass('$string')")
        return this
    }

    fun addClass(string: String): JQueryScript {
        scriptBuffer.append(".addClass('$string')")
        return this
    }

    fun append(script: String?): JQueryScript {
        scriptBuffer.append(script)
        return this
    }

    companion object {

        var DEFAULT_ANIMATION_DURATION = Duration.ofMillis(400)
        var DEFAULT_EASING_FUNCTION: EasingFunction = JQueryEasingFunction.SWING
        var TEMPLATE_ANIMATE = ".animate(%s, %d, '%s', function() {%s})"
        var TEMPLATE_CHILDREN = ".children(%s)"
        var TEMPLATE_HIDE = ".hide(%d, '%s', function() {%s})"
        var TEMPLATE_SHOW = ".show(%d, '%s', function() {%s})"
        var TEMPLATE_FADEIN = ".fadeIn(%d, '%s', function() {%s})"
        var TEMPLATE_FADETOGGLE = ".fadeToggle(%d, '%s', function() {%s})"
        var TEMPLATE_FADEOUT = ".fadeOut(%d, '%s', function() {%s})"
        var TEMPLATE_TOGGLE = ".toggle(%d, '%s', function() {%s})"
        var TEMPLATE_SLIDEDOWN = ".slideDown(%d, '%s', function() {%s})"
        var TEMPLATE_SLIDEUP = ".slideUp(%d, '%s', function() {%s})"
        var TEMPLATE_SLIDETOGGLE = ".slideToggle(%d, '%s', function() {%s})"
        var TEMPLATE_KEYPRESS = ".keypress(function(event) {%s})"
        var TEMPLATE_CLICK = ".click(function(event) {%s})"
    }
}