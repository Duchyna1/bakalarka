import datalog.DatalogProgram;
import ra.RAExpr;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;


public class TranslateDatalogFile {
    public static void main(String[] args) throws Exception {
        MyErrorListener errorListener = new MyErrorListener();

        CharStream program = CharStreams.fromStream(System.in);
        datalogLexer lexer = new datalogLexer(program);
        lexer.removeErrorListeners();
        lexer.addErrorListener(errorListener);

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        datalogParser parser = new datalogParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(errorListener);

        ParseTree tree = parser.program();
        if (errorListener.hasErrors()) {
            throw new IllegalArgumentException("Input contains syntax errors.");
        }

        DatalogASTBuilder astBuilder = new DatalogASTBuilder();
        DatalogProgram ast = (DatalogProgram) astBuilder.visit(tree);

        DatalogCompiler compiler = new DatalogCompiler();
        RAExpr compiled = compiler.compile(ast);

        System.out.print(compiled);
    }
}
