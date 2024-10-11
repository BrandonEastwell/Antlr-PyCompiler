// Generated from C:/Users/Test/Documents/Project files/CE305 Assignment 2 Python Compiler/src/PyExpr.g4 by ANTLR 4.13.1
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link PyExprListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
@SuppressWarnings("CheckReturnValue")
public class PyExprBaseListener implements PyExprListener {
	private final StringBuilder pythonCode = new StringBuilder();
	private final SymbolTable symbolTable = new SymbolTable();
	private boolean inCondition = false;
	private int currentIndentLevel = 0;
	private static final String INDENT = "    "; // Four spaces for indentation
	@Override
	public void enterPrint_statement(PyExprParser.Print_statementContext ctx) {
		appendIndent();
		pythonCode.append("print(");
	}

	@Override
	public void exitPrint_statement(PyExprParser.Print_statementContext ctx) {
		pythonCode.append(ctx.expr().getChild(0).getText()).append(")\n");
	}

	@Override
	public void enterStatements(PyExprParser.StatementsContext ctx) {

	}

	@Override
	public void exitStatements(PyExprParser.StatementsContext ctx) {

	}

	@Override
	public void enterStatement(PyExprParser.StatementContext ctx) {

	}

	@Override
	public void exitStatement(PyExprParser.StatementContext ctx) {

	}

	@Override
	public void enterStatement_newline(PyExprParser.Statement_newlineContext ctx) {

	}

	@Override
	public void exitStatement_newline(PyExprParser.Statement_newlineContext ctx) {

	}

	@Override
	public void enterSimple_stmts(PyExprParser.Simple_stmtsContext ctx) {
		System.out.println("simple stmts");
	}

	@Override
	public void exitSimple_stmts(PyExprParser.Simple_stmtsContext ctx) {
	}

	@Override
	public void enterSimple_stmt(PyExprParser.Simple_stmtContext ctx) {
	}

	@Override
	public void exitSimple_stmt(PyExprParser.Simple_stmtContext ctx) {
	}

	@Override
	public void exitDeclaration(PyExprParser.DeclarationContext ctx) {
		System.out.println("declaration");
		String varName = ctx.ID().getText();
		TerminalNode typeNode = (TerminalNode) ctx.type().getChild(0);
		switch(typeNode.getSymbol().getType()) {
			case PyExprLexer.INT_TYPE:
				symbolTable.addSymbol(varName, "int");
			case PyExprLexer.FLOAT_TYPE:

		}
	}

	@Override
	public void enterDeclaration(PyExprParser.DeclarationContext ctx) {

	}

	@Override
	public void exitAssignment(PyExprParser.AssignmentContext ctx) {
		String varName = ctx.ID().getText();
		System.out.println(varName);
		appendIndent();
		pythonCode.append(varName).append(" ").append(ctx.augassign().getChild(0).getText()).append(" ");
		processExpr(ctx.expr(), varName);
		pythonCode.append("\n");
	}

	public void processExpr(PyExprParser.ExprContext expr, String varName) {
		for ( ParseTree exprNode : expr.children ) {
			if (exprNode instanceof TerminalNode && exprNode instanceof PyExprParser.ExprContext) {
				TerminalNode terminalNode = (TerminalNode) exprNode;
				int tokenType = terminalNode.getSymbol().getType();
				String tokenValue = terminalNode.getText(); // Get the text value of the terminal node
				if (symbolTable.containsSymbol(varName)) {
					switch (tokenType) {
						case PyExprLexer.INTEGER:
							if (Objects.equals(symbolTable.getType(varName), "int")) {
								pythonCode.append(tokenValue);
							} else {
								System.err.println("Error: expression does not match type int");
							}
							break;
						case PyExprLexer.FLOAT:
							if (Objects.equals(symbolTable.getType(varName), "float")) {
								pythonCode.append(tokenValue);
							} else {
								System.err.println("Error: expression does not match type float");
							}
							break;
						case PyExprLexer.ID:
							if (Objects.equals(symbolTable.getType(varName), symbolTable.getType(tokenValue))) {
								pythonCode.append(tokenValue);
							} else {
								System.err.println("Error: expression does not match type float");
							}
							break;
					}
				} else {
					switch (tokenType) {
						case PyExprLexer.INTEGER:
							symbolTable.addSymbol(varName, "int");
							break;
						case PyExprLexer.FLOAT:
							symbolTable.addSymbol(varName, "float");
							break;
						case PyExprLexer.ID:
							try {
								symbolTable.addSymbol(varName, symbolTable.getType(tokenValue));
							} catch (Exception ignored) {
								System.err.println("Error: expression " + tokenValue + " does not exist");
							}
							break;
					}
					pythonCode.append(tokenValue);
				}
			} else if (!(exprNode instanceof PyExprParser.ExprContext) && exprNode instanceof TerminalNode) {
				TerminalNode terminalNode = (TerminalNode) exprNode;
				pythonCode.append(terminalNode.getText());
			} else if (exprNode instanceof ParserRuleContext) {
				processExpr((PyExprParser.ExprContext) exprNode, varName);
			}
		}
	}

