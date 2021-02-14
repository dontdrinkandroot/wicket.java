package net.dontdrinkandroot.wicket.bootstrap.behavior.form

import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize
import org.apache.wicket.Component
import org.apache.wicket.behavior.Behavior
import org.apache.wicket.markup.ComponentTag

/**
 * Behavior that manages the style of a form.
 *
 * @see FormLabelSizeBehavior
 *
 * @see FormContainerSizeBehavior
 *
 * @see InlineFormScreenReaderOnlyLabelBehavior
 */
class FormStyleBehavior : Behavior() {

    var containerSize: ColumnSize? = null
        private set

    var isInline = false
        set(value) {
            field = value
            containerSize = null
        }

    val isHorizontal: Boolean
        get() = null != containerSize

    /**
     * Apply horizontal style to form. Specify the ColumnSize for the container component, the ColumnSize for the label
     * component will be computed.
     */
    fun setHorizontal(containerSize: ColumnSize): FormStyleBehavior {
        isInline = false
        this.containerSize = containerSize
        return this
    }

    fun reset() {
        isInline = false
        containerSize = null
    }

    val labelSize: ColumnSize?
        get() = containerSize!!.inverseColumnSize

    override fun onComponentTag(component: Component, tag: ComponentTag) {
        super.onComponentTag(component, tag)
        if (isHorizontal) {
            tag.append("class", BootstrapCssClass.FORM_HORIZONTAL.classString, " ")
        }
        if (isInline) {
            tag.append("class", BootstrapCssClass.FORM_INLINE.classString, " ")
        }
    }
}