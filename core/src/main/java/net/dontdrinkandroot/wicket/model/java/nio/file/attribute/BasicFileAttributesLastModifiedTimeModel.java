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
package net.dontdrinkandroot.wicket.model.java.nio.file.attribute;

import net.dontdrinkandroot.wicket.model.AbstractChainedReadonlyModel;
import org.apache.wicket.model.IModel;

import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class BasicFileAttributesLastModifiedTimeModel extends AbstractChainedReadonlyModel<BasicFileAttributes, FileTime>
{
    public BasicFileAttributesLastModifiedTimeModel(IModel<? extends BasicFileAttributes> parent)
    {
        super(parent);
    }

    @Override
    public FileTime getObject()
    {
        return this.getParentObject().lastModifiedTime();
    }
}
