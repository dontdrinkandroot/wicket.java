package net.dontdrinkandroot.wicket.bootstrap.behavior

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior
import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import net.dontdrinkandroot.wicket.bootstrap.css.TableStyle
import net.dontdrinkandroot.wicket.bootstrap.css.TableVariant

class TableBehavior(variant: TableVariant?, vararg styles: TableStyle) :
    CompositeBehavior(CssClassAppender(BootstrapCssClass.TABLE)) {

    init {
        variant?.let { addBehavior(CssClassAppender(it)) }
        styles.forEach { addBehavior(CssClassAppender(it)) }
    }
}