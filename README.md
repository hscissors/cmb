# Notes of Coding Exercise
- I put a few comments in the code to indicate places where I knew a production app would be need make changes. This includes in the `DataService.class` and in parts of the conconcrete MVP parts. Accordingly, I did not make abstract classes for the MVP pattern.
- I did not use `string.xml` or `dimen.xml` or any of the DPI/SDK dependent res files, because this was just a test.
- There is very minor error handling and null checks--a production app would need to be hardened.
- I wanted to add a caching SQL layer, but ran out of time. A production app could sideeffect the caching on request.
- I used Java 1.8 so I didn't need to jump through hoops to use lambdas.
- The listeners attached to the ProfileViews could be replaced with Rx wrappers. 
