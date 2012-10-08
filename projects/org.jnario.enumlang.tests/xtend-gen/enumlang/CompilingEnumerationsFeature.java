package enumlang;

import enumlang.CompilingEnumerationsFeatureCompilingASingleFile;
import enumlang.CompilingEnumerationsFeatureCompilingMultipleFiles;
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
