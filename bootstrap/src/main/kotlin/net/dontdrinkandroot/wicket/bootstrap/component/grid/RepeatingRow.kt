package net.dontdrinkandroot.wicket.bootstrap.component.grid

import net.dontdrinkandroot.wicket.behavior.CssClassAppender
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass
import org.apache.wicket.markup.html.panel.Panel
import org.apache.wicket.markup.repeater.RepeatingView

abstract class RepeatingRow(id: String) : Panel(id) {

    override fun onInitialize() {
        super.onInitialize()
        this.add(CssClassAppender(BootstrapCssClass.ROW))
        val columnView = RepeatingView("column")
        populateColumns(columnView)
        this.add(columnView)
    }

    protected abstract fun populateColumns(columnView: RepeatingView)
}