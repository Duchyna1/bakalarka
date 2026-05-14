// Generated from datalog.g4 by ANTLR 4.9.2
package compiler;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link datalogParser}.
 */
public interface datalogListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link datalogParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(datalogParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link datalogParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(datalogParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link datalogParser#query}.
	 * @param ctx the parse tree
	 */
	void enterQuery(datalogParser.QueryContext ctx);
	/**
	 * Exit a parse tree produced by {@link datalogParser#query}.
	 * @param ctx the parse tree
	 */
	void exitQuery(datalogParser.QueryContext ctx);
	/**
	 * Enter a parse tree produced by {@link datalogParser#normal_built_in_predicate}.
	 * @param ctx the parse tree
	 */
	void enterNormal_built_in_predicate(datalogParser.Normal_built_in_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link datalogParser#normal_built_in_predicate}.
	 * @param ctx the parse tree
	 */
	void exitNormal_built_in_predicate(datalogParser.Normal_built_in_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link datalogParser#negative_built_in_predicate}.
	 * @param ctx the parse tree
	 */
	void enterNegative_built_in_predicate(datalogParser.Negative_built_in_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link datalogParser#negative_built_in_predicate}.
	 * @param ctx the parse tree
	 */
	void exitNegative_built_in_predicate(datalogParser.Negative_built_in_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link datalogParser#built_in_predicate}.
	 * @param ctx the parse tree
	 */
	void enterBuilt_in_predicate(datalogParser.Built_in_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link datalogParser#built_in_predicate}.
	 * @param ctx the parse tree
	 */
	void exitBuilt_in_predicate(datalogParser.Built_in_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link datalogParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(datalogParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link datalogParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(datalogParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link datalogParser#normal_predicate}.
	 * @param ctx the parse tree
	 */
	void enterNormal_predicate(datalogParser.Normal_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link datalogParser#normal_predicate}.
	 * @param ctx the parse tree
	 */
	void exitNormal_predicate(datalogParser.Normal_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link datalogParser#negative_predicate}.
	 * @param ctx the parse tree
	 */
	void enterNegative_predicate(datalogParser.Negative_predicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link datalogParser#negative_predicate}.
	 * @param ctx the parse tree
	 */
	void exitNegative_predicate(datalogParser.Negative_predicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link datalogParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(datalogParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link datalogParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(datalogParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link datalogParser#clause}.
	 * @param ctx the parse tree
	 */
	void enterClause(datalogParser.ClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link datalogParser#clause}.
	 * @param ctx the parse tree
	 */
	void exitClause(datalogParser.ClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link datalogParser#definition}.
	 * @param ctx the parse tree
	 */
	void enterDefinition(datalogParser.DefinitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link datalogParser#definition}.
	 * @param ctx the parse tree
	 */
	void exitDefinition(datalogParser.DefinitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link datalogParser#term_tuple}.
	 * @param ctx the parse tree
	 */
	void enterTerm_tuple(datalogParser.Term_tupleContext ctx);
	/**
	 * Exit a parse tree produced by {@link datalogParser#term_tuple}.
	 * @param ctx the parse tree
	 */
	void exitTerm_tuple(datalogParser.Term_tupleContext ctx);
	/**
	 * Enter a parse tree produced by {@link datalogParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(datalogParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link datalogParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(datalogParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link datalogParser#name}.
	 * @param ctx the parse tree
	 */
	void enterName(datalogParser.NameContext ctx);
	/**
	 * Exit a parse tree produced by {@link datalogParser#name}.
	 * @param ctx the parse tree
	 */
	void exitName(datalogParser.NameContext ctx);
	/**
	 * Enter a parse tree produced by {@link datalogParser#function}.
	 * @param ctx the parse tree
	 */
	void enterFunction(datalogParser.FunctionContext ctx);
	/**
	 * Exit a parse tree produced by {@link datalogParser#function}.
	 * @param ctx the parse tree
	 */
	void exitFunction(datalogParser.FunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link datalogParser#variable}.
	 * @param ctx the parse tree
	 */
	void enterVariable(datalogParser.VariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link datalogParser#variable}.
	 * @param ctx the parse tree
	 */
	void exitVariable(datalogParser.VariableContext ctx);
}