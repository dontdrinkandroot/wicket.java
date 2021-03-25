package net.dontdrinkandroot.wicket.bootstrap.behavior.form

import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeStack
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

    var inline = false
        set(value) {
            field = value
            containerSize = null
        }

    val horizontal: Boolean
        get() = null != containerSize

    /**
     * Apply horizontal style to form. Specify the ColumnSize for the container component, the ColumnSize for the label
     * component will be computed.
     */
    fun setHorizontal(containerSize: ColumnSize): FormStyleBehavior {
        inline = false
        this.containerSize = containerSize
        return this
    }

    fun reset() {
        inline = false
        containerSize = null
    }

    val labelSize: ColumnSize?
        get() = containerSize!!.inverseColumnSize

    override fun onComponentTag(component: Component, tag: ComponentTag) {
        super.onComponentTag(component, tag)
        if (horizontal) {
            tag.append("class", BootstrapCssClass.FORM_HORIZONTAL.classString, " ")
        }
        if (inline) {
            tag.append("class", BootstrapCssClass.FORM_INLINE.classString, " ")
        }
    }
}

inline fun inlineForm() = FormStyleBehavior().apply { inline = true }

inline fun horizontalForm(containerSize: ColumnSize = ColumnSizeStack.FORM_DEFAULT) =
    FormStyleBehavior().apply { setHorizontal(containerSize) }