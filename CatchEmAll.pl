[knowledgeBase].
hasNorth(X,Y):- cell(X,Y,true,_,_,_).
hasSouth(X,Y):- cell(X,Y,_,true,_,_).
hasEast(X,Y):- cell(X,Y,_,_,true,_).
hasWest(X,Y):- cell(X,Y,_,_,_,true).
player(D, X, Y, S):-  playerLocation(D, X, Y, S).

canMove(north, S):- player(D, X, Y, S),
                    hasNorth(X, Y).
canMove(south, S):- player(D, X, Y, S),
                    hasSouth(X, Y).
canMove(east, S):- player(D, X, Y, S),
                    hasEast(X, Y).
canMove(west, S):- player(D, X, Y, S),
                    hasWest(X, Y).

player(Direction, X0, Y0, result(A,S)):- player(_, X1, Y1, S),
                                                 (
                                                  (A = north, X0 is X1, Y0 is Y1 - 1, canMove(north, S));
                                                  (A = south, X0 is X1,  Y0 is Y1 + 1, canMove(south, S));
                                                  (A = east,Y0 is Y1,  X0 is X1 + 1, canMove(east, S));
                                                  (A = west,Y0 is Y1,  X0 is X1 - 1, canMove(west,S))
                                                  ).


