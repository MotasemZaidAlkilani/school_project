# school_project
android mobile application and with internet support which is intended for schools ,to facilitate the teaching process for students from distance.


application made to log in from four users :
1. Students
2. Parents
3. Teachers
4. Admin

### helps users by: 
1. help teachers to send educational videos and the required material, and send assignments to students(
2. help students to receive the material and assignments and able to send the solutions
3. help parents to monitor their children to know if he/she studied the required material and do his/her HomeWorks
4. help admin of the school to add teacher and students and their parents and edit the information to application


## Design

#### 1. Home Screen 
The home screen, the user have to choose one from four type (student, teacher , parents , admin).

<img src="screenshots/home.png" width=100 />

#### 2. login page
is the second page after home page which appears when the user chooses his category. In that page, if he is a new user, he can sign in by put his ssn in username and password (if he registered by admin), or if he is an existing user, he can login with the credentials.

<img src="screenshots/admin_login.png" width=100 /><img src="screenshots/teacher_login.png" width=100 /><img src="screenshots/student_login.png" width=100 /><img src="screenshots/parent_login.png" width=100 />
______

## ADMIN

#### 3. admin add users 
-student :It helps admin to add new users to database through user’s information, in below picture, it shows page that admin can add users, so for student and their parents, admin needs to add the following information :Student name, National Id, Phone number, sex, Age, Parent name, National Id and Phone for parent.

-teacher: admin needs to add 6 attributes as in figure 20 the following information : teacher name, National Id and phone, materials, sex ,Age.

other admin:When admin already stored in database and he have “add permission” in database, then he can add new admin by admin name, national id, phone, sex.

<img src="screenshots/admin_page.png" width=100 /><img src="screenshots/admin_add_student.png" width=100 /><img src="screenshots/admin_add_teacher.png" width=100 /><img src="screenshots/admin_add_other_admin.png" width=100 />

#### 4. admin search 
In admin page, admin can search for any user information in database, just by enter national id for user and choose type of user (student, admin, teacher, parent), so after choose the required, then admin need to click on search button, that button will open new activity to user information 

<img src="screenshots/admin_search.png" width=100 /><img src="screenshots/admin_change_password.png" width=100 />

#### 5. admin change logo  
Admin can change school logo that will appear when application start , so admin can change logo through setting, then press “change the school logo” , then admin must choose logo from internal storage in phone.

Admin can change school name that will appear when application start as, so admin when open setting, admin need to put new name then press ok

<img src="screenshots/splash_page.png" width=100 /><img src="screenshots/admin_change_logo.png" width=100 />

_____________
## TEACHER
### 6. Teacher Page with create class 
 the main page that appear when teacher login, in “my class” card view, when press on it, it will appear the last picture below, that show how much class teacher have already, and button to create new classes, so when press on create class, the second picture in the below will appear, teacher in this page can create class from grade 1 to 12, and each grade. can have more than 1, up to 10, and there 14 Subject that can teacher choose from subject option, and subject that can choose are the following: English, Arabic, Islamic studies, Christians studies, math, science, physics, chemistry, biology, information technology, geography, citizenship, physical education, art, so after click on create new class button, then will appear toast say “created successfully”.
 
 
<img src="screenshots/teacher_main_page.png" width=100 /><img src="screenshots/teacher_create_class.png" width=100 /><img src="screenshots/teacher_class_created.png" width=100 /><img src="screenshots/teacher_class_list.png" width=100 />

