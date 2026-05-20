Markdown
# Library Management System

A Java-based Library Management System that models a diverse inventory of library items (Books, DVDs, and Magazines). This system leverages object-oriented programming concepts such as **polymorphism, inheritance, abstract classes, and interfaces** to manage, track, sort, and process item transactions dynamically using file input.

---

## Features

* **Diverse Catalog Parsing:** Dynamically reads and generates inventory from a flat text file (`inventory.txt`), distinguishing media categories safely without application crashes.
* **Loan Operations:** Standardized interface modeling for processing checking out and returning items seamlessly, complete with stateful validation (cannot check out an already checked-out item).
* **Smart Inventory Sorting:** Employs explicit polymorphism (`Comparable<MediaItem>`) to sort items naturally by type first (alphabetically by class name) and then by ID.
* **Console UI Menu:** An interactive, error-resistant command-line loop allowing operators to manage loans, search by name, or extract rich, metadata-complete item descriptions.

---

##   Project Architecture

The program follows a strictly decoupled hierarchy designed for clean extensibility:

├── MediaItem (Abstract Base Class)
│   ├── Loanable (Interface for check-out/return operations)
│   │   ├── Book (Child subclass)
│   │   ├── DVD (Child subclass)
│   │   └── Magazine (Child subclass)
└── LibraryManagementSystem (Driver & Main Execution Entrypoint)


### Class Breakdown
* **`MediaItem`**: The abstract core capturing overarching characteristics (`id`, `name`, `author`, `year`, `checkedOut`) and governing sorting mechanisms.
* **`Loanable`**: Interface ensuring strict operational standardizations for items that can enter circulation.
* **`Book`, `DVD`, `Magazine`**: Concrete implementations that expand underlying media attributes tailored to target specific item specifications (e.g., ISBNs, Ratings, Durations, Issue Numbers).

---

## 📋 Data File Formatting (`inventory.txt`)

The helper method handles parsing via comma-separated data paths. The local text tracking ledger must be saved inside the root workspace folder adhering to the following structures:

```text
book, B001, The Great Gatsby, F. Scott Fitzgerald, 1925, Fiction, 9780743273565
dvd, D102, Inception, Christopher Nolan, 2010, 148, PG-13
magazine, M305, National Geographic, Various Authors, 2024, 1452, May
  Technical Implementation Highlights
Polymorphic Natural Sorting
Items are sorted transparently utilizing a two-tiered check inside the custom compareTo implementation:

Item Type Validation: Classes are grouped cleanly by isolating their simple reflection strings (this.getClass().getSimpleName()).

ID Validation: Ties are broken by evaluating specific unique identifiers safely.

Exception Defenses
InputMismatchException: Protects the core operation loop against arbitrary alphabetic string injections inside numerical menu fields.

FileNotFoundException: Catches file parsing complications safely on launch without breaking system continuity.

IllegalArgumentException: Standardized fallback layer protecting system inventory generation against corrupted file formats.

  Getting Started
Prerequisites
Java Development Kit (JDK) 8 or higher.

An IDE (e.g., Eclipse, IntelliJ IDEA) or command line utility tools.

Running the Application (Via Command Line)
Ensure your inventory.txt is inside the exact directory you are executing from.

Compile the source components:

Bash
javac *.java
Run the driver controller:

Bash
java LibraryManagementSystem
