package jasmine.crawl.common.component.impl;

import com.jasmine.crawler.common.component.impl.JasmineRandomPicker;
import com.jasmine.crawler.common.util.TestUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JasmineRandomPickTester {

    @Test
    public void testPick() {
        List<Integer> ls = new ArrayList<>();
        ls.add(1);
        ls.add(2);
        ls.add(3);
        JasmineRandomPicker<Integer> picker = new JasmineRandomPicker<>();
        List<Integer> result = picker.pick(ls, 2);

        TestUtils.print(result);
    }
}
