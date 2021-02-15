import org.apache.wicket.Component
import org.apache.wicket.IGenericComponent
import org.apache.wicket.behavior.Behavior
import kotlin.reflect.KClass

fun <C : Behavior> Component.findClosestBehavior(behaviorClass: KClass<C>): C? {
    val current = this.parent ?: return null
    for (behavior in current.behaviors) {
        @Suppress("UNCHECKED_CAST")
        if (behaviorClass.isInstance(behavior)) return behavior as C
    }
    return current.findClosestBehavior(behaviorClass)
}

val <T, C : IGenericComponent<T, *>> IGenericComponent<T, C>.modelValue: T
    get() = this.model.getObject()