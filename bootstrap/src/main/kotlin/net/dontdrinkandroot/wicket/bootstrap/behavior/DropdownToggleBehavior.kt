package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.behavior.aria.Aria
import net.dontdrinkandroot.wicket.behavior.aria.AriaModifier
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.AttributeModifier

/**
 * Adds the required attributes for a DropDown Toggle.
 */
class DropdownToggleBehavior : CompositeBehavior(
    CssClassAppender(BootstrapCssClass.DROPDOWN_TOGGLE),
    AttributeModifier("data-bs-toggle", "dropdown"),
    AriaModifier(Aria.HASPOPUP, "true"),
    AriaModifier(Aria.EXPANDED, "false")
)