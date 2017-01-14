package net.dontdrinkandroot.wicket.utils;

import org.apache.wicket.Component;
import org.apache.wicket.util.visit.IVisit;
import org.apache.wicket.util.visit.IVisitor;

/**
 * Prints all components that are not stateless.
 *
 * @author Philip Washington Sorst <philip@sorst.net>
 */
public class NonStatelessPrintingVisitor implements IVisitor<Component, Void>
{
    @Override
    public void component(Component component, IVisit<Void> visit)
    {
        if (!component.isStateless()) {
            System.err.println(
                    String.format(
                            "Component '%s' is not stateless. Type: %s, Path: %s",
                            component.getMarkupId(),
                            component.getClass().getCanonicalName(),
                            component.getPath()
                    )
            );
        }
    }
}
