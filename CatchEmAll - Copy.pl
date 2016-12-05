[knowledgeBase].
hasNorth(X,Y):- cell(X,Y,true,_,_,_).
hasSouth(X,Y):- cell(X,Y,_,true,_,_).
hasEast(X,Y):- cell(X,Y,_,_,true,_).
hasWest(X,Y):- cell(X,Y,_,_,_,true).

canMove(north, X, Y):- hasNorth(X, Y).
canMove(south, X, Y):- hasSouth(X, Y).
canMove(east, X, Y):-  hasEast(X, Y).
canMove(west, X, Y):-  hasWest(X, Y).


location(Steps, X, Y, P, _, s0):- Steps =< 0, P =< 0, playerLocation(X, Y, s0).
location(Steps, X0, Y0, P, Pokimons,result(A,S)):- ((
                                                  (A = south, canMove(north, X0, Y0), X1 is X0, Y1 is Y0 - 1,
                                                  Steps1 is Steps - 1, hasPokimon(X1, Y1), \+member([X1, Y1], Pokimons),
                                                  P1 is P - 1,append([[X1, Y1]], Pokimons, Pokimons1));
                                                  (A = north, canMove(south, X0, Y0), X1 is X0,  Y1 is Y0 + 1,
                                                   Steps1 is Steps - 1, hasPokimon(X1, Y1), \+member([X1, Y1], Pokimons),
                                                  P1 is P - 1, append([[X1, Y1]], Pokimons, Pokimons1));
                                                  (A = west, canMove(east, X0, Y0), Y1 is Y0,  X1 is X0 + 1,
                                                   Steps1 is Steps - 1, hasPokimon(X1, Y1), \+member([X1, Y1], Pokimons),
                                                  P1 is P - 1, append([[X1, Y1]], Pokimons, Pokimons1));
                                                  (A = east, canMove(west, X0, Y0), Y1 is Y0,  X1 is X0 - 1,
                                                   Steps1 is Steps - 1, hasPokimon(X1, Y1), \+member([X1, Y1], Pokimons),
                                                  P1 is P - 1, append([[X1, Y1]], Pokimons, Pokimons1))

                                                  );
                                                  (
                                                  (A = south, canMove(north, X0, Y0), X1 is X0, Y1 is Y0 - 1,
                                                  Steps1 is Steps - 1, \+hasPokimon(X1, Y1), P1 is P, Pokimons1 = Pokimons);
                                                  (A = north, canMove(south, X0, Y0), X1 is X0,  Y1 is Y0 + 1,
                                                   Steps1 is Steps - 1, \+hasPokimon(X1, Y1), P1 is P, Pokimons1 = Pokimons);
                                                  (A = west, canMove(east, X0, Y0), Y1 is Y0,  X1 is X0 + 1,
                                                   Steps1 is Steps - 1, \+hasPokimon(X1, Y1), P1 is P, Pokimons1 = Pokimons);
                                                  (A = east, canMove(west, X0, Y0), Y1 is Y0,  X1 is X0 - 1,
                                                   Steps1 is Steps - 1, \+hasPokimon(X1, Y1), P1 is P, Pokimons1 = Pokimons)
                                                  )),
                                                   location(Steps1, X1, Y1, P1, Pokimons1,S).
set_prolog_stack(local,  limit(100 000 000 000)).
catchEmAll(S, L, R):-  endPoint(Ex, Ey), numberOfPokimons(N), stepsToHatch(Steps),
                 call_with_depth_limit(location(Steps, Ex, Ey, N, [], S), L, R).
/*  Use this in the console down to make Prolog print the whole answer without trimming
set_prolog_flag(answer_write_options,
                   [ quoted(true),
                     portray(true),
                     spacing(next_argument)
                   ]).

*/