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

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ConcatenatingStringModel extends AbstractChainedModel<String, String>
{
    private IModel<String> suffixModel;

    private String separator;

    public ConcatenatingStringModel(IModel<? extends String> parent, String appendString)
    {
        super(parent);

        this.suffixModel = Model.of(appendString);
    }

    public ConcatenatingStringModel(IModel<? extends String> parent, IModel<String> appendStringModel)
    {
        super(parent);

        this.suffixModel = appendStringModel;
    }

    public ConcatenatingStringModel(IModel<? extends String> parent, String separator, IModel<String> appendStringModel)
    {
        super(parent);

        this.suffixModel = appendStringModel;
        this.separator = separator;
    }

    @Override
    public String getObject()
    {
        String prefix = this.getParentObject();
        if (null == this.suffixModel) {
            return prefix;
        }
        String suffix = this.suffixModel.getObject();

        StringBuilder concatenatedString = new StringBuilder();
        if (null != prefix) {
            concatenatedString.append(prefix);
        }
        if ((null != this.separator) && (null != prefix) && (null != suffix)) {
            concatenatedString.append(this.separator);
        }
        if (null != suffix) {
            concatenatedString.append(suffix);
        }

        return concatenatedString.toString();
    }

    @Override
    public void detach()
    {
        super.detach();
        if (null != this.suffixModel) {
            this.suffixModel.detach();
        }
    }
}
