[knowledgeBase].
hasNorth(X,Y):- cell(X,Y,true,_,_,_).
hasSouth(X,Y):- cell(X,Y,_,true,_,_).
hasEast(X,Y):- cell(X,Y,_,_,true,_).
hasWest(X,Y):- cell(X,Y,_,_,_,true).
player(Steps, X, Y, S):-  playerLocation(Steps, X, Y, S).

canMove(north, S):- player(_, X, Y, S),
                    hasNorth(X, Y).
canMove(south, S):- player(_, X, Y, S),
                    hasSouth(X, Y).
canMove(east, S):- player(_, X, Y, S),
                    hasEast(X, Y).
canMove(west, S):- player(_, X, Y, S),
                    hasWest(X, Y).
                    
eggHatching(Steps, S):- stepsToHatch(Steps, S).

eggHatching(X, result(A, S)):-  eggHatching(X1, S),
                                (X is X1 - 1, (
                                               (A = north, canMove(north, S));
                                               (A  = south, canMove(south, S));
                                               (A = east, canMove(east, S));
                                               (A = west, canMove(west, S))
                                               )).
                                               


player(Steps, X0, Y0, result(A,S)):- player(Steps1, X1, Y1, S),
                                                (
                                                  (A = north, X0 is X1, Y0 is Y1 - 1, Steps is Steps1 + 1, canMove(north, S));
                                                  (A = south, X0 is X1,  Y0 is Y1 + 1, Steps is Steps1 + 1, canMove(south, S));
                                                  (A = east, Y0 is Y1,  X0 is X1 + 1, Steps is Steps1 + 1, canMove(east, S));
                                                  (A = west, Y0 is Y1,  X0 is X1 - 1, Steps is Steps1 + 1, canMove(west,S))
                                                  ).
goal(Steps, X0, Y0, S):-  player(Steps, X0, Y0, S), stepsToHatch(E, s0), Steps > E - 1.
containsPokimon(X, Y, S):-  hasPokimon(X, Y, S).
containsPokimon(X, Y, result(A, S)):- containsPokimon(X, Y, S), player(X1, Y1, S),
                                 (
                                  ( X1 is X, Y1 is Y + 1, (A = north, canMove(north, S)));
                                  ( X1 is X, Y1 is Y - 1, (A = south, canMove(south, S)));
                                  ( X1 is X + 1, Y1 is Y, (A = west, canMove(west, S)));
                                  ( X1 is X - 1, Y1 is Y, (A = east , canMove(east, S)))
                                  ).


/*
createMovingPlan(X0, Y0, X1, Y1, result(A, S)):-  createMovingPlan(_, _, X1, Y1, S),
                                                  (
                                                  (A = north, X0 is X1, Y0 is Y1 - 1, canMove(north, S));
                                                  (A = south, X0 is X1,  Y0 is Y1 + 1, canMove(south, S));
                                                  (A = east,Y0 is Y1,  X0 is X1 + 1, canMove(east, S));
                                                  (A = west,Y0 is Y1,  X0 is X1 - 1, canMove(west,S))
                                                  ).   */

