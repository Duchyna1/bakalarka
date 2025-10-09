// http://lab.antlr.org/
// inspirovane 9.10. 2025
// https://github.com/antlr/grammars-v4/blob/master/prolog/prolog.g4
// https://sicstus.sics.se/sicstus/docs/3.7.1/html/sicstus_45.html

grammar Prolog;

QUERY_MARKER        : '?-'; //z cvik prebrate
BODY_HEAD_SEPARAOTR : ':-';
SLC                 : '%';
MLC_START           : '/*';
MLC_END             : '*/';
EOL                 : '.';

program
    : (fact | clause)* query EOF //povynna query lebo v relacnej mame vzdy nejaky vysledok
    ;

query
    : QUERY_MARKER term EOL
    ;

clause
    : head BODY_HEAD_SEPARAOTR body EOL
    ;

fact
    : term EOL
    ;

head
    : term
    ;

body
    : term
    | term ',' body
    | negative_term ',' body
    | negative_term
    ;

negative_term
    : NOT term
    ;

term
    : atom                      // constant
    | name '(' term_list ')'    // function symbol with parameters
    | '(' term ')'
    ;

term_list
    : term (',' term)*
    ;

name
    : atom
    ;

atom
    : TOKEN
    ;

NOT               : '\\+';
TOKEN             : [a-zA-Z0-9_]+;
WS                : [ \t\r\n]+ -> skip;
COMMENT           : SLC ~[\n\r]* ([\n\r] | EOF) -> channel(HIDDEN);
MULTILINE_COMMENT : MLC_START (MULTILINE_COMMENT | .)*? (MLC_END | EOF) -> channel(HIDDEN);