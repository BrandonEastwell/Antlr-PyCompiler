// Generated from C:/Users/Test/Documents/Project files/CE305 Assignment 2 Python Compiler/src/PyExpr.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link PyExprParser}.
 */
public interface PyExprListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link PyExprParser#statements}.
	 * @param ctx the parse tree
	 */
	void enterStatements(PyExprParser.StatementsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#statements}.
	 * @param ctx the parse tree
	 */
	void exitStatements(PyExprParser.StatementsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(PyExprParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(PyExprParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#statement_newline}.
	 * @param ctx the parse tree
	 */
	void enterStatement_newline(PyExprParser.Statement_newlineContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#statement_newline}.
	 * @param ctx the parse tree
	 */
	void exitStatement_newline(PyExprParser.Statement_newlineContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#simple_stmts}.
	 * @param ctx the parse tree
	 */
	void enterSimple_stmts(PyExprParser.Simple_stmtsContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#simple_stmts}.
	 * @param ctx the parse tree
	 */
	void exitSimple_stmts(PyExprParser.Simple_stmtsContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSimple_stmt(PyExprParser.Simple_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#simple_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSimple_stmt(PyExprParser.Simple_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#declaration}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(PyExprParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#declaration}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(PyExprParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(PyExprParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(PyExprParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(PyExprParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(PyExprParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#augassign}.
	 * @param ctx the parse tree
	 */
	void enterAugassign(PyExprParser.AugassignContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#augassign}.
	 * @param ctx the parse tree
	 */
	void exitAugassign(PyExprParser.AugassignContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#control_flow}.
	 * @param ctx the parse tree
	 */
	void enterControl_flow(PyExprParser.Control_flowContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#control_flow}.
	 * @param ctx the parse tree
	 */
	void exitControl_flow(PyExprParser.Control_flowContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIf_stmt(PyExprParser.If_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#if_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIf_stmt(PyExprParser.If_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void enterWhile_stmt(PyExprParser.While_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#while_stmt}.
	 * @param ctx the parse tree
	 */
	void exitWhile_stmt(PyExprParser.While_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFor_stmt(PyExprParser.For_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#for_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFor_stmt(PyExprParser.For_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#function_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFunction_stmt(PyExprParser.Function_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#function_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFunction_stmt(PyExprParser.Function_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(PyExprParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(PyExprParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#try_stmt}.
	 * @param ctx the parse tree
	 */
	void enterTry_stmt(PyExprParser.Try_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#try_stmt}.
	 * @param ctx the parse tree
	 */
	void exitTry_stmt(PyExprParser.Try_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#except_clause}.
	 * @param ctx the parse tree
	 */
	void enterExcept_clause(PyExprParser.Except_clauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#except_clause}.
	 * @param ctx the parse tree
	 */
	void exitExcept_clause(PyExprParser.Except_clauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#flow_stmt}.
	 * @param ctx the parse tree
	 */
	void enterFlow_stmt(PyExprParser.Flow_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#flow_stmt}.
	 * @param ctx the parse tree
	 */
	void exitFlow_stmt(PyExprParser.Flow_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#break}.
	 * @param ctx the parse tree
	 */
	void enterBreak(PyExprParser.BreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#break}.
	 * @param ctx the parse tree
	 */
	void exitBreak(PyExprParser.BreakContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#continue}.
	 * @param ctx the parse tree
	 */
	void enterContinue(PyExprParser.ContinueContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#continue}.
	 * @param ctx the parse tree
	 */
	void exitContinue(PyExprParser.ContinueContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#return}.
	 * @param ctx the parse tree
	 */
	void enterReturn(PyExprParser.ReturnContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#return}.
	 * @param ctx the parse tree
	 */
	void exitReturn(PyExprParser.ReturnContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#print_statement}.
	 * @param ctx the parse tree
	 */
	void enterPrint_statement(PyExprParser.Print_statementContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#print_statement}.
	 * @param ctx the parse tree
	 */
	void exitPrint_statement(PyExprParser.Print_statementContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(PyExprParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(PyExprParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#comparison_op}.
	 * @param ctx the parse tree
	 */
	void enterComparison_op(PyExprParser.Comparison_opContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#comparison_op}.
	 * @param ctx the parse tree
	 */
	void exitComparison_op(PyExprParser.Comparison_opContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#star_expr}.
	 * @param ctx the parse tree
	 */
	void enterStar_expr(PyExprParser.Star_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#star_expr}.
	 * @param ctx the parse tree
	 */
	void exitStar_expr(PyExprParser.Star_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(PyExprParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(PyExprParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#exprlist}.
	 * @param ctx the parse tree
	 */
	void enterExprlist(PyExprParser.ExprlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#exprlist}.
	 * @param ctx the parse tree
	 */
	void exitExprlist(PyExprParser.ExprlistContext ctx);
	/**
	 * Enter a parse tree produced by {@link PyExprParser#testlist}.
	 * @param ctx the parse tree
	 */
	void enterTestlist(PyExprParser.TestlistContext ctx);
	/**
	 * Exit a parse tree produced by {@link PyExprParser#testlist}.
	 * @param ctx the parse tree
	 */
	void exitTestlist(PyExprParser.TestlistContext ctx);
}