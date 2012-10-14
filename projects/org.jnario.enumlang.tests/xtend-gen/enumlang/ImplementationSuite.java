package enumlang;

import enumlang.specs.CompileActionSpec;
import enumlang.specs.EnumCompilerSpec;
import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;

@RunWith(ExampleGroupRunner.class)
@Named("Implementation")
@Contains({ CompileActionSpec.class, EnumCompilerSpec.class })
@SuppressWarnings("all")
public class ImplementationSuite {
}
