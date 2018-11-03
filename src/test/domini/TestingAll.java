package test.domini;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses(value = { TestingAdd.class,
        TestingMultiply.class,
        TestingSubtract.class,
        TestingDivide.class })
public class TestingAll {}
