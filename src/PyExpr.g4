grammar PyExpr;

//LEXER RULES
VAR        : 'var';
AND        : 'and';
BREAK      : 'break';
CASE       : 'case';
CONTINUE   : 'continue';
DEF        : 'def';
ELIF       : 'elif';
ELSE       : 'else';
FINALLY    : 'finally';
FOR        : 'for';
FROM       : 'from';
IF         : 'if';
RETURN     : 'return';
WHILE      : 'while';
PRINT      : 'print';

OPEN_PAREN         : '(';
CLOSE_PAREN        : ')';
COMMA              : ',';
COLON              : ':';
ASSIGN             : '=';
ADD_ASSIGN         : '+=';
SUB_ASSIGN         : '-=';
MULT_ASSIGN        : '*=';
DIV_ASSIGN         : '/=';
MOD_ASSIGN         : '%=';
OPEN_BRACK         : '[';
CLOSE_BRACK        : ']';
OR_OP              : '|';
XOR                : '^';
AND_OP             : '&';
OPEN_BRACE         : '{';
CLOSE_BRACE        : '}';

LESS_THAN          : '<';
GREATER_THAN       : '>';
GREATER_THAN_EQUALS: '>=';
LESS_THAN_EQUALS   : '<=';
EQUALS             : '==';

ADD                : '+';
MINUS              : '-';
DIV                : '/';
MOD                : '%';
MULT               : '*';

WS: [ \t\r\n]+ -> skip;

INT_TYPE: 'int';
FLOAT_TYPE: 'float';

ID: LETTER+;
FLOAT: POINT_FLOAT;
INTEGER: DIGIT+;
UNKNOWN_CHAR: .;
NEWLINE: ([ \t]+ | ( '\r'? '\n' | '\r' | '\f') [ \t]+?);


//FRAGMENTS
fragment DIGIT : [0-9];
fragment FRACTION: '.' DIGIT+;
fragment POINT_FLOAT: INTEGER? FRACTION | INTEGER '.';
fragment LETTER : [A-Za-z];
fragment STRING: ;


//PARSER RULES
statements: statement+;

statement: control_flow  | simple_stmts;

statement_newline:
    | control_flow NEWLINE
    | simple_stmts
    | NEWLINE
    ;

simple_stmts
    : simple_stmt (';' simple_stmt)* ';'? //sequencing support
    ;

simple_stmt
    : (
        declaration
        | assignment
        | print_statement
        | flow_stmt
        | block
    )
    ;

declaration: VAR ID (COLON type)?;

assignment: (VAR)? ID augassign expr;

type: INT_TYPE | FLOAT_TYPE;

augassign: ASSIGN | ADD_ASSIGN | DIV_ASSIGN | MOD_ASSIGN | MULT_ASSIGN | SUB_ASSIGN;

//control flow statements
control_flow
    : function_stmt
    | if_stmt
    | while_stmt
    | for_stmt
    | try_stmt
    ;

if_stmt
    : IF expr (comparison_op expr)* block (ELIF expr (comparison_op expr)*  block)* (ELSE block)?
    ;
while_stmt
    : WHILE expr (comparison_op expr)* block (ELSE block)?
    ;
for_stmt
    : FOR exprlist 'in' testlist block (ELSE block)?
    ;
function_stmt
    : DEF ID '(' parameters? ')' block
    ;

parameters: ID (COMMA ID)*;

//error handling
try_stmt
    : (
        'try' ':' block (
            (except_clause ':' block)+ (ELSE ':' block)? (FINALLY ':' block)?
            | FINALLY ':' block
        )
    )
    ;

except_clause
    : 'except' (expr (comparison_op expr)* ('as' ID)?)?
    ;

flow_stmt
    : break
    | continue
    | return
    ;

break
    : BREAK
    ;

continue
    : CONTINUE
    ;

return
    : RETURN testlist?
    ;

print_statement: PRINT expr;

block: OPEN_BRACE statement+ CLOSE_BRACE;

comparison_op
    : LESS_THAN
    | GREATER_THAN
    | EQUALS
    | GREATER_THAN_EQUALS
    | LESS_THAN_EQUALS
    ;

star_expr
    : '*' expr
    ;

expr
    : (ADD | MINUS)+ expr
    | expr (MULT | DIV | MOD) expr
    | expr (ADD | MINUS) expr
    | INTEGER
    | FLOAT
    | ID
    ;

exprlist
    : (expr | star_expr) (',' (expr | star_expr))* ','?
    ;

testlist
    : expr (comparison_op expr)* (',' expr (comparison_op expr)*)* ','?
    ;
