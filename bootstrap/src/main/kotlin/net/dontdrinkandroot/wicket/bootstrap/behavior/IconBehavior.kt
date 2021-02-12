package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.css.CssClass
import org.apache.wicket.Component
import org.apache.wicket.WicketRuntimeException
import org.apache.wicket.markup.transformer.AbstractTransformerBehavior
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model
import org.apache.wicket.util.string.Strings
import java.lang.StringBuffer
import java.util.regex.Pattern

/**
 * Prepends and/or appends an Icon to the body of the attached component.
 */
class IconBehavior(
    private val prependIconModel: IModel<CssClass> = Model(null),
    private val appendIconModel: IModel<CssClass> = Model(null),
    var separator: String? = "&nbsp;&nbsp;"
) : AbstractTransformerBehavior() {

    constructor(prependIcon: CssClass? = null, appendIcon: CssClass? = null) :
            this(Model(prependIcon), Model(appendIcon))

    /** Pattern that matches html tags and is able to extract the open tag, body and close tag. */
    private val PATTERN = Pattern.compile("(<.*?>)(.*)(</.*?>)", Pattern.DOTALL)

    override fun transform(component: Component, output: CharSequence): CharSequence {
        val hasPrependIcon = prependIconModel.getObject() != null
        val hasAppendIcon = appendIconModel.getObject() != null

        /* Abort early if no icon is requested */
        if (!hasPrependIcon && !hasAppendIcon) {
            return output
        }

        /* Fail if there if the component does not have a body and therefore is a single tag (e.g. <input />) */
        val matcher = PATTERN.matcher(output)
        if (!matcher.matches()) {
            throw WicketRuntimeException(
                String.format(
                    "IconBehavior applied to a component that does not have a body: %s",
                    output
                )
            )
        }

        /* Extract the parts */
        val openTag = matcher.group(1)
        val body = matcher.group(2)
        val closeTag = matcher.group(3)
        val bodyIsEmpty = Strings.isEmpty(body)
        val outputBuffer = StringBuffer(openTag)

        /* Prepend icon if requested */
        if (hasPrependIcon) {
            outputBuffer.append(renderIcon(prependIconModel))
            if (null != separator && !bodyIsEmpty || hasAppendIcon) outputBuffer.append(separator)
        }
        outputBuffer.append(body)

        /* Append icon if requested */
        if (hasAppendIcon) {
            if (null != separator && !bodyIsEmpty) outputBuffer.append(separator)
            outputBuffer.append(renderIcon(appendIconModel))
        }
        outputBuffer.append(closeTag)
        return outputBuffer
    }

    /**
     * Renders a span element with the given CssClass.
     */
    private fun renderIcon(iconModel: IModel<CssClass>): String =
        "<span class=\"${iconModel.getObject()!!.classString}\"></span>"
}