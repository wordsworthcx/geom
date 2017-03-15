# geom
Define n-dimensional geometric objects

Here in the project geom,
1. Point originates everything.
    1.1 Line consists of the start and end points.
    1.2 Shape consists of 2-dimensional points.
2. Geometric is an interface that displays geometric object which consists of N-dimensional points.
3. The advantage of working with point is that it mocks the real object structure physically and mathematically. 
   The disadvantage is that the edge length, surface area, volume, etc will be calculated from the points, which means the precision will definitely not be perfect.
   So that requires a tolerance of the precision loss when calculating the length or area value and comparing them.
4. I define all the mathematical attributes as a double type. Anyway it is an open question that can be negotiated.
5. Run the tst/geom/shape/TriangleTest.java, test cases will be executed.

As an alternative, we can just define the 2-dimensional shape with edges which only have the length attribute, without points. That can avoid the precision loss from the calculating as per points.

Finally, sorry again for the late finalization. I am still on business trip and have meetings all day that forces me to code at night.
Fortunatelly, I spent hours on this and made it done this morning.
Any questions, please don't hesitate to contact me.
