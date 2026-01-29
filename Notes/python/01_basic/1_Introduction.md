# Python Programming Language

## Python Data Types
Python is a strongly typed language, in the sense that at runtime it prevents typing errors and it engages in little
implicit type conversion (_casting_). It converts one type to another without a specific call to a conversion function.

### Built-in data types:
- String type: `str`
- Boolean type: `bool`
- Binary type: `bytes`, `bytearray`, `memoryview`
- Number type: `int`, `float`, `complex`
- Sequence type: `list`, `range`, `tuple`
- Set type: `set`, `frozenset`
- Dictionary type: `dict`

### Type Utility Methods
- `type()` retrieves the data type of object.

```python
message = "Hello World"
print(type(message))
# Output: <class 'str'>
```

- `isinstance(object, type)` used to check if an object is an instance of a specified type.

```python
word = "purple"
languages = ("Python", "JavaScript", "Go")

print(isinstance(word, str)) # Output: True
print(isinstance(languages, list)) # Output: False
print(isinstance(languages, tuple)) # Output: True

```

## Mathematical Operations
Mathematical operations in python is almost the same with Java except for the following:

- **Exponents** are represented by `**`.
- 
