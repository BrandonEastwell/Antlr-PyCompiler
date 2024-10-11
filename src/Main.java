import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    public PyExprParser readFileIntoParser(String filename) throws IOException {
        CharStream in = CharStreams.fromFileName(filename);
        PyExprLexer lexer = new PyExprLexer(in);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        return new PyExprParser(tokens);
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Main main = new Main();
        PyExprParser parser = main.readFileIntoParser("./src/test3.txt");
        //initialize parser listener
        PyExprBaseListener listener = new PyExprBaseListener();
        parser.addParseListener(listener);

        ParseTree parseTree = parser.statements(); //launch parsing
        System.out.println(listener.getPythonCode()); //print code output to console
        listener.writeToFile("output.py"); //write output to file

        //display GUI parse tree
        DisplayParseTree.printTree(parseTree);

        //AST
        PyExprParser ASTParser = main.readFileIntoParser("./src/test3.txt");
        String parserName = "PyExprParser";
        ClassLoader cl = Thread.currentThread().getContextClassLoader();
        Class<? extends Parser> parserClass = null;
        parserClass = cl.loadClass(parserName).asSubclass(Parser.class);

        String startRuleName = "statements";
        Method startRule = parserClass.getMethod(startRuleName);
        ParserRuleContext tree = (ParserRuleContext)startRule.invoke(ASTParser, (Object[])null);
        System.out.println(tree.toStringTree(ASTParser));

    }
}
