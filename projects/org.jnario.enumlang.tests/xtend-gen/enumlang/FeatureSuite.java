package enumlang;

import enumlang.features.CompilingEnumerationsFeature;
import org.jnario.runner.Contains;
import org.jnario.runner.ExampleGroupRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;

@RunWith(ExampleGroupRunner.class)
@Named("Feature")
@Contains(CompilingEnumerationsFeature.class)
@SuppressWarnings("all")
public class FeatureSuite {
}
