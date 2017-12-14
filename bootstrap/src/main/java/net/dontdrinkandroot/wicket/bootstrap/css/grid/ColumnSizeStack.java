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
package net.dontdrinkandroot.wicket.bootstrap.css.grid;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ColumnSizeStack implements ColumnSize
{
    /**
     * Reasonable defaults for a full screen horizontal form.
     */
    public static final ColumnSize FORM_DEFAULT =
            new ColumnSizeStack(null, ColumnSizeSmall.COLUMNS_7, ColumnSizeMedium.COLUMNS_8, ColumnSizeLarge.COLUMNS_9);

    /**
     * Split large screen into two equally sized columns.
     */
    public static final ColumnSize TWO_COLUMNS =
            new ColumnSizeStack(null, ColumnSizeSmall.COLUMNS_6, ColumnSizeMedium.COLUMNS_6, ColumnSizeLarge.COLUMNS_6);

    private ColumnSizeExtraSmall columnSizeExtraSmall;

    private ColumnSizeSmall columnSizeSmall;

    private ColumnSizeMedium columnSizeMedium;

    private ColumnSizeLarge columnSizeLarge;

    public ColumnSizeStack()
    {
        /* Default constructor */
    }

    public ColumnSizeStack(
            ColumnSizeExtraSmall columnSizeExtraSmall,
            ColumnSizeSmall columnSizeSmall,
            ColumnSizeMedium columnSizeMedium,
            ColumnSizeLarge columnSizeLarge
    )
    {
        super();
        this.columnSizeExtraSmall = columnSizeExtraSmall;
        this.columnSizeSmall = columnSizeSmall;
        this.columnSizeMedium = columnSizeMedium;
        this.columnSizeLarge = columnSizeLarge;
    }

    @Override
    public String getClassString()
    {
        StringBuffer classBuffer = new StringBuffer();
        if (null != this.columnSizeExtraSmall) {
            classBuffer.append(this.columnSizeExtraSmall.getClassString());
            classBuffer.append(" ");
        }
        if (null != this.columnSizeSmall) {
            classBuffer.append(this.columnSizeSmall.getClassString());
            classBuffer.append(" ");
        }
        if (null != this.columnSizeMedium) {
            classBuffer.append(this.columnSizeMedium.getClassString());
            classBuffer.append(" ");
        }
        if (null != this.columnSizeLarge) {
            classBuffer.append(this.columnSizeLarge.getClassString());
            classBuffer.append(" ");
        }

        return classBuffer.toString().trim();
    }

    @Override
    public ColumnOffset getInverseColumnOffset()
    {
        ColumnOffsetExtraSmall columnOffsetExtraSmall =
                this.columnSizeExtraSmall == null ? null : this.columnSizeExtraSmall.getInverseColumnOffset();
        ColumnOffsetSmall columnOffsetSmall =
                this.columnSizeSmall == null ? null : this.columnSizeSmall.getInverseColumnOffset();
        ColumnOffsetMedium columnOffsetMedium =
                this.columnSizeMedium == null ? null : this.columnSizeMedium.getInverseColumnOffset();
        ColumnOffsetLarge columnOffsetLarge =
                this.columnSizeLarge == null ? null : this.columnSizeLarge.getInverseColumnOffset();

        return new ColumnOffsetStack(columnOffsetExtraSmall, columnOffsetSmall, columnOffsetMedium, columnOffsetLarge);
    }

    @Override
    public ColumnSize getInverseColumnSize()
    {
        ColumnSizeExtraSmall columnSizeExtraSmall =
                this.columnSizeExtraSmall == null ? null : this.columnSizeExtraSmall.getInverseColumnSize();
        ColumnSizeSmall columnSizeSmall =
                this.columnSizeSmall == null ? null : this.columnSizeSmall.getInverseColumnSize();
        ColumnSizeMedium columnSizeMedium =
                this.columnSizeMedium == null ? null : this.columnSizeMedium.getInverseColumnSize();
        ColumnSizeLarge columnSizeLarge =
                this.columnSizeLarge == null ? null : this.columnSizeLarge.getInverseColumnSize();

        return new ColumnSizeStack(columnSizeExtraSmall, columnSizeSmall, columnSizeMedium, columnSizeLarge);
    }

    public ColumnSizeStack setColumnSizeExtraSmall(ColumnSizeExtraSmall columnSizeExtraSmall)
    {
        this.columnSizeExtraSmall = columnSizeExtraSmall;
        return this;
    }

    public ColumnSizeStack setColumnSizeSmall(ColumnSizeSmall columnSizeSmall)
    {
        this.columnSizeSmall = columnSizeSmall;
        return this;
    }

    public ColumnSizeStack setColumnSizeMedium(ColumnSizeMedium columnSizeMedium)
    {
        this.columnSizeMedium = columnSizeMedium;
        return this;
    }

    public ColumnSizeStack setColumnSizeLarge(ColumnSizeLarge columnSizeLarge)
    {
        this.columnSizeLarge = columnSizeLarge;
        return this;
    }
}
