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

import org.junit.Assert;
import org.junit.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ColumnOffsetStackTest
{
    @Test
    public void testGetInverseColumnSize()
    {
        ColumnOffsetStack stack = new ColumnOffsetStack(
                ColumnOffsetDefault.COLUMNS_2,
                ColumnOffsetSmall.COLUMNS_3,
                ColumnOffsetMedium.COLUMNS_4,
                ColumnOffsetLarge.COLUMNS_5
        );
        ColumnSize inverseStack = stack.getInverseColumnSize();
        Assert.assertEquals("col-10 col-sm-9 col-md-8 col-lg-7", inverseStack.getClassString());
    }

    @Test
    public void getGetInverseColumnOffset()
    {
        ColumnOffsetStack stack = new ColumnOffsetStack(
                ColumnOffsetDefault.COLUMNS_2,
                ColumnOffsetSmall.COLUMNS_3,
                ColumnOffsetMedium.COLUMNS_4,
                ColumnOffsetLarge.COLUMNS_5
        );
        ColumnOffset inverseStack = stack.getInverseColumnOffset();
        Assert.assertEquals(
                "offset-10 offset-sm-9 offset-md-8 offset-lg-7",
                inverseStack.getClassString()
        );
    }
}
