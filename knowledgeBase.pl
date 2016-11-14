
cell(0,0,false,true,false,false).
cell(0,1,true,false,true,false).
cell(0,2,false,true,true,false).
cell(0,3,true,true,false,false).
cell(0,4,true,false,true,false).
cell(1,0,false,true,true,false).
cell(1,1,true,false,false,true).
cell(1,2,false,false,false,true).
cell(1,3,false,true,true,false).
cell(1,4,true,false,true,true).
cell(2,0,false,true,false,true).
cell(2,1,true,true,false,false).
cell(2,2,true,true,false,false).
cell(2,3,true,false,false,true).
cell(2,4,false,false,false,true).
hasPokimon(0,0,s0).
hasPokimon(0,3,s0).
hasPokimon(1,1,s0).
hasPokimon(1,3,s0).
hasPokimon(1,4,s0).
hasPokimon(2,0,s0).

playerLocation(n, 0, 0, s0).

startPoint(1,0).
endPoint(2,4).
stepsToHatch(12,s0).
