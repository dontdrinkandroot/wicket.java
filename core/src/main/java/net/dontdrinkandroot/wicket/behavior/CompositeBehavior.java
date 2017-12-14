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
package net.dontdrinkandroot.wicket.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * A Behavior that bundles multiple behaviors. Can be useful for adding/removing/disabling a behavior at once.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class CompositeBehavior extends Behavior
{
    private Collection<Behavior> behaviors;

    public CompositeBehavior(final Behavior... behaviors)
    {
        this(new ArrayList<>(Arrays.asList(behaviors)));
    }

    public CompositeBehavior(final Collection<Behavior> behaviors)
    {
        this.behaviors = behaviors;
    }

    @Override
    public void afterRender(final Component component)
    {
        for (final Behavior behavior : this.behaviors) {
            behavior.afterRender(component);
        }
    }

    @Override
    public void beforeRender(final Component component)
    {
        for (final Behavior behavior : this.behaviors) {
            behavior.beforeRender(component);
        }
    }

    @Override
    public void bind(final Component component)
    {
        for (final Behavior behavior : this.behaviors) {
            behavior.bind(component);
        }
    }

    @Override
    public void detach(final Component component)
    {
        for (final Behavior behavior : this.behaviors) {
            behavior.detach(component);
        }
    }

    @Override
    public boolean getStatelessHint(final Component component)
    {
        boolean stateless = true;
        for (final Behavior behavior : this.behaviors) {
            stateless = stateless && behavior.getStatelessHint(component);
        }

        return stateless;
    }

    @Override
    public boolean isEnabled(final Component component)
    {
        boolean enabled = true;
        for (final Behavior behavior : this.behaviors) {
            enabled = enabled && behavior.isEnabled(component);
        }

        return enabled;
    }

    @Override
    public boolean isTemporary(final Component component)
    {
        boolean back = true;
        for (final Behavior behavior : this.behaviors) {
            back = back && behavior.isTemporary(component);
        }
        return back;
    }

    @Override
    public void onComponentTag(final Component component, final ComponentTag tag)
    {
        for (final Behavior behavior : this.behaviors) {
            behavior.onComponentTag(component, tag);
        }
    }

    @Override
    public void renderHead(final Component component, final IHeaderResponse response)
    {
        super.renderHead(component, response);

        for (final Behavior behavior : this.behaviors) {
            behavior.renderHead(component, response);
        }
    }

    public void exception(final Component component, final RuntimeException exception)
    {
        for (final Behavior behavior : this.behaviors) {
            behavior.onException(component, exception);
        }
    }

    protected void addBehavior(Behavior behavior)
    {
        this.behaviors.add(behavior);
    }
}
