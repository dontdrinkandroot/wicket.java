/*
 * Copyright (C) 2012-2017 Philip Washington Sorst <philip@sorst.net>
 * and individual contributors as indicated
 * by the @authors tag.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.dontdrinkandroot.wicket.example.page

import net.dontdrinkandroot.wicket.bootstrap.css.grid.*
import net.dontdrinkandroot.wicket.example.component.ColumnPanel
import net.dontdrinkandroot.wicket.example.component.OffsetPanel
import org.apache.wicket.model.IModel
import org.apache.wicket.model.Model

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
class GridPage : DecoratorPage<Void?>()
{
    override fun createPageHeadingModel(): IModel<String>
    {
        return Model.of("The Grid")
    }

    override fun onInitialize()
    {
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