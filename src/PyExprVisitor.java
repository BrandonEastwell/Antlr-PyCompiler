// Generated from C:/Users/Test/Documents/Project files/CE305 Assignment 2 Python Compiler/src/PyExpr.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link PyExprParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface PyExprVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link PyExprParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(PyExprParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(PyExprParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#statement_newline}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement_newline(PyExprParser.Statement_newlineContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#simple_stmts}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_stmts(PyExprParser.Simple_stmtsContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#simple_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimple_stmt(PyExprParser.Simple_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(PyExprParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(PyExprParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(PyExprParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#augassign}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAugassign(PyExprParser.AugassignContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#control_flow}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControl_flow(PyExprParser.Control_flowContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#if_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf_stmt(PyExprParser.If_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#while_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile_stmt(PyExprParser.While_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#for_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor_stmt(PyExprParser.For_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#function_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction_stmt(PyExprParser.Function_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(PyExprParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#try_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTry_stmt(PyExprParser.Try_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#except_clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcept_clause(PyExprParser.Except_clauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#flow_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFlow_stmt(PyExprParser.Flow_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#break}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBreak(PyExprParser.BreakContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#continue}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContinue(PyExprParser.ContinueContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#return}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturn(PyExprParser.ReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#print_statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint_statement(PyExprParser.Print_statementContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(PyExprParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#comparison_op}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison_op(PyExprParser.Comparison_opContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#star_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStar_expr(PyExprParser.Star_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(PyExprParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#exprlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprlist(PyExprParser.ExprlistContext ctx);
	/**
	 * Visit a parse tree produced by {@link PyExprParser#testlist}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTestlist(PyExprParser.TestlistContext ctx);
}