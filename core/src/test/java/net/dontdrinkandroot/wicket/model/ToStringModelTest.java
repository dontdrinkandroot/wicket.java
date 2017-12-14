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

import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ToStringModelTest
{
    @Test
    public void testIsReadOnly()
    {
        IModel<LocalDate> parentModel = Model.of(LocalDate.of(2012, 1, 2));
        IModel<String> model = new ToStringModel(parentModel);

        try {
            model.setObject("Test");
            Assert.fail("Runtimeexception expected");
        } catch (UnsupportedOperationException e) {
            Assert.assertEquals(
                    "Model class net.dontdrinkandroot.wicket.model.ToStringModel does not support setObject(Object)",
                    e.getMessage()
            );
        }
    }
}
