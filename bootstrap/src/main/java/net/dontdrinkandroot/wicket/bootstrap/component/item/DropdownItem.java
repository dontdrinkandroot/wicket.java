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
package net.dontdrinkandroot.wicket.bootstrap.component.item;

import net.dontdrinkandroot.wicket.behavior.CssClassAppender;
import net.dontdrinkandroot.wicket.bootstrap.behavior.DropdownToggleBehavior;
import net.dontdrinkandroot.wicket.bootstrap.behavior.IconBehavior;
import net.dontdrinkandroot.wicket.bootstrap.component.dropdown.DropdownMenu;
import net.dontdrinkandroot.wicket.bootstrap.css.BootstrapCssClass;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.model.IModel;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public abstract class DropdownItem<T> extends AbstractLabeledItem<T>
{
    private IconBehavior iconBehavior = new IconBehavior().setAppendIcon(BootstrapCssClass.CARET);

    protected DropdownMenu dropdownMenu;

    public DropdownItem(String id, IModel<String> labelModel)
    {
        this(id, labelModel, null);
    }

    public DropdownItem(String id, IModel<String> labelModel, IModel<T> model)
    {
        super(id, labelModel, model);
    }

    @Override
    protected void onInitialize()
    {
        super.onInitialize();

        this.add(new CssClassAppender(BootstrapCssClass.DROPDOWN));

        Label dropDownToggle = new Label("dropDownToggle", this.getLabel());
        dropDownToggle.add(new DropdownToggleBehavior());
        dropDownToggle.add(this.iconBehavior);
        this.add(dropDownToggle);

        this.dropdownMenu = this.createDropdownMenu("dropdownMenu");
        this.add(this.dropdownMenu);
    }

    public IconBehavior getIconBehavior()
    {
        return this.iconBehavior;
    }

    protected abstract DropdownMenu createDropdownMenu(String id);
}
