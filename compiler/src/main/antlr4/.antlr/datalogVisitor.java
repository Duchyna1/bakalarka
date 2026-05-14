// Generated from datalog.g4 by ANTLR 4.9.2
package compiler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link datalogParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface datalogVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link datalogParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(datalogParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link datalogParser#query}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuery(datalogParser.QueryContext ctx);
	/**
	 * Visit a parse tree produced by {@link datalogParser#normal_built_in_predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormal_built_in_predicate(datalogParser.Normal_built_in_predicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link datalogParser#negative_built_in_predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegative_built_in_predicate(datalogParser.Negative_built_in_predicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link datalogParser#built_in_predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuilt_in_predicate(datalogParser.Built_in_predicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link datalogParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(datalogParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link datalogParser#normal_predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNormal_predicate(datalogParser.Normal_predicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link datalogParser#negative_predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegative_predicate(datalogParser.Negative_predicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link datalogParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(datalogParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link datalogParser#clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClause(datalogParser.ClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link datalogParser#definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefinition(datalogParser.DefinitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link datalogParser#term_tuple}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm_tuple(datalogParser.Term_tupleContext ctx);
	/**
	 * Visit a parse tree produced by {@link datalogParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(datalogParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link datalogParser#name}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitName(datalogParser.NameContext ctx);
	/**
	 * Visit a parse tree produced by {@link datalogParser#function}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(datalogParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link datalogParser#variable}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(datalogParser.VariableContext ctx);
}