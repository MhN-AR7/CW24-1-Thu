## Phase 1 — Domain Model & Inheritance

**Target:** Design an entity hierarchy using Hibernate inheritance and implement base entity mapping.

**Implementation:**

1. Create an abstract class `LibraryItem` with shared fields:

- `id`, `title`, `publishYear`, `availableCopies`
- Use the `JOINED` inheritance strategy
2. Create three concrete subclasses:

- `Book`: fields `isbn`, `author`, `pageCount`
- `Magazine`: fields `issueNumber`, `publisher`, `frequency` (enum: `WEEKLY`, `MONTHLY`, `QUARTERLY`)
- `Manuscript`: fields `originCountry`, `estimatedAge`, `isFragile`
3. Create the `Member` entity:

- `id`, `fullName`, `email`, `membershipDate`, `membershipStatus` (enum: `ACTIVE`, `SUSPENDED`, `EXPIRED`)
4. Create the `Loan` entity:

- `id`, `loanDate`, `dueDate`, `returnDate` (nullable), `status` (enum: `ACTIVE`, `RETURNED`, `OVERDUE`)

**Test Scenario:**

A Book with isbn=978-964-05-0 and author=“Sadegh Hedayat”

A Magazine with issueNumber=42 and frequency=MONTHLY

A Manuscript with isFragile=true and estimatedAge=500

Three Members with different statuses


## Phase 2 — Associations & CRUD

**Target:** Implement relationships between entities and full CRUD operations with correct transaction management.

**Implementation:**

1. Add the `Member` → `Loan` relationship:
- A Member can have multiple Loans
- On the `Loan` side, define the `member` field

**Test Scenario:**

Member with id=1 borrows the book with id=3
Verify availableCopies decreased by one
Then return the item and verify returnDate and status
Attempting to borrow with a SUSPENDED member should throw an Exception


Phase 3: Basic JPQL Queries

Focus: fundamental entity querying, filtering, and simple aggregation.

**Scope:**

- Find `Book` entities by publication year
- Find `Member` entities by last name prefix
- Count active (non-returned) `Loan` records
