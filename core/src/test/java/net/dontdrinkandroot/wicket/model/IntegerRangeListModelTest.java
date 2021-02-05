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
package net.dontdrinkandroot.wicket.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class IntegerRangeListModelTest
{
    @Test
    public void testRanges()
    {
        IntegerRangeListModel model = new IntegerRangeListModel(1, 3);
        Assertions.assertEquals(model.getObject(), Arrays.asList(1, 2, 3));
        model.setMin(2);
        Assertions.assertEquals(model.getObject(), Arrays.asList(2, 3));
        model.setMax(4);
        Assertions.assertEquals(model.getObject(), Arrays.asList(2, 3, 4));
        Assertions.assertEquals(2, model.getMin());
        Assertions.assertEquals(4, model.getMax());
    }
}
