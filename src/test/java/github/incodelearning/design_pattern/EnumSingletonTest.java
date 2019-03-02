package github.incodelearning.design_pattern;

import org.junit.Assert;
import org.junit.Test;

/**
 * Run the two tests separately to see the difference.
 */
public class EnumSingletonTest {
    class Wrapper {
        EnumSingleton tbt;
    }

    class WrapperDefaultNonNull {
        EnumSingleton tbt = EnumSingleton.INSTANCE;
        public WrapperDefaultNonNull() {
            System.out.println("Constructing Wrapper with enum instantiated with default value, accessing singleton.");
        }
    }

    @Test
    public void testEnumSingleton() {
        Wrapper wrapper1 = new Wrapper();
        Wrapper wrapper2 = new Wrapper();
        Assert.assertNotEquals(wrapper1.hashCode(), wrapper2.hashCode());

        Assert.assertNull(wrapper1.tbt);
        System.out.println("Singleton not constructed yet. Enum compiled and loaded into JVM.");
        wrapper1.tbt = EnumSingleton.INSTANCE;
        System.out.println("Singleton constructed when enum is accessed.");

        Assert.assertNull(wrapper2.tbt);
        System.out.println("Singleton already constructed and only constructed once.");
        wrapper2.tbt = EnumSingleton.INSTANCE;
        Assert.assertEquals(wrapper1.tbt.getSingleton().hashCode(), wrapper2.tbt.getSingleton().hashCode());
    }

    @Test
    public void testEnumSingleton2(){
        WrapperDefaultNonNull wrapper = new WrapperDefaultNonNull();
        Assert.assertNotNull(wrapper.tbt);
    }
}
