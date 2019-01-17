grammar Edgelang;

INTEGER
    : SIGN? DIGIT+
    ;

SIGN
    : '+' | '-'
    ;

DIGIT
    : [0-9]
    ;

WS
    : ' ' -> skip
    ;
