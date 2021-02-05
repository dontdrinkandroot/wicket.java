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
import org.apache.wicket.model.LoadableDetachableModel;
import org.apache.wicket.model.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ConcatenatingStringModelTest
{
    @Test
    public void testConstruction()
    {
        ConcatenatingStringModel concatenatingStringModel;

        concatenatingStringModel = new ConcatenatingStringModel(new Model<>(), (String) null);
        Assertions.assertEquals("", concatenatingStringModel.getObject());

        concatenatingStringModel = new ConcatenatingStringModel(new Model<>("Parent"), (String) null);
        Assertions.assertEquals("Parent", concatenatingStringModel.getObject());

        concatenatingStringModel = new ConcatenatingStringModel(new Model<>("Parent"), (IModel<String>) null);
        Assertions.assertEquals("Parent", concatenatingStringModel.getObject());

        concatenatingStringModel = new ConcatenatingStringModel(new Model<>("Parent"), "Child");
        Assertions.assertEquals("ParentChild", concatenatingStringModel.getObject());

        concatenatingStringModel = new ConcatenatingStringModel(new Model<>("Parent"), Model.of("Child"));
        Assertions.assertEquals("ParentChild", concatenatingStringModel.getObject());

        concatenatingStringModel = new ConcatenatingStringModel(new Model<>("Parent"), "Child");
        Assertions.assertEquals("ParentChild", concatenatingStringModel.getObject());

        concatenatingStringModel = new ConcatenatingStringModel(new Model<>("Parent"), Model.of("Child"));
        Assertions.assertEquals("ParentChild", concatenatingStringModel.getObject());

        concatenatingStringModel = new ConcatenatingStringModel(new Model<>("Parent"), "-", Model.of("Child"));
        Assertions.assertEquals("Parent-Child", concatenatingStringModel.getObject());
    }

    @Test
    public void testDetach()
    {
        LoadableDetachableModel<String> parentModel = new LoadableDetachableModel<String>()
        {
            @Override
            protected String load()
            {
                return "Parent";
            }
        };
        LoadableDetachableModel<String> childModel = new LoadableDetachableModel<String>()
        {
            @Override
            protected String load()
            {
                return "Child";
            }
        };
        ConcatenatingStringModel concatenatingStringModel = new ConcatenatingStringModel(parentModel, childModel);
        Assertions.assertEquals("ParentChild", concatenatingStringModel.getObject());
        concatenatingStringModel.detach();
        Assertions.assertFalse(parentModel.isAttached());
        Assertions.assertFalse(childModel.isAttached());
    }
}
