# Arithmetic Expression Evaluator

This Java program evaluates arithmetic expressions containing integers, basic operators (`+`, `-`, `*`), and parentheses.

## Features

- **Supports Large Numbers:** Uses `Long` for handling large integers.
- **Operator Precedence:** Follows standard precedence rules, with support for parentheses.
- **Stack-Based Evaluation:** Utilizes two stacks for operators and numbers to process the expression.

## Input

- Accepts a string with numbers, operators (`+`, `-`, `*`), and parentheses.
- Example: `"3+5*2-(8/4)"`.

## How It Works

1. **Parsing:** Reads the input string character by character.
2. **Stack Operations:** Pushes numbers and operators to respective stacks, evaluates based on precedence.
3. **Output:** The final result is printed.
