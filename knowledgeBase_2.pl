cell(0,0,false,true,false,false).
cell(0,1,true,true,false,false).
cell(0,2,true,false,true,false).
cell(1,0,false,true,true,false).
cell(1,1,true,false,true,false).
cell(1,2,false,false,true,true).
cell(2,0,false,false,false,true).
cell(2,1,false,true,false,true).
cell(2,2,true,false,false,true).
hasPokimon(1,1).
hasPokimon(1,2).
hasPokimon(2,0).
numberOfPokimons(3).
playerLocation(1,0,s0).
startPoint(1,0).
endPoint(1,1).
stepsToHatch(3).


/* To Visualize The Maze
+--+--+--+
¦  ¦?  M ¦
+  +  +--+
¦  ¦V¦   ¦
+  +--+  +
¦   M    ¦
+--+--+--+
*/