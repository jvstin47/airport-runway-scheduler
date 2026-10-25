# Airport Runway Scheduling System - Viva Voce Guide

This document is a quick preparation reference for all 4 team members for project presentation and external viva voce examination.

---

## 1. How to Compile and Run the Project

Open the terminal in this directory:
```bash
./run.sh
```
Or manually:
```bash
javac *.java
java RunwayUI
```

---

## 2. Team Member Work Breakdown & Viva Cheatsheet

### 👤 Justin Joe Mathew
* **Primary Module:** `Aircraft.java` (Aircraft Model, OOP Concepts)
* **Code Overview:**
  - Defines the flight model with attributes: `flightNo`, `airline`, `type` ("Landing" / "Takeoff"), and `isEmergency` (boolean).
  - Implements the constructor and overrides `toString()`.
* **Common Viva Questions & Answers:**
  - **Q1: Which OOP principles did you apply here?**
    - *Answer:* **Encapsulation** (grouping all related flight details into a single class) and **Polymorphism** (overriding `toString()` from the `Object` class).
  - **Q2: Why did you override `toString()`?**
    - *Answer:* It allows clean, customized string representations like `[EMERGENCY] AI-101 (Air India)` to be displayed directly in Swing text areas and logs.

---

### 👤 Elna Elizabeth Abraham
* **Primary Module:** `Node.java` & `FlightQueue.java` (Core Data Structures & Algorithms)
* **Code Overview:**
  - Built a custom **Singly Linked-List Queue** from scratch with `front` and `rear` pointers.
  - Implements `enqueue()`, `dequeue()`, `isEmpty()`, and `getDisplayList()`.
  - Implements **Priority Queue logic**: Emergency flights insert at Head (`front`); routine flights insert at Tail (`rear`).
* **Common Viva Questions & Answers:**
  - **Q1: Why did you build a custom queue instead of using `java.util.Queue`?**
    - *Answer:* To demonstrate core data structure concepts using node pointers (`front`, `rear`, `next`), memory management, and algorithmic complexity from first principles.
  - **Q2: How does the priority queue work?**
    - *Answer:* Routine flights are enqueued at `rear` (FIFO, $O(1)$). When an emergency flight arrives, it is inserted at `front` ($O(1)$ priority preemption). Dequeue removes from `front` ($O(1)$).

---

### 👤 K Sruthika
* **Primary Module:** `RunwayUI.java` (User Interface & System Integration)
* **Code Overview:**
  - Pure Java Swing GUI built using `JFrame`, `setBounds` (absolute positioning), and `implements ActionListener`.
  - Connects the user input form to a single unified `runwayQueue`.
  - Displays the live queue on top and the activity log on bottom.
* **Common Viva Questions & Answers:**
  - **Q1: Why use a single unified queue for the runway?**
    - *Answer:* In a single-runway airport, all aircraft waiting to use the runway share one queue. Emergency flights jump to the front so the runway can be cleared immediately.
  - **Q2: How is event handling managed in Swing?**
    - *Answer:* `RunwayUI` implements `ActionListener`. In `actionPerformed(ActionEvent e)`, `e.getSource()` identifies which button was clicked (`bAdd`, `bProcess`, `bSave`, or `bClear`).

---

### 👤 Devika Suresh
* **Primary Module:** `FileHandler.java` & `TestRunway.java` (File Handling & Verification)
* **Code Overview:**
  - Manages permanent runway flight logging to `runway_log.txt` using `FileWriter`.
  - Built `TestRunway.java` to programmatically verify queue operations, priority preemption, and edge cases without the GUI.
* **Common Viva Questions & Answers:**
  - **Q1: Why did you pass `true` into `new FileWriter(FILE_NAME, true)`?**
    - *Answer:* Passing `true` enables **append mode**, ensuring past runway operations are preserved and not overwritten.
  - **Q2: How did you test edge cases?**
    - *Answer:* Verified queue underflow (clicking 'Clear Runway' when queue is empty alerts the user without crashing) and priority preemption via `TestRunway.java`.
