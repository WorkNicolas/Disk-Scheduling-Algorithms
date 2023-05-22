# Disk Scheduling Algorithms 💽
The source code within this repository aims to create a user-input driven program. It is a Command-Line Interface Java program that aims to combine the five Disk Scheduling Algorithms for Operating Systems. The source code was based on 29AjayKumar's work, wherein the code was minimized through the use of ternary operators and/or boolean methods. Furthermore, to ensure efficiency and save memory, byte was the data type used for the index instead of the integer.

## First-Come-First-Serve Disk Scheduling Algorithm 🥇
The simplest disk scheduling algorithm, wherein requests are entertained as they are arrived.

## Shortest-Seek-Time-First  Disk Scheduling Algorithm 📏
The tracks closest to the current disk head position are serviced first to minimize seek operations.

## Scan Disk Scheduling Algorithm 🖨
The head starts from one head of the disk and moves on to towards the end. Moves from left to right.
- Uses the same source code as Look Disk Scheduling Algorithm
- Implements ternary operators to minimize code redundancy, make code easily readable and to maximize efficiency
- Uses boolean instead of String to determine the direction to consume less memory.

## C-Scan Disk Scheduling Algorithm 🔘
Implements a circular scan of the disk scheduling algorithm.
- Modifies the Scan Disk Scheduling Algorithm by dealing with its inefficiency
- Services the requests uniformly

## Look Disk SCheduling Algorithm 👀
The head starts from one head of the disk and moves on to towards the end. Moves from right to left.
- Uses the same source code as Scan Disk Scheduling Algorithm
- Implements ternary operators to minimize code redundancy, make code easily readable and to maximize efficiency
- Uses boolean instead of String to determine the direction to consume less memory.

## Preset Values 📦
Request: `[176, 79, 34, 60, 92, 11, 41, 114]`

Head: `50`

## User-Input 👤
**To input requests, use space-separated input.**

Example:
```
[IN IN IN ...] Request: 176 79 34 60 92 11 41 114
```

**To input the head, simply write a number.**

Example:

```
[IN] Head: 50
```

### Note 📝
Due to byte data type, array size can only be 127. Thus, only input 127 numbers.