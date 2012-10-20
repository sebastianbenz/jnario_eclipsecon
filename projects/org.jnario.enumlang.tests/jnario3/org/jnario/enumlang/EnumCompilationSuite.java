package org.jnario.enumlang;

import org.jnario.enumlang.FeatureSuite;
import org.jnario.enumlang.ImplementationSuite;
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
