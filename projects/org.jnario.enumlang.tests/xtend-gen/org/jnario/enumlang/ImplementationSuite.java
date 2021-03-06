package org.jnario.enumlang;

import org.jnario.enumlang.specs.CompileActionSpec;
import org.jnario.enumlang.specs.EnumCompilerSpec;
import org.jnario.enumlang.specs.EnumParserSpec;
import org.jnario.enumlang.specs.TestFeature;
import org.jnario.enumlang.specs.TestSpec;
import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;

@RunWith(ExampleGroupRunner.class)
@Named("Implementation")
@Contains({ CompileActionSpec.class, EnumCompilerSpec.class, EnumParserSpec.class, TestSpec.class, TestFeature.class })
@SuppressWarnings("all")
public class ImplementationSuite {
}
