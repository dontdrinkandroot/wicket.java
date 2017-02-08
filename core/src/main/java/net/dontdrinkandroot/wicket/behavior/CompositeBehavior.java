package net.dontdrinkandroot.wicket.behavior;

import org.apache.wicket.Component;
import org.apache.wicket.behavior.Behavior;
import org.apache.wicket.markup.ComponentTag;
import org.apache.wicket.markup.head.IHeaderResponse;

import java.util.Arrays;

/**
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class CompositeBehavior extends Behavior
{
    private Iterable<Behavior> behaviors;

    public CompositeBehavior(final Behavior... behaviors)
    {
        this(Arrays.asList(behaviors));
    }

    public CompositeBehavior(final Iterable<Behavior> behaviors)
    {
        this.behaviors = behaviors;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void afterRender(final Component component)
    {
        for (final Behavior behavior : this.behaviors) {
            behavior.afterRender(component);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void beforeRender(final Component component)
    {
        for (final Behavior behavior : this.behaviors) {
            behavior.beforeRender(component);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void bind(final Component component)
    {
        for (final Behavior behavior : this.behaviors) {
            behavior.bind(component);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void detach(final Component component)
    {
        for (final Behavior behavior : this.behaviors) {
            behavior.detach(component);
        }
    }

    public void exception(final Component component, final RuntimeException exception)
    {
        for (final Behavior behavior : this.behaviors) {
            behavior.onException(component, exception);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean getStatelessHint(final Component component)
    {
        boolean back = true;
        for (final Behavior behavior : this.behaviors) {
            back = back && behavior.getStatelessHint(component);
        }
        return back;
    }

    @Override
    public boolean isEnabled(final Component component)
    {
        boolean back = true;
        for (final Behavior behavior : this.behaviors) {
            back = back && behavior.isEnabled(component);
        }
        return back;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isTemporary(final Component component)
    {
        boolean back = true;
        for (final Behavior behavior : this.behaviors) {
            back = back && behavior.isTemporary(component);
        }
        return back;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void onComponentTag(final Component component, final ComponentTag tag)
    {
        for (final Behavior behavior : this.behaviors) {
            behavior.onComponentTag(component, tag);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void renderHead(final Component component, final IHeaderResponse response)
    {
        super.renderHead(component, response);
        for (final Behavior behavior : this.behaviors) {
            behavior.renderHead(component, response);
        }
    }
}
