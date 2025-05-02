# Family-Finance-Backend

Expanded Finance App Feature List
🔐 1. Authentication
Email/Password & Phone Login (with OTP)


Social login (Google, Apple, Facebook - optional)


Biometric Login (fingerprint or face unlock for quick access)


Password Reset via OTP or Email



💰 2. Income Management
Add multiple sources: salary, freelance, business


View income by:


Category


Month


Source


Recurring income (e.g. auto-add salary every 30th)



💸 3. Expense Tracking
Add manual or scanned receipts


Categorize expenses (food, transport, health, etc.)


Set spending limits per category


Daily/weekly/monthly reminders to log expenses



🧾 4. Bills Management
Add due dates for bills (rent, internet, electricity)


Auto-reminders before due date


Mark as paid/unpaid


Monthly bill prediction



🪙 5. Savings
Create savings goals with deadlines


Track saving progress


Auto-save a percentage of income


Visual goal tracker (progress bar or coin animation)



📊 6. Monthly Summary / Reports
Graphs: pie charts, bar graphs, trend lines


Monthly income vs. spending


Highlight top 3 categories (biggest spenders)


Export to PDF or Excel



💳 7. Cards / Bank Accounts
Add debit/credit cards info (visually styled)


Track card spending vs. cash


Set card limits and alerts


View last 4 digits only (for security)



🔁 8. Transactions
All transactions in one timeline


Filters: category, date range, payment method


Search bar with autocomplete


Split bills between categories or users



👤 9. User Profile & Settings
Edit name, photo, email, currency preference


Enable/disable features (e.g. hide savings)


Light/Dark theme toggle


Notification settings



🔒 10. Data Privacy & Security
End-to-end encrypted data


App lock with PIN, Face ID, or Fingerprint


Data backup: Cloud & Local


Logout from all devices



🎯 11. Purpose & Goals
Set personal financial goals (e.g. "Buy laptop", "Pay off debt")


Attach budgets/savings to each goal


Get milestone progress alerts



🌍 12. Multi-Currency Support
Convert between TZS, USD, KES, etc.


Automatically fetch exchange rates



🔔 13. Smart Alerts & Notifications
Daily budget exceeded


Weekly summaries


Low balance warnings


Bills due soon



📥 14. Import & Export
Import bank statements (CSV or Excel)


Export reports for accountants



👥 15. Shared Accounts (Advanced)
Invite partner/spouse to share budget


Assign roles (viewer/editor)



🛠️ Technical Recommendations
Feature
Tools
Local DB
Hive, Drift, or SQLite
Cloud Sync
Firebase Firestore / Supabase
Charts
fl_chart, Syncfusion
Notifications
Local Notifications + Firebase Messaging
Biometric
local_auth Flutter plugin
PDF Export
pdf + printing package in Flutter


Would you like a Figma wireframe, feature roadmap, or even a Flutter starter codebase for this?
Let me know how you’d like to continue: design, backend planning, or feature-by-feature coding.
4o
You said:
design a database
ChatGPT said:
Sure! Let’s design a NoSQL-style database (e.g. Firebase Firestore) and a relational (SQL) schema (e.g. SQLite) for your finance app. You can pick based on your tech stack.

🔧 Option 1: NoSQL (Firebase Firestore-style) Database Design
🗂️ Collections and Documents
scss
CopyEdit
users (collection)
  └── userId (document)
        ├── name
        ├── email
        ├── phone
        ├── currency
        ├── createdAt
        ├── settings
        ├── goals (subcollection)
        └── cards (subcollection)

transactions (collection)
  └── transactionId (document)
        ├── userId (ref to users)
        ├── type: 'income' | 'expense'
        ├── category
        ├── amount
        ├── note
        ├── paymentMethod
        ├── date
        └── isRecurring

bills (collection)
  └── billId (document)
        ├── userId
        ├── title
        ├── amount
        ├── dueDate
        ├── isPaid
        └── repeat: 'monthly' | 'weekly' | 'none'

savings (collection)
  └── savingId (document)
        ├── userId
        ├── title
        ├── goalAmount
        ├── currentAmount
        ├── deadline
        └── isCompleted

cards (collection)
  └── cardId (document)
        ├── userId
        ├── cardType: 'credit' | 'debit'
        ├── name
        ├── last4Digits
        └── limit


🧱 Option 2: Relational (SQL-style) Database Design
📋 Tables
🧍 users
Field
Type
Description
id
TEXT (UUID)
Primary key
name
TEXT
Full name
email
TEXT
Unique
phone
TEXT
Optional
passwordHash
TEXT
Securely stored
currency
TEXT
e.g. 'TZS'
created_at
DATETIME
Account created date


💸 transactions
Field
Type
id
TEXT
user_id
TEXT (FK → users.id)
type
TEXT ('income', 'expense')
amount
REAL
category
TEXT
note
TEXT
payment_method
TEXT
date
DATETIME
is_recurring
BOOLEAN


🧾 bills
Field
Type
id
TEXT
user_id
TEXT
title
TEXT
amount
REAL
due_date
DATETIME
is_paid
BOOLEAN
repeat
TEXT ('monthly', 'weekly', etc.)


🪙 savings
Field
Type
id
TEXT
user_id
TEXT
title
TEXT
goal_amount
REAL
current_amount
REAL
deadline
DATETIME
is_completed
BOOLEAN


💳 cards
Field
Type
id
TEXT
user_id
TEXT
card_type
TEXT
name
TEXT
last_4_digits
TEXT
limit
REAL


🎯 goals
Field
Type
id
TEXT
user_id
TEXT
title
TEXT
description
TEXT
target_amount
REAL
progress_amount
REAL
deadline
DATETIME


