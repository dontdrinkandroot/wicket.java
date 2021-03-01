package net.dontdrinkandroot.wicket.example.page

import net.dontdrinkandroot.wicket.bootstrap.css.grid.*
import net.dontdrinkandroot.wicket.example.component.ColumnPanel
import net.dontdrinkandroot.wicket.example.component.OffsetPanel
import net.dontdrinkandroot.wicket.model.model

class GridPage : DecoratorPage<Void>() {

    override fun createPageHeadingModel() = "The Grid".model()

    override fun onInitialize() {
        super.onInitialize()
        val xsColumns = ColumnPanel("xsColumns", ColumnSizeDefault.values())
        this.add(xsColumns)
        val smColumns = ColumnPanel("smColumns", ColumnSizeSmall.values())
        this.add(smColumns)
        val mdColumns = ColumnPanel("mdColumns", ColumnSizeMedium.values())
        this.add(mdColumns)
        val lgColumns = ColumnPanel("lgColumns", ColumnSizeLarge.values())
        this.add(lgColumns)
        val xsOffsets = OffsetPanel("xsOffsets", ColumnOffsetDefault.values())
        this.add(xsOffsets)
        val smOffsets = OffsetPanel("smOffsets", ColumnOffsetSmall.values())
        this.add(smOffsets)
        val mdOffsets = OffsetPanel("mdOffsets", ColumnOffsetMedium.values())
        this.add(mdOffsets)
        val lgOffsets = OffsetPanel("lgOffsets", ColumnOffsetLarge.values())
        this.add(lgOffsets)
    }
}