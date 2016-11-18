[knowledgeBase].
hasNorth(X,Y):- cell(X,Y,true,_,_,_).
hasSouth(X,Y):- cell(X,Y,_,true,_,_).
hasEast(X,Y):- cell(X,Y,_,_,true,_).
hasWest(X,Y):- cell(X,Y,_,_,_,true).
player(Steps, X, Y, S):-  playerLocation(Steps, X, Y, S).

canMove(north, X, Y):- hasNorth(X, Y).
canMove(south, X, Y):- hasSouth(X, Y).
canMove(east, X, Y):-  hasEast(X, Y).
canMove(west, X, Y):-  hasWest(X, Y).


adjCell(X0, Y0, X1, Y1):- (X0 is X1 + 1, Y0 is Y1);
                          (X0 is X1 -1, Y0 is Y1);
                          (X0 is X1, Y0 is Y1 + 1);
                          (X0 is X1, Y0 is Y1 - 1).

test(Px, Py, Gx, Gy, S):- player(_, Px, Py, S), containsPokimon(Gx, Gy, S).
player(Steps, X0, Y0, result(A,S)):- player(Steps1, X1, Y1, S),
                                                (
                                                  (A = north, canMove(north, X1, Y1), X0 is X1, Y0 is Y1 - 1, Steps is Steps1 + 1);
                                                  (A = south, canMove(south, X1, Y1), X0 is X1,  Y0 is Y1 + 1, Steps is Steps1 + 1);
                                                  (A = east, canMove(east, X1, Y1), Y0 is Y1,  X0 is X1 + 1, Steps is Steps1 + 1);
                                                  (A = west, canMove(west, X1, Y1), Y0 is Y1,  X0 is X1 - 1, Steps is Steps1 + 1)
                                                  ).

                                                  
goal(Steps, X0, Y0, S):-  containsPokimon(1, 1, S), player(Steps, X0, Y0, S),  stepsToHatch(E, s0), Steps > E - 1.

listOfPokimons([[2,2], [0,1], [1,1], [2,1]]).


testOfTest(S, [Hx|Tx], [Hy|Ty]):- Hx == 0, Hy == 0 , test(Hx, Hy, S).

test(X, Y, S):- player(_,X,Y, S), containsPokimon(X,Y,S).
containsPokimon(X, Y, result(A, S)):-  hasPokimon(X, Y), player(_, X1, Y1, S),
                                \+ (
                                  ( X1 is X, Y1 is Y + 1, (\+ A = north));
                                  ( X1 is X, Y1 is Y - 1, (\+ A = south));
                                  ( X1 is X + 1, Y1 is Y, (\+ A = west));
                                  ( X1 is X - 1, Y1 is Y, (\+ A = east))
                                  ),
                                  adjCell(X, Y, X1, Y1).
                                  



