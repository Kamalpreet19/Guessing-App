# Guessing App (Java)

## Overview
The Guessing App is a console-based Java application where a player tries to guess a randomly generated number within a limited number of attempts.  
The project is designed to practice core Java concepts using a modular and clean architecture.

This repository implements **Use Case 1 to Use Case 6 (UC1–UC6)**.

---

## Implemented Use Cases

### UC1: Game Initialization
- Generates a random number within a fixed range
- Initializes maximum attempts and hints
- Displays game rules and instructions
- Uses constructors, constants, and encapsulation

---

### UC2: User Guess Submission
- Accepts user input from the console
- Compares the guessed number with the target number
- Displays feedback: HIGH, LOW, or CORRECT
- Tracks the number of attempts

---

### UC3: Hint Generation
- Provides hints after incorrect guesses
- Limits the number of hints
- Hint types include:
  - Even or Odd
  - Greater than 50 or 50 and below
- Hint logic is separated from the main game flow

---

### UC4: Error Handling and Validation
- Handles non-numeric input safely
- Prevents out-of-range guesses
- Uses custom exceptions
- Ensures the application does not crash on invalid input

---

### UC5: Game Result Storage
- Stores game result (WIN or LOSE) in a file
- Saves number of attempts used
- Uses file handling with BufferedWriter
- Maintains game history across executions

---

### UC6: Game Restart and Exit
- Allows the user to restart the game after completion
- Resets game state for replay
- Exits the application gracefully
- Ensures proper resource cleanup

---

## Technologies Used
- Java
- Object-Oriented Programming principles
- Exception handling
- File handling (I/O)
- Control flow statements

