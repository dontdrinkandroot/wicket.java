package net.dontdrinkandroot.wicket.behavior

import org.apache.wicket.behavior.AttributeAppender

/**
 * Renders a JavaScript String as the "onclick" attribute of an element.
 */
class OnClickScriptBehavior(script: CharSequence) : AttributeAppender("onclick", script.toString(), " ")