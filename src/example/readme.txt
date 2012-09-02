
Example 1
=========
This example demonstrates how to:
  - generate a parser from the grammar example1.grammar
  - generate an example implementation that implements the generated parser (see example1.laja)
  - execute the parser, read the file example1.txt and print out:
    Result: Example1{name=Homer}
  
1. Make sure Ant is installed (http://ant.apache.org).
2. Go to directory java.
3. Execute:
   ant example1

Example 2
=========
This example demonstrates how to build a parser from the grammar example2.grammar
that reads the file example2.txt:
  age: 18
  name: Roger
  country: Sweden!
...and print the top-node of the object hierarchy (which is the toString() method of the generated class Example2):
   Result: Example2{rows=[Row{label=age, value=18}, Row{label=name, value=Roger}, Row{label=country, value=Sweden!}]}

1. Make sure Ant is installed (http://ant.apache.org).
2. Go to directory java.
3. Execute:
   ant example2
