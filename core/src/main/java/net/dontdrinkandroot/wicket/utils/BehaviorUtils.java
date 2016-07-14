package net.dontdrinkandroot.wicket.utils;

import org.apache.wicket.Component;
import org.apache.wicket.MarkupContainer;
import org.apache.wicket.behavior.Behavior;


public class BehaviorUtils
{

	@SuppressWarnings("unchecked")
	public static <C extends Behavior> C findClosestBehavior(Component component, Class<C> behaviorClass)
	{
		MarkupContainer current = component.getParent();
		if (null == current) {
			return null;
		}

		for (Behavior behavior : current.getBehaviors()) {
			if (behaviorClass.isAssignableFrom(behavior.getClass())) {
				return (C) behavior;
			}
		}

		return BehaviorUtils.findClosestBehavior(current, behaviorClass);
	}

}
