# ArrayList

## Methods

### `.add(T element)` method:
Adds an element in the ArrayList.

### `.remove(T element)` method:
Removes an element in the ArrayList.

### `.removeIf()` method:
- remove an element in the ArrayList that satisfies the given filter.
- This method accepts a **Predicate** which is used to evaluate each element in the ArrayList and determine if the element should be removed or not.
  - A **_predicate_** is a generic interface that accepts a value and determines if it is true or false. A predicate can also be passed as a lambda expression.

```jsregexp
ArrayList<String> sampleStrings;

sampleStrings.removeIf(element -> element.equals("toBeRemoved"));
```
This will remove all "toBeRemoved" elements inside the sampleStrings.