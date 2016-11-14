working_directory(_, 'E:/JAVA/Gotta-Catch-em-All').
[knowledgeBase].

hasNorth(X,Y):- cell(X,Y,true,_,_,_).
hasSouth(X,Y):- cell(X,Y,_,true,_,_).
hasEast(X,Y):- cell(X,Y,_,_,true,_).
hasWest(X,Y):- cell(X,Y,_,_,_,true).


canMove(north, S):- playerLocation(D, X, Y, S),
                    hasNorth(X, Y).
canMove(south, S):- playerLocation(D, X, Y, S),
                    hasSouth(X, Y).
canMove(east, S):- playerLocation(D, X, Y, S),
                    hasEast(X, Y).
canMove(west, S):- playerLocation(D, X, Y, S),
                    hasWest(X, Y).

playerLocation(Direction, X0, Y0, result(A,S)):- playerLocation(Direction, X1, Y1, S),
                                                 (
                                                  (A = north, Y0 is Y1 - 1);
                                                  (A = south, Y0 is Y1 + 1);
                                                  (A = east, X0 is X1 + 1);
                                                  (A = west, X0 is X1 - 1)
                                                  ).
                                                 /* (
                                                  playerLocation(Direction, X0, Y0, S), (A = north)
                                                  ).*/
