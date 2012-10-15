package enumlang.features;

import enumlang.features.CompilingEnumerationsFeatureCompilingASingleFile;
import enumlang.features.CompilingEnumerationsFeatureCompilingMultipleFiles;
import org.jnario.runner.Contains;
import org.jnario.runner.FeatureRunner;
import org.jnario.runner.Named;
import org.junit.runner.RunWith;

@RunWith(FeatureRunner.class)
@Contains({ CompilingEnumerationsFeatureCompilingASingleFile.class, CompilingEnumerationsFeatureCompilingMultipleFiles.class })
@Named("Compiling Enumerations")
@SuppressWarnings("all")
public class CompilingEnumerationsFeature {
}
