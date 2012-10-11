package enumlang;

import enumlang.FeatureSuite;
import enumlang.ImplementationSuite;
import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;

@RunWith(ExampleGroupRunner.class)
@Named("Enum Compilation")
@Contains({ FeatureSuite.class, ImplementationSuite.class })
@SuppressWarnings("all")
public class EnumCompilationSuite {
}
