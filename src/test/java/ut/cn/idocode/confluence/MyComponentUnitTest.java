package ut.cn.idocode.confluence;

import org.junit.Test;
import cn.idocode.confluence.api.MyPluginComponent;
import cn.idocode.confluence.impl.MyPluginComponentImpl;

import static org.junit.Assert.assertEquals;

public class MyComponentUnitTest
{
    @Test
    public void testMyName()
    {
        MyPluginComponent component = new MyPluginComponentImpl(null);
        assertEquals("names do not match!", "myComponent",component.getName());
    }
}