import datalog.DatalogProgram;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.nio.file.Path;


public class TranslateDatalogFile {
    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            throw new IllegalArgumentException("Please provide the path to a Datalog file as an argument.");
        }
        String pathArg = args[0];
        Path inputPath = Path.of(pathArg);

        MyErrorListener errorListener = new MyErrorListener();

        CharStream program = CharStreams.fromPath(inputPath);
        datalogLexer lexer = new datalogLexer(program);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        datalogParser parser = new datalogParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        ParseTree tree = parser.program();
        if (errorListener.hasErrors()) {
            throw new IllegalArgumentException("Input contains syntax errors: " + inputPath);
        }

        DatalogASTBuilder astBuilder = new DatalogASTBuilder();
        DatalogProgram ast = (DatalogProgram) astBuilder.visit(tree);

        DatalogCompiler compiler = new DatalogCompiler();
        CompiledRAProgram compiled = compiler.compile(ast);

        System.out.println("Input file: " + inputPath);
        System.out.println("--- Compiled relational algebra ---");
        System.out.print(compiled);
    }
}
