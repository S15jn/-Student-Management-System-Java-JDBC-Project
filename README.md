---
# 🎓 Student Management System — Java JDBC Project

A **console-based Student Management System** built using **Java** and **JDBC** for managing student data and course enrollments. This project demonstrates CRUD operations (Create, Read, Update, Delete) with proper database connectivity using **MySQL**.
---

## ✅ **Features**

- 📌 **Student Management** — Add, view, update, delete student records.
- 📌 **Course Management** — Add, view, update, delete course records.
- 📌 **Enrollment System** — Enroll students in courses.
- 📌 **View Enrollment History** — Display students with their courses.
- 📌 **Search Functionality** — Search students and courses by name.
- 📌 **Proper Error Handling** — Handles SQL exceptions and input validations.

---

## 🏗️ **Project Structure**

```
├── src/
│   ├── db/                 # Database connection code
│   ├── model/              # Data models (Student, Course, Enrollment)
│   ├── dao/                # DAO classes for CRUD operations
│   ├── MainApp.java        # Main console application
├── README.md               # Project Documentation
├── schema.sql              # MySQL Database schema
```

---

## 🛠️ **Tech Stack**

- **Java 8+**
- **JDBC (Java Database Connectivity)**
- **MySQL Database**
- **IDE:** VS CODE

---

## 🗂️ **Database Schema Overview**

### Tables:

- **Students** (student_id, name, email)
- **Courses** (course_id, course_name, credits)
- **Enrollments** (enroll_id, student_id, course_id, enrollment_date)

---

## 🚀 **How to Run the Project**

1. ✅ Clone the repository.
2. ✅ Import project into your Java IDE.
3. ✅ Setup your **MySQL Database** and run the schema.
4. ✅ Update DB connection details in `DBConnection.java`.
5. ✅ Run `MainApp.java` and use the console options.

---

## 📌 **Sample Console Output**

```
===== Student Management System =====
1. Add Student
2. View All Students
3. Add Course
4. View Courses
5. Enroll Student in Course
6. View Student Enrollments
0. Exit
```

---

## 💡 **Future Improvements**

- Add GUI using **Java Swing/JavaFX**.
- Pagination support for large datasets.
- Admin login system.

---

## 🤝 **Contributing**

Feel free to fork this repository, raise issues, or submit PRs to improve this project.

---

## 📧 **Contact**

Created by \[SOMYA JAIN] — open for collaboration and discussions!
📩 Email: [jsomya068@gmail.com](mailto:jsomya068@gmail.com)

---
