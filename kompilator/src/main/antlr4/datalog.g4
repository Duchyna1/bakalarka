// http://lab.antlr.org/ inspirovane 9.10. 2025
// https://github.com/antlr/grammars-v4/blob/master/prolog/prolog.g4
// https://sicstus.sics.se/sicstus/docs/3.7.1/html/sicstus_45.html

grammar datalog;

QUERY_MARKER: '?-'; //z cvik prebrate
BODY_HEAD_SEPARATOR: ':-';
SLC: '%';
MLC_START: '/*';
MLC_END: '*/';
EOL: '.';
NOT: '\\+';
BUILT_IN: '$';

program: (clause | definition)* query? (clause | definition)*;

query: QUERY_MARKER (normal_predicate | normal_built_in_predicate) EOL;

normal_built_in_predicate:  BUILT_IN name '(' ')'|
                            BUILT_IN name '(' parameter (',' parameter)* ')';
negative_buit_in_predicate: NOT normal_built_in_predicate;
built_in_predicate:         normal_built_in_predicate | negative_buit_in_predicate;
    
parameter: '[' parameter (',' parameter)* ']' |
            predicate |
            built_in_predicate |
            term;
            
normal_predicate:   name '(' ')' |
                    name '(' term (',' term)* ')';
negative_predicate: NOT normal_predicate;
predicate:          normal_predicate | negative_predicate;

clause: name '(' ')' BODY_HEAD_SEPARATOR (predicate | built_in_predicate) (',' (predicate | built_in_predicate))* EOL |
        name '(' term (',' term)* ')' BODY_HEAD_SEPARATOR (predicate | built_in_predicate) (',' (predicate | built_in_predicate))* EOL;

definition: name '(' arity ')' BODY_HEAD_SEPARATOR '{' term_tuple (',' term_tuple)* '}' EOL;

term_tuple: '(' term (',' term)* ')';

term: function '(' ')' |
      function '(' term (',' term)* ')' |
      variable;

name: TOKEN;
function: TOKEN;
variable: TOKEN;
arity: NUMBER_TOKEN;

fragment UPPER: [A-Z]+;
fragment LOWER: [a-z]+;
fragment NUMBER: [0-9]+;

TOKEN: (UPPER | LOWER | NUMBER | '_')+;
NUMBER_TOKEN: NUMBER;
WS: [ \t\r\n]+ -> skip;
COMMENT: SLC ~[\n\r]* ([\n\r] | EOF) -> channel(HIDDEN);
MULTILINE_COMMENT:
	MLC_START (MULTILINE_COMMENT | .)*? (MLC_END | EOF) -> channel(HIDDEN);