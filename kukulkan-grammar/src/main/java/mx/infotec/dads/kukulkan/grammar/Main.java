package mx.infotec.dads.kukulkan.grammar;

import java.io.IOException;

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {

    private static final String EXTENSION = "3k";

    public static void main(String[] args) throws IOException {
        String program = args.length > 1 ? args[1] : "test/test." + EXTENSION;

        System.out.println("Interpreting file " + program);

        kukulkanLexer lexer = new kukulkanLexer(new ANTLRFileStream(program));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        kukulkanParser parser = new kukulkanParser(tokens);

        kukulkanParser.DomainModelContext tree = parser.domainModel();

        kukulkanCustomVisitor visitor = new kukulkanCustomVisitor();
        visitor.visit(tree);
        System.out.println("Interpretation finished");
    }

}
