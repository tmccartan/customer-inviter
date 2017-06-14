# Customer Inviter


Requires sbt, scala, jdk8

Question 2 -

Assumptions
I figured it would be ok to use the more generic List type rather than Array, It allowed for cleaner, immutable code IMO.

Also it was specified it need to contain only ints and lists of ints therefore I throw an exception if the type doesnt match.
If it was warranted, I would of had a more generic flatten method that is just concerned with flattening a list of Any type within any list

To test it out, just use

```sbt test```

Question 3 -
Built it as a small scala app

Assumptions
The file is always in the same directory (why its hardcoded). If it doesnt exist we should throw and error
The file is always in the same format, if it doesnt throw an error

The calculation formula is from https://rosettacode.org/wiki/Haversine_formula#Scala , which is similar to what the recruiter mentioned from wikipedia

If the calculation formula is wrong, I can always change it.

To run
``` sbt run ```

To test
``` sbt test ```



