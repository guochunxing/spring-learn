package oom;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;

import java.util.List;

/**
 * Author: chunxing
 * Date: 2018/7/26  下午3:05
 * Description:
 */
public class JpsTest {

    public static void main(String[] args) {
        List<VirtualMachineDescriptor> machineDescriptors = VirtualMachine.list();
        for (VirtualMachineDescriptor machineDescriptor : machineDescriptors) {
            String displayName = machineDescriptor.displayName();
            String name = machineDescriptor.provider().name();
            System.out.println(displayName + "---" + name);
        }
    }
}
