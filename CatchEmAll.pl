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

location(Steps , 1, 2, 0, s0):- Steps =< 0.
location(Steps, X0, Y0, P, result(A,S)):-
                                                 ((
                                                  (A = south, canMove(north, X0, Y0), X1 is X0, Y1 is Y0 - 1,
                                                  containsPokimon(X0, Y0, S), P1 is P - 1,Steps1 is Steps - 1);
                                                  (A = north, canMove(south, X0, Y0), X1 is X0,  Y1 is Y0 + 1,
                                                  containsPokimon(X0, Y0, S), P1 is P - 1, Steps1 is Steps - 1);
                                                  (A = west, canMove(east, X0, Y0), Y1 is Y0,  X1 is X0 + 1,
                                                  containsPokimon(X0, Y0, S), P1 is P - 1, Steps1 is Steps - 1);
                                                  (A = east, canMove(west, X0, Y0), Y1 is Y0,  X1 is X0 - 1,
                                                  containsPokimon(X0, Y0, S), P1 is P - 1, Steps1 is Steps - 1)
                                                  );
                                                  (
                                                  (A = south, canMove(north, X0, Y0), X1 is X0, Y1 is Y0 - 1,
                                                  \+containsPokimon(X0, Y0, S), P1 is P, Steps1 is Steps - 1);
                                                  (A = north, canMove(south, X0, Y0), X1 is X0,  Y1 is Y0 + 1,
                                                  \+containsPokimon(X0, Y0, S), P1 is P, Steps1 is Steps - 1);
                                                  (A = west, canMove(east, X0, Y0), Y1 is Y0,  X1 is X0 + 1,
                                                  \+containsPokimon(X0, Y0, S), P1 is P, Steps1 is Steps - 1);
                                                  (A = east, canMove(west, X0, Y0), Y1 is Y0,  X1 is X0 - 1,
                                                  \+containsPokimon(X0, Y0, S), P1 is P, Steps1 is Steps - 1)
                                                  )
                                                  ),
                                                   location(Steps1, X1, Y1, P1, S).

goal(Steps, X0, Y0, S):-  containsPokimon(1, 1, S), player(Steps, X0, Y0, S),  stepsToHatch(E, s0), Steps > E - 1.

containsPokimon(X, Y, result(A, S)):-  hasPokimon(X, Y),
                                 (
                                  ( X1 is X, Y1 is Y + 1, (\+ A = north));
                                  ( X1 is X, Y1 is Y - 1, (\+ A = south));
                                  ( X1 is X + 1, Y1 is Y, (\+ A = west));
                                  ( X1 is X - 1, Y1 is Y, (\+ A = east))
                                  ),
                                  adjCell(X, Y, X1, Y1).
                                  



