package net.dontdrinkandroot.wicket.bootstrap.component.grid

import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSize
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeLarge
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeMedium
import net.dontdrinkandroot.wicket.bootstrap.css.grid.ColumnSizeStack
import net.dontdrinkandroot.wicket.bootstrap.test.AbstractWicketTest
import org.apache.wicket.Component
import org.apache.wicket.core.util.string.ComponentRenderer
import org.apache.wicket.markup.html.basic.Label
import org.apache.wicket.markup.repeater.RepeatingView
import org.apache.wicket.model.Model
import org.apache.wicket.util.tester.TagTester
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class RowColumnTest : AbstractWicketTest() {

    @Test
    fun bla() {
        val row: RepeatingRow = object : RepeatingRow("id") {
            override fun populateColumns(columnView: RepeatingView) {
                val columnSize: ColumnSize = ColumnSizeStack(
                    columnSizeMedium = ColumnSizeMedium.COLUMNS_6,
                    columnSizeLarge = ColumnSizeLarge.COLUMNS_3
                )
                for (i in 0..3) {
                    val column: Column<Void> = object : Column<Void>(
                        columnView.newChildId(),
                        null,
                        Model(columnSize),
                        Model(null)
                    ) {
                        override fun createContent(id: String): Component {
                            return Label(id, i)
                        }
                    }
                    columnView.add(column)
                }
            }
        }
        val markup = ComponentRenderer.renderComponent(row).toString()
        row.detachModels()
        var tagTester = TagTester.createTagByAttribute(markup, "wicket:id", "id")
        Assertions.assertEquals("row", tagTester.getAttribute("class"))
        tagTester = TagTester.createTagByAttribute(markup, "wicket:id", "column")
        Assertions.assertEquals("col-md-6 col-lg-3", tagTester.getAttribute("class"))
    }
}