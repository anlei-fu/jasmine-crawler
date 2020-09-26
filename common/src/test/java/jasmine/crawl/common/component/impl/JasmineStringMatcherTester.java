package jasmine.crawl.common.component.impl;

import com.jasmine.crawler.common.component.impl.JasmineStringMatcher;
import com.jasmine.crawler.common.util.TestUtils;
import org.junit.Test;

public class JasmineStringMatcherTester {

    @Test
    public void test() {
        JasmineStringMatcher matcher = new JasmineStringMatcher("^1.*3$");
        TestUtils.print(matcher.match("123448"));
    }
}