🔐 Security Note
If using Firebase:
Use Firestore rules to restrict access per user (e.g., userId == request.auth.uid) If using SQLite:


Ensure encryption or local protection via libraries like sqlcipher or app-level encryption.


For a budget/finance app, the core data is usually stored in well-structured database tables. Here's a list of essential tables you might need for a complete budget tracking system, such as the one you're building:

✅ 1. users
Stores user account data.
Field
Type
Description
id
UUID/INT
Primary key
name
VARCHAR
Full name
email
VARCHAR
Unique email
password
VARCHAR
Hashed password
created_at
TIMESTAMP
Registration date


✅ 2. income
Tracks user income.
Field
Type
Description
id
UUID/INT
Primary key
user_id
UUID/INT
Foreign key to users
amount
DECIMAL
Income amount
source
VARCHAR
Source name (e.g., Job)
received_on
DATE
Date received
notes
TEXT
Optional notes


✅ 3. expenses
Tracks user expenses.
Field
Type
Description
id
UUID/INT
Primary key
user_id
UUID/INT
Foreign key to users
amount
DECIMAL
Expense amount
category_id
INT
Link to expense category
spent_on
DATE
Date spent
notes
TEXT
Optional description


✅ 4. categories
Defines expense/income categories.
Field
Type
Description
id
INT
Primary key
name
VARCHAR
e.g., Food, Rent, Salary
type
ENUM
income or expense


✅ 5. savings_goals
Tracks user saving goals.
Field
Type
Description
id
UUID/INT
Primary key
user_id
UUID/INT
Foreign key to users
title
VARCHAR
Goal name
target_amount
DECIMAL
Target amount
saved_amount
DECIMAL
Amount saved so far
deadline
DATE
Optional target date


✅ 6. bills
Manages recurring bills.
Field
Type
Description
id
UUID/INT
Primary key
user_id
UUID/INT
Foreign key to users
name
VARCHAR
Bill name
amount
DECIMAL
Amount due
due_date
DATE
Due date
is_paid
BOOLEAN
Paid status


✅ 7. transactions
Generic log of all money movement.
Field
Type
Description
id
UUID/INT
Primary key
user_id
UUID/INT
Foreign key to users
type
ENUM
income, expense, transfer
reference_id
UUID/INT
ID from income/expense
amount
DECIMAL
Amount
created_at
TIMESTAMP
Time recorded


✅ 8. budgets
Helps users set monthly budgets per category.
Field
Type
Description
id
UUID/INT
Primary key
user_id
UUID/INT
Foreign key
category_id
INT
Expense category
month
DATE
Month/year
amount_limit
DECIMAL
Budget limit

Budget, Expense, Income, and Statistics:

📘 Family-Finance-Backend API Documentation
A backend service for managing personal and shared family finances, built to support CRUD operations for Bills, Budget, Expenses, Income, and Statistics.

📌 BASE URL
arduino
Copy
Edit
https://api.familyfinance.app/v1/
🔐 Authentication (Token-Based)
Method	Endpoint	Description
POST	/auth/register	Register a new user
POST	/auth/login	Login with email/phone + password
POST	/auth/verify-otp	Verify OTP for phone login
POST	/auth/reset-password	Reset password via email/OTP
GET	/auth/logout	Logout current session

💸 Income API
Method	Endpoint	Description
GET	/income	List all incomes for the user
POST	/income	Create new income record
GET	/income/{id}	Get income by ID
PUT	/income/{id}	Update income record
DELETE	/income/{id}	Delete income record

Sample Payload (POST/PUT):

json
Copy
Edit
{
  "amount": 1200,
  "source": "Salary",
  "received_on": "2025-04-30",
  "notes": "April Salary",
  "isRecurring": true
}
💳 Expense API
Method	Endpoint	Description
GET	/expenses	List all expenses
POST	/expenses	Add a new expense
GET	/expenses/{id}	Get expense by ID
PUT	/expenses/{id}	Update expense
DELETE	/expenses/{id}	Delete expense

Sample Payload:

json
Copy
Edit
{
  "amount": 150,
  "category_id": 3,
  "spent_on": "2025-04-30",
  "notes": "Dinner out"
}
🧾 Bills API
Method	Endpoint	Description
GET	/bills	Get all bills
POST	/bills	Add a new bill
GET	/bills/{id}	Get bill by ID
PUT	/bills/{id}	Update bill
DELETE	/bills/{id}	Remove a bill

Sample Payload:

json
Copy
Edit
{
  "name": "Electricity Bill",
  "amount": 500,
  "due_date": "2025-05-05",
  "is_paid": false,
  "repeat": "monthly"
}
🎯 Budget API
Method	Endpoint	Description
GET	/budgets	View all budgets
POST	/budgets	Set a new budget
GET	/budgets/{id}	Get budget by ID
PUT	/budgets/{id}	Edit budget
DELETE	/budgets/{id}	Delete budget

Sample Payload:

json
Copy
Edit
{
  "category_id": 3,
  "month": "2025-05-01",
  "amount_limit": 300
}
📊 Statistics API
Method	Endpoint	Description
GET	/statistics/monthly-summary	Monthly income vs expense, top categories
GET	/statistics/category-breakdown	Breakdown per category
GET	/statistics/progress	Goal/saving progress
GET	/statistics/export	Export data to PDF or Excel

🧾 Categories API
Method	Endpoint	Description
GET	/categories	List categories
POST	/categories	Create a new category
PUT	/categories/{id}	Update category
DELETE	/categories/{id}	Delete category

✅ Status Codes
200 OK – Success

201 Created – Resource created

400 Bad Request – Validation errors

401 Unauthorized – Invalid/missing token

404 Not Found – Resource doesn’t exist

500 Internal Server Error – Server failure

