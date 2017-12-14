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

public class ColumnOffsetStack implements ColumnOffset
{
    private ColumnOffsetExtraSmall columnOffsetExtraSmall;

    private ColumnOffsetSmall columnOffsetSmall;

    private ColumnOffsetMedium columnOffsetMedium;

    private ColumnOffsetLarge columnOffsetLarge;

    public ColumnOffsetStack(
            ColumnOffsetExtraSmall columnOffsetExtraSmall,
            ColumnOffsetSmall columnOffsetSmall,
            ColumnOffsetMedium columnOffsetMedium,
            ColumnOffsetLarge columnOffsetLarge
    )
    {
        super();
        this.columnOffsetExtraSmall = columnOffsetExtraSmall;
        this.columnOffsetSmall = columnOffsetSmall;
        this.columnOffsetMedium = columnOffsetMedium;
        this.columnOffsetLarge = columnOffsetLarge;
    }

    @Override
    public String getClassString()
    {
        StringBuffer classBuffer = new StringBuffer();
        if (null != this.columnOffsetExtraSmall) {
            classBuffer.append(this.columnOffsetExtraSmall.getClassString());
            classBuffer.append(" ");
        }
        if (null != this.columnOffsetSmall) {
            classBuffer.append(this.columnOffsetSmall.getClassString());
            classBuffer.append(" ");
        }
        if (null != this.columnOffsetMedium) {
            classBuffer.append(this.columnOffsetMedium.getClassString());
            classBuffer.append(" ");
        }
        if (null != this.columnOffsetLarge) {
            classBuffer.append(this.columnOffsetLarge.getClassString());
            classBuffer.append(" ");
        }

        return classBuffer.toString().trim();
    }

    @Override
    public ColumnSize getInverseColumnSize()
    {
        ColumnSizeExtraSmall columnSizeExtraSmall =
                this.columnOffsetExtraSmall == null ? null : this.columnOffsetExtraSmall.getInverseColumnSize();
        ColumnSizeSmall columnSizeSmall =
                this.columnOffsetSmall == null ? null : this.columnOffsetSmall.getInverseColumnSize();
        ColumnSizeMedium columnSizeMedium =
                this.columnOffsetMedium == null ? null : this.columnOffsetMedium.getInverseColumnSize();
        ColumnSizeLarge columnSizeLarge =
                this.columnOffsetLarge == null ? null : this.columnOffsetLarge.getInverseColumnSize();

        return new ColumnSizeStack(columnSizeExtraSmall, columnSizeSmall, columnSizeMedium, columnSizeLarge);
    }

    @Override
    public ColumnOffset getInverseColumnOffset()
    {
        ColumnOffsetExtraSmall columnOffsetExtraSmall =
                this.columnOffsetExtraSmall == null ? null : this.columnOffsetExtraSmall.getInverseColumnOffset();
        ColumnOffsetSmall columnOffsetSmall =
                this.columnOffsetSmall == null ? null : this.columnOffsetSmall.getInverseColumnOffset();
        ColumnOffsetMedium columnOffsetMedium =
                this.columnOffsetMedium == null ? null : this.columnOffsetMedium.getInverseColumnOffset();
        ColumnOffsetLarge columnOffsetLarge =
                this.columnOffsetLarge == null ? null : this.columnOffsetLarge.getInverseColumnOffset();

        return new ColumnOffsetStack(columnOffsetExtraSmall, columnOffsetSmall, columnOffsetMedium, columnOffsetLarge);
    }
}
