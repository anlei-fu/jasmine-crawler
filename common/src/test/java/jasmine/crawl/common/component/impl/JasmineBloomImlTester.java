package jasmine.crawl.common.component.impl;

import com.jasmine.crawler.common.component.impl.JasmineBloomFilterImpl;
import org.junit.Test;

public class JasmineBloomImlTester {

    @Test
    public void test() throws Exception {
        JasmineBloomFilterImpl bloomFilter = new JasmineBloomFilterImpl();
        bloomFilter.init(2000000, 0.35d);
        try {
            System.out.println(bloomFilter.add("123"));
            System.out.println(bloomFilter.add("123"));
            String dump = bloomFilter.dump();
            System.out.println(dump.length());
            bloomFilter = new JasmineBloomFilterImpl();
            bloomFilter.load(dump);
            System.out.println(bloomFilter.add("123"));
            System.out.println(bloomFilter.add("123"));
        } catch (Exception ex) {

        }
    }
}