	@Override
	public void enterAssignment(PyExprParser.AssignmentContext ctx) {
		System.out.println("assignment");

	}

	@Override
	public void enterType(PyExprParser.TypeContext ctx) {

	}

	@Override
	public void exitType(PyExprParser.TypeContext ctx) {

	}

	@Override
	public void enterAugassign(PyExprParser.AugassignContext ctx) {
		System.out.println("augassign");

	}

	@Override
	public void exitAugassign(PyExprParser.AugassignContext ctx) {

	}

	@Override
	public void enterControl_flow(PyExprParser.Control_flowContext ctx) {
		System.out.println("control_flow");

	}

	@Override
	public void exitControl_flow(PyExprParser.Control_flowContext ctx) {

	}

	@Override
	public void enterIf_stmt(PyExprParser.If_stmtContext ctx) {
		System.out.println("if_stmt");
		inCondition = true;
		appendIndent();
		pythonCode.append("if");
	}

	@Override
	public void exitIf_stmt(PyExprParser.If_stmtContext ctx) {
		inCondition = false;
	}

	@Override
	public void exitWhile_stmt(PyExprParser.While_stmtContext ctx) {
		inCondition = false;
	}

	@Override
	public void enterWhile_stmt(PyExprParser.While_stmtContext ctx) {
		System.out.println("While_stmt");
		inCondition = true;
		appendIndent();
		pythonCode.append("while");
	}

	@Override
	public void enterFor_stmt(PyExprParser.For_stmtContext ctx) {
		System.out.println("For_stmt");
		appendIndent();
		pythonCode.append("for");
		//pythonCode.append("for ").append(ctx.exprlist().getText()).append(" in ").append(ctx.testlist().getText()).append(":\n");
	}

	@Override
	public void exitFor_stmt(PyExprParser.For_stmtContext ctx) {

	}

	@Override
	public void enterFunction_stmt(PyExprParser.Function_stmtContext ctx) {
		symbolTable.enterScope();
	}

	@Override
	public void exitFunction_stmt(PyExprParser.Function_stmtContext ctx) {
		symbolTable.exitScope();
	}

	@Override
	public void enterParameters(PyExprParser.ParametersContext ctx) {

	}

	@Override
	public void exitParameters(PyExprParser.ParametersContext ctx) {

	}

	@Override
	public void enterTry_stmt(PyExprParser.Try_stmtContext ctx) {
		pythonCode.append("try:\n");
	}

	@Override
	public void exitTry_stmt(PyExprParser.Try_stmtContext ctx) {

	}

	@Override
	public void enterExcept_clause(PyExprParser.Except_clauseContext ctx) {
		pythonCode.append("except ").append(ctx.expr()).append(":\n");
	}

	@Override
	public void exitExcept_clause(PyExprParser.Except_clauseContext ctx) {

	}

	@Override
	public void enterFlow_stmt(PyExprParser.Flow_stmtContext ctx) {

	}

	@Override
	public void exitFlow_stmt(PyExprParser.Flow_stmtContext ctx) {

	}

	@Override
	public void enterBreak(PyExprParser.BreakContext ctx) {
		pythonCode.append("break;\n");
	}

	@Override
	public void exitBreak(PyExprParser.BreakContext ctx) {

	}

	@Override
	public void enterContinue(PyExprParser.ContinueContext ctx) {
		pythonCode.append("continue;\n");
	}

	@Override
	public void exitContinue(PyExprParser.ContinueContext ctx) {

	}

	@Override
	public void enterReturn(PyExprParser.ReturnContext ctx) {
		pythonCode.append("return").append(ctx.testlist() != null ? " " + ctx.testlist().getText() : "").append(";\n");
	}

