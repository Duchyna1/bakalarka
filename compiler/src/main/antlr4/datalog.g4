// http://lab.antlr.org/ inspirovane 9.10. 2025
// https://github.com/antlr/grammars-v4/blob/master/prolog/prolog.g4
// https://sicstus.sics.se/sicstus/docs/3.7.1/html/sicstus_45.html

grammar datalog;

QUERY_MARKER: '?-';
BODY_HEAD_SEPARATOR: ':-';
SLC: '%';
MLC_START: '/*';
MLC_END: '*/';
EOL: '.';
NOT: '\\+';
BUILT_IN: '$';

program: (clause | definition)* query;

query: QUERY_MARKER (normal_predicate | normal_built_in_predicate) EOL;

normal_built_in_predicate:   BUILT_IN name '(' ')'|
                             BUILT_IN name '(' parameter (',' parameter)* ')';
negative_built_in_predicate: NOT normal_built_in_predicate;
built_in_predicate:          normal_built_in_predicate | negative_built_in_predicate;
    
parameter: '[' ']' |
           '[' parameter (',' parameter)* ']' |
           normal_predicate |
           normal_built_in_predicate |
           term;

normal_predicate:   name '(' ')' |
                    name '(' term (',' term)* ')';
negative_predicate: NOT normal_predicate;
predicate:          normal_predicate | negative_predicate;

clause: name '(' ')' BODY_HEAD_SEPARATOR (predicate | built_in_predicate) (',' (predicate | built_in_predicate))* EOL |
        name '(' term (',' term)* ')' BODY_HEAD_SEPARATOR (predicate | built_in_predicate) (',' (predicate | built_in_predicate))* EOL;

definition: name BODY_HEAD_SEPARATOR '{' '}' EOL |
            name BODY_HEAD_SEPARATOR '{' term_tuple (',' term_tuple)* '}' EOL;

term_tuple: '(' ')' |
            '(' term (',' term)* ')';

term: variable |
      function '(' ')' |
      function '(' term (',' term)* ')';

name: LOWER (LOWER | NUMBER | '_')*;
function: LOWER (LOWER | NUMBER | '_')*;
variable: UPPER (UPPER | NUMBER | '_')*;

UPPER: [A-Z]+;
LOWER: [a-z]+;
NUMBER: [0-9]+;

WS: [ \t\r\n]+ -> skip;
COMMENT: SLC ~[\n\r]* ([\n\r] | EOF) -> channel(HIDDEN);
MULTILINE_COMMENT:
	MLC_START (MULTILINE_COMMENT | .)*? (MLC_END | EOF) -> channel(HIDDEN);