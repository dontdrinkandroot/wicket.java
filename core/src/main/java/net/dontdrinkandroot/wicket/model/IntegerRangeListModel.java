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

import org.apache.wicket.model.AbstractReadOnlyModel;

import java.util.ArrayList;
import java.util.List;

/**
 * A readonly List Model that contains all Integers between the given min and max value, min and max
 * included.
 *
 * @author Philip W. Sorst <philip@sorst.net>
 */
public class IntegerRangeListModel extends AbstractReadOnlyModel<List<Integer>>
{
    private List<Integer> list;

    private int min;

    private int max;

    public IntegerRangeListModel(int min, int max)
    {
        this.min = min;
        this.max = max;
        this.updateList();
    }

    public void setMin(int min)
    {
        this.min = min;
        this.updateList();
    }

    public void setMax(int max)
    {
        this.max = max;
        this.updateList();
    }

    private void updateList()
    {
        this.list = new ArrayList<>();
        for (int i = this.min; i <= this.max; i++) {
            this.list.add(i);
        }
    }

    public int getMin()
    {
        return this.min;
    }

    public int getMax()
    {
        return this.max;
    }

    @Override
    public List<Integer> getObject()
    {
        return this.list;
    }
}
