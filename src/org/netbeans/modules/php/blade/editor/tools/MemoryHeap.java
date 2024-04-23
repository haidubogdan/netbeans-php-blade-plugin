package org.netbeans.modules.php.blade.editor.tools;

import java.lang.management.GarbageCollectorMXBean;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryPoolMXBean;
import java.util.List;

/**
 *
 * @author bhaidu
 */
public class MemoryHeap {

    public static void printMemory() {
        System.out.println("Memory bean started");
        List<MemoryPoolMXBean> beans = ManagementFactory.getMemoryPoolMXBeans();
        for (MemoryPoolMXBean bean : beans) {
            System.out.println(bean.getName() + " u:" +  bean.getUsage());
        }
        for (GarbageCollectorMXBean bean: ManagementFactory.getGarbageCollectorMXBeans()) {
            System.out.println(bean.getName() + " c:" +  bean.getCollectionCount() + " t:" + bean.getCollectionTime());
        }
        System.out.println("runtime");
        System.out.println("Memory bean finished");
    }
}
