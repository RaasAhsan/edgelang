package javascript

/*
 * It is not necessary to define a complete and exhaustive AST of ECMAScript 2015.
 * A subset of JavaScript is valid JavaScript.
 * Therefore it is sufficient to define the subset of the JavaScript required
 * to compile Edgelang to JavaScript in a lossless fashion.
 */

data class Block(val statements : List<StatementNode>)

sealed class StatementNode

data class ConstDeclarationNode(val name : String, val expr : ExpressionNode) : StatementNode()

data class VarDeclarationNode(val name : String, val expr : ExpressionNode) : StatementNode()

data class LetDeclarationNode(val name : String, val expr : ExpressionNode) : StatementNode()

data class FunctionDeclarationNode(val name : String, val args : List<String>, val body : Block) : StatementNode()

data class IfStatementNode(val condition: ExpressionNode, // This could be more general
                           val thenBody: Block,
                           val elseBody: Block) : StatementNode()

data class WhileLoopNode(val condition: ExpressionNode, val body : Block) : StatementNode()

data class ReturnNode(val expr : ExpressionNode) : StatementNode()

sealed class ExpressionNode

data class AddNode(val lhs: ExpressionNode, val rhs: ExpressionNode) : ExpressionNode()

data class SubtractNode(val lhs : ExpressionNode, val rhs : ExpressionNode) : ExpressionNode()

data class MultiplyNode(val lhs : ExpressionNode, val rhs : ExpressionNode) : ExpressionNode()

data class DivideNode(val lhs : ExpressionNode, val rhs : ExpressionNode) : ExpressionNode()

data class IntegerNode(val value : Int) : ExpressionNode()

data class StringNode(val value : String) : ExpressionNode()

data class BooleanNode(val value : Boolean) : ExpressionNode()

data class AnonymousFunctionNode(val args : List<String>, val body : Block) : ExpressionNode()

data class FunctionInvocation(val name : String, val args : List<String>) : ExpressionNode()

// TODO: Anonymous function invocation? e.g. (function(){})()
