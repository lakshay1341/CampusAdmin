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
- **View All Students**: A table displaying all students with options to edit or delete.

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

#### 5. Get All Students
- **URL**: `/all`
- **Method**: `GET`
- **Response**:
```json
[
    {
        "studentId": 1,
        "studentName": "John Doe",
        ...
    },
    ...
]
```
- **Status Code**:
  - `200 OK` on success.

## Frontend Implementation Overview

The frontend is built using HTML and Bootstrap for styling. The main functionalities include forms for adding and updating students, as well as tables for displaying student data.

### Key Components

1. **Student Form**
   - Allows users to input student details for creation or updates.

2. **Update Form**
   - Specifically designed to update an existing student's name by ID.

3. **Find Form**
   - Enables users to search for students by their ID.

4. **Student Table**
   - Displays all students with options to edit or delete each record.

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

The CampusAdmin project provides a comprehensive solution for managing student records efficiently using modern web technologies. With a clear separation between frontend and backend components, it ensures scalability and maintainability moving forward.

---

This documentation serves as a guide for understanding, setting up, and utilizing the CampusAdmin project effectively.

Citations:
[1] https://ppl-ai-file-upload.s3.amazonaws.com/web/direct-files/47368608/43be5da6-7f5f-458a-8e0f-89f8638f14d5/paste.txt
[2] https://ppl-ai-file-upload.s3.amazonaws.com/web/direct-files/47368608/815494f2-f041-4512-a1d7-9b30b395d834/paste.txt
[3] https://github.com/lakshay1341/CampusAdmin
