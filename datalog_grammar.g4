// http://lab.antlr.org/
// inspirovane 9.10. 2025
// https://github.com/antlr/grammars-v4/blob/master/prolog/prolog.g4
// https://sicstus.sics.se/sicstus/docs/3.7.1/html/sicstus_45.html

grammar Datalog;

QUERY_MARKER        : '?-'; //z cvik prebrate
BODY_HEAD_SEPARATOR : ':-';
SLC                 : '%';
MLC_START           : '/*';
MLC_END             : '*/';
EOL                 : '.';
NOT                 : '\\+';
BUILD_IN            : '$';

program
    : (clause | definition)* query? (clause | definition)*
    ;

query
    : QUERY_MARKER normal_predicate EOL
    ;

clause
    : head BODY_HEAD_SEPARATOR body EOL
    ;

head
    : normal_predicate
    ;

body
    : (predicate | negative_predicate) (',' (predicate | negative_predicate))*
    ;

predicate
    : normal_predicate
    | build_in_predicate
    ;

negative_predicate
    : NOT normal_predicate
    | NOT build_in_predicate
    ;

normal_predicate
    : name
    | name '(' term_list ')'
    ;

build_in_predicate
    : BUILD_IN name
    | BUILD_IN name '(' term_list ')'
    ;

term_list
    : term (',' term)*
    ;

term
    : atom
    | name '(' term_list')'
    ;

definition
    : name '(' term_list ')' BODY_HEAD_SEPARATOR '{' '}' EOL
    | name '(' term_list ')' BODY_HEAD_SEPARATOR '{' facts '}' EOL
    ;

facts
    : fact (',' fact)*
    ;

fact
    : '(' term_list ')'
    ;

atom
    : TOKEN
    ;

name
    : TOKEN
    ;

TOKEN               : [a-zA-Z0-9_]+;
WS                  : [ \t\r\n]+ -> skip;
COMMENT             : SLC ~[\n\r]* ([\n\r] | EOF) -> channel(HIDDEN);
MULTILINE_COMMENT   : MLC_START (MULTILINE_COMMENT | .)*? (MLC_END | EOF) -> channel(HIDDEN);