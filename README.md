# 🚆 Railway Ticket Booking System (Java)

A **console-based Railway Ticket Booking System** developed using **Java** and **Object-Oriented Programming (OOP)** concepts.  
This project simulates a real-world train reservation system with support for **Confirmed Tickets, RAC, and Waiting List management**.

---

## 📌 Features

- 📄 Book railway tickets with berth preference
- 👵 Priority allocation for **senior citizens** and **female passengers**
- 🛏️ Berth types: **LOWER, MIDDLE, UPPER**
- 🔁 Automatic **RAC and Waiting List handling**
- ❌ Cancel tickets using Ticket ID
- 🔼 Automatic promotion:
  - RAC → Confirmed
  - Waiting List → RAC
- 📊 View:
  - Confirmed tickets
  - Available tickets
  - RAC tickets
  - Waiting list tickets
- 🧭 Menu-driven console interface

---

## 🛠️ Technologies Used

- **Java**
- **OOP Concepts**
  - Encapsulation
  - Abstraction
  - Collections Framework
- **Java Collections**
  - `ArrayList`
  - `HashMap`
  - `Queue`
  - `LinkedList`
- **Scanner Class** for user input

---

## 📂 Project Structure
Railway_Booking_System/
│
├── Main.java
├── TicketSystem.java
├── Passenger.java
└── README.md


---

## ⚙️ How the System Works

### 🎫 Ticket Booking
1. User enters passenger details:
   - Name
   - Age
   - Gender
   - Berth Preference
2. The system tries to allocate:
   - Preferred berth
   - Lower berth for senior citizens or females
3. If no berth is available:
   - Ticket goes to **RAC**
4. If RAC is full:
   - Ticket goes to **Waiting List**
5. If all are full:
   - Booking fails

---

### ❌ Ticket Cancellation
- Cancelling a confirmed ticket:
  - Releases the berth
  - Promotes first RAC passenger to Confirmed
  - Promotes first Waiting List passenger to RAC

---

## ▶️ How to Run the Project

### Prerequisites
- Java JDK 8 or above
- Any IDE (Eclipse / IntelliJ / VS Code) or Command Line

### Steps
1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/Railway_Booking_System.git](https://github.com/saravanakumar-m4/L-Railway-ticket-booking/
