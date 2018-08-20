package oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: chunxing
 * Date: 2018/7/31  下午10:43
 * Description:
 */
public class HeapOOM {

    public static void main(String[] args) {
        List<HeapOOM> list = new ArrayList<>();
        while (true) {
            list.add(new HeapOOM());
        }
    }
}
