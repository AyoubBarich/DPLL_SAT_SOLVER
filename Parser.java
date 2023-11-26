import java.io.FileNotFoundException;

public sealed interface Parser permits StandardParser ,VariableParser{
    Formule parse(String filePath) throws FileNotFoundException;

}
