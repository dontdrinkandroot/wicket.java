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
package net.dontdrinkandroot.wicket.bootstrap.behavior;

import net.dontdrinkandroot.wicket.behavior.CompositeBehavior;
import net.dontdrinkandroot.wicket.model.EnumLowerCaseNameModel;
import org.apache.wicket.AttributeModifier;
import org.apache.wicket.Component;
import org.apache.wicket.markup.head.IHeaderResponse;
import org.apache.wicket.markup.head.OnDomReadyHeaderItem;
import org.apache.wicket.model.IModel;
import org.apache.wicket.model.Model;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class ToolTipBehavior extends CompositeBehavior
{
    private final IModel<Position> positionModel = new Model<>();

    public ToolTipBehavior(IModel<String> textModel)
    {
        this(textModel, Model.of(Position.TOP), Model.of(0));
    }

    public ToolTipBehavior(IModel<String> textModel, IModel<Position> positionModel, IModel<Integer> delayModel)
    {
        super(
                new AttributeModifier("title", textModel),
                new AttributeModifier("data-toggle", "tooltip"),
                new AttributeModifier("data-placement", new EnumLowerCaseNameModel(positionModel)),
                new AttributeModifier("data-delay", delayModel)
        );
    }

    @Override
    public void renderHead(Component component, IHeaderResponse response)
    {
        super.renderHead(component, response);

        response.render(OnDomReadyHeaderItem.forScript("$('[data-toggle=\"tooltip\"]').tooltip();"));
    }

    public ToolTipBehavior setPosition(Position position)
    {
        this.positionModel.setObject(position);
        return this;
    }

    public enum Position
    {
        TOP,
        BOTTOM,
        LEFT,
        RIGHT
    }
}
