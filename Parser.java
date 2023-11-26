public sealed interface Parser permits StandardParser ,VariableParser{
    Formule parse(String filePath);

}