	@Override
	public void exitReturn(PyExprParser.ReturnContext ctx) {

	}
	public void findExpr(ParseTree tree) {
		for (int i = 0; i < tree.getChildCount(); i++) {
			ParseTree node = tree.getChild(i);
			if (node instanceof PyExprParser.ExprContext) {
				pythonCode.append(" ").append(node.getChild(0).getText());
			} else if (node instanceof PyExprParser.Comparison_opContext) {
				pythonCode.append(" ").append(node.getChild(0).getText());
				findExpr(node);
			}
		}
	}
 	@Override
	public void enterBlock(PyExprParser.BlockContext ctx) {
		//in if or while condition
		if (inCondition) {
			//checks for instances of else & elif clauses
			//this works when entering an else or elif block inside if or while stmt block
			//token has been processed and accessible
			boolean clause;
			switch (ctx.parent) {
				case PyExprParser.If_stmtContext StmtContext:
					clause = false;
					for (int i = 0; i < StmtContext.getChildCount(); i++) {
						ParseTree child = StmtContext.getChild(i);
						if (child instanceof TerminalNode terminalNode) {
							if (terminalNode.getSymbol().getType() == PyExprLexer.ELSE) {
								// Found an ELSE token
								appendIndent();
								pythonCode.append("else");
								clause = true;
								break;
							} else if (terminalNode.getSymbol().getType() == PyExprLexer.ELIF) {
								// Found an ELIF token
								appendIndent();
								pythonCode.append("elif");
								findExpr(ctx.parent);
								clause = true;
								break;
							}
						}
					}
					if (!clause) {
						findExpr(ctx.parent);
					}
					break;
				case PyExprParser.While_stmtContext StmtContext:
					clause = false;
					for (int i = 0; i < StmtContext.getChildCount(); i++) {
						ParseTree child = StmtContext.getChild(i);
						if (child instanceof TerminalNode terminalNode) {
							if (terminalNode.getSymbol().getType() == PyExprLexer.ELSE) {
								// Found an ELSE token
								appendIndent();
								clause = true;
								pythonCode.append("else");
								break;
							}
						}
					}
					if (!clause) {
						findExpr(ctx.parent);
					}
					break;
				case PyExprParser.For_stmtContext stmtContext:
					break;
				case PyExprParser.Function_stmtContext stmtContext:
					break;
				default:
					findExpr(ctx.parent);
			}
			pythonCode.append(": ");
		}
		pythonCode.append("\n");
		currentIndentLevel++;
	}

	@Override
	public void exitBlock(PyExprParser.BlockContext ctx) {
		currentIndentLevel--;
	}

	@Override
	public void enterComparison_op(PyExprParser.Comparison_opContext ctx) {

	}

	@Override
	public void exitComparison_op(PyExprParser.Comparison_opContext ctx) {

	}

	@Override
	public void enterStar_expr(PyExprParser.Star_exprContext ctx) {

	}

	@Override
	public void exitStar_expr(PyExprParser.Star_exprContext ctx) {

	}

	@Override
	public void exitExpr(PyExprParser.ExprContext ctx) {

	}

	@Override
	public void enterExpr(PyExprParser.ExprContext ctx) {

	}

	@Override
	public void enterExprlist(PyExprParser.ExprlistContext ctx) {

	}

	@Override
	public void exitExprlist(PyExprParser.ExprlistContext ctx) {

	}

	@Override
	public void enterTestlist(PyExprParser.TestlistContext ctx) {

	}

	@Override
	public void exitTestlist(PyExprParser.TestlistContext ctx) {

	}

	@Override
	public void visitTerminal(TerminalNode terminalNode) {

	}

	@Override
	public void visitErrorNode(ErrorNode errorNode) {

	}

	@Override
	public void enterEveryRule(ParserRuleContext parserRuleContext) {

	}

	@Override
	public void exitEveryRule(ParserRuleContext parserRuleContext) {

	}
	private void appendIndent() {
		pythonCode.append(INDENT.repeat(Math.max(0, currentIndentLevel)));
	}
	public String getPythonCode() {
		return pythonCode.toString();
	}
	public void writeToFile(String filename) {
		try (FileWriter writer = new FileWriter(filename)) {
			writer.write(getPythonCode());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}