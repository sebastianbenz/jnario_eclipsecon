package enumlang.features;

import enumlang.features.CompilingEnumerationsFeatureCompilingASingleFile;
import enumlang.features.CompilingEnumerationsFeatureCompilingMultipleEnumerations;
import org.jnario.runner.Contains;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;

@RunWith(FeatureRunner.class)
@Contains({ CompilingEnumerationsFeatureCompilingASingleFile.class, CompilingEnumerationsFeatureCompilingMultipleEnumerations.class })
@Named("Compiling Enumerations")
@SuppressWarnings("all")
public class CompilingEnumerationsFeature {
}
