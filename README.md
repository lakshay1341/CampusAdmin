# Project Documentation for CampusAdmin

## Project Overview
**Project Name**: CampusAdmin  
**Backend Framework**: Spring Boot  

CampusAdmin is a web application designed to manage student information efficiently. The application allows users to add, update, find, and delete student records through a user-friendly interface. The backend is built using Spring Boot, providing a robust and scalable solution for handling API requests.

## Features
- **Add Student**: Users can add new student records with relevant details.
- **Update Student**: Existing student records can be updated with new information.
- **Find Student**: Users can search for a student by their ID to view details.
- **Delete Student**: Users can remove a student record from the system.
- **View All Students**: A table displaying all students with pagination support for better performance and usability.

## Technical Stack
- **Frontend**: HTML, CSS (Bootstrap)
- **Backend**: Spring Boot
- **Database**: MySQL
- **API Communication**: RESTful APIs

## Installation Instructions
1. **Clone the Repository**
   ```bash
   git clone https://github.com/lakshay1341/CampusAdmin.git
   cd CampusAdmin
   ```

2. **Set Up the Database**
   - Create a database in your preferred database management system.
   - Update the `application.properties` file in the `src/main/resources` directory with your database connection details.

3. **Run the Application**
   - Navigate to the project directory and run:
   ```bash
   ./mvnw spring-boot:run
   ```
   - The application will start on `http://localhost:8080`.

4. **Access the Frontend**
   - Open your web browser and go to `http://localhost:8080`.

## API Documentation

### Base URL
```
http://localhost:8080/api/student
```

### Endpoints

#### 1. Create Student
- **URL**: `/create`
- **Method**: `POST`
- **Request Body**:
```json
{
    "studentName": "John Doe",
    "studentAge": 20,
    "studentGender": "Male",
    "studentDept": "Computer Science",
    "studentAddr": "123 Main St"
}
```
- **Response**:
  - Status Code: `201 Created` on success.
  - Status Code: `400 Bad Request` if validation fails.

#### 2. Update Student
- **URL**: `/modify`
- **Method**: `PUT`
- **Request Body**:
```json
{
    "studentId": 1,
    "studentName": "John Smith",
    "studentAge": 21,
    "studentGender": "Male",
    "studentDept": "Computer Science",
    "studentAddr": "123 Main St"
}
```
- **Response**:
  - Status Code: `200 OK` on success.
  - Status Code: `404 Not Found` if the student does not exist.

#### 3. Find Student by ID
- **URL**: `/find/{id}`
- **Method**: `GET`
- **Response**:
```json
{
    "studentId": 1,
    "studentName": "John Doe",
    "studentAge": 20,
    "studentGender": "Male",
    "studentDept": "Computer Science",
    "studentAddr": "123 Main St"
}
```
- **Status Codes**:
  - `200 OK` on success.
  - `404 Not Found` if the student does not exist.

#### 4. Delete Student
- **URL**: `/remove/{id}`
- **Method**: `DELETE`
- **Response**:
  - Status Code: `204 No Content` on success.
  - Status Code: `404 Not Found` if the student does not exist.

#### 5. Get All Students (With Pagination)
- **URL**: `/all` OR `/all?page={page_number}&size={number_of_students}`
- **Method**: `GET`
- **Query Parameters**:
  - `page`: The page number for pagination (default: 0).
  - `size`: The number of students per page (default: 10).
  
- **Response**:
```json
{
    "students": [
        {
            "studentId": 1,
            "studentName": "John Doe",
            "studentAge": 20,
            "studentGender": "Male",
            "studentDept": "Computer Science",
            "studentAddr": "123 Main St"
        },
        ...
    ],
    "currentPage": 0,
    "totalItems": 100,
    "totalPages": 10
}
```
- **Status Code**:
  - `200 OK` on success.

#### 6. Update Student Name by ID
- **URL**: `/modify/name/{id}/{name}`
- **Method**: `PATCH`
- **Response**:
  - Status Code: `200 OK` on success.
  - Status Code: `404 Not Found` if the student does not exist.

## Frontend Implementation Overview

The frontend is built using HTML and Bootstrap for styling. The main functionalities include forms for adding and updating students, as well as tables for displaying student data.

### Key Components

1. **Student Form**
   - Allows users to input student details for creation or updates.

2. **Update Form**
   - Specifically designed to update an existing student's name by ID.

3. **Find Form**
   - Enables users to search for students by their ID.

4. **Student Table with Pagination**
   - Displays all students with options to edit or delete each record. Pagination support is included to manage large datasets efficiently.

### Example Code Snippet (Frontend)
```html
<form id="studentForm">
    <input type="hidden" id="studentId">
    <div class="row g-3">
        <div class="col-md-6">
            <label for="name" class="form-label">Name</label>
            <input type="text" class="form-control" id="name" required>
        </div>
        ...
    </div>
</form>
```

## Conclusion

The CampusAdmin project provides a comprehensive solution for managing student records efficiently using modern web technologies. With the newly implemented pagination feature, users can now view large sets of student data more effectively. The clear separation between frontend and backend components ensures scalability and maintainability moving forward.
