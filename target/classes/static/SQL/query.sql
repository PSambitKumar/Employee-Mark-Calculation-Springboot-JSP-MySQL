# Assessment Query
CREATE TABLE Batch_Master (
                              Batch_id INT AUTO_INCREMENT PRIMARY KEY,
                              Batch_Name VARCHAR(50),
                              Batch_Start_Date DATE,
                              Batch_strength INT
);

INSERT INTO Batch_Master (Batch_Name, Batch_Start_Date, Batch_strength)
VALUES ('FY 22-23 Batch 1', '2023-04-04', 6);

INSERT INTO Batch_Master (Batch_Name, Batch_Start_Date, Batch_strength)
VALUES ('FY 22-23 Batch 2', '2023-04-04', 67);

INSERT INTO Batch_Master (Batch_Name, Batch_Start_Date, Batch_strength)
VALUES ('FY 22-23 Batch 3', '2023-04-04', 46);

-- Create the Technology_Master table
CREATE TABLE Technology_Master (
                                   Technology_id INT AUTO_INCREMENT PRIMARY KEY,
                                   Teeechnology_Name VARCHAR(50)
);

-- Insert data into the Technology_Master table
INSERT INTO Technology_Master (Teeechnology_Name) VALUES ('Dot Net');
INSERT INTO Technology_Master (Teeechnology_Name) VALUES ('Python');
INSERT INTO Technology_Master (Teeechnology_Name) VALUES ('Java');
INSERT INTO Technology_Master (Teeechnology_Name) VALUES ('PHP');
INSERT INTO Technology_Master (Teeechnology_Name) VALUES ('Database');

-- Create the Employee_Master table
CREATE TABLE Employee_Master (
                                 Employee_id INT AUTO_INCREMENT PRIMARY KEY,
                                 Employee_Name VARCHAR(50),
                                 Employee_Phone VARCHAR(50),
                                 Employee_Email VARCHAR(50)
);

-- Insert data into the Employee_Master table
INSERT INTO Employee_Master (Employee_Name, Employee_Phone, Employee_Email) VALUES ('Sunil Sarangi','9861098610','sunil@gmail.com');
INSERT INTO Employee_Master (Employee_Name, Employee_Phone, Employee_Email) VALUES ('Rabi Mohanty','9771497714','rabi@gmail.com');
INSERT INTO Employee_Master (Employee_Name, Employee_Phone, Employee_Email) VALUES ('Harish Jha','9861198611','harish@gmail.com');
INSERT INTO Employee_Master (Employee_Name, Employee_Phone, Employee_Email) VALUES ('Rama Mishra','9861298612','rama@gmail.com');
INSERT INTO Employee_Master (Employee_Name, Employee_Phone, Employee_Email) VALUES ('Puirna Mishra','9861398613','Purna@gmail.com');
INSERT INTO Employee_Master (Employee_Name, Employee_Phone, Employee_Email) VALUES ('Rosa Sahoo','9861498614','rosa@gmail.com');

-- Create the Batch_Allocate table
CREATE TABLE Batch_Allocate (
                                Batch_Allocate_id INT AUTO_INCREMENT PRIMARY KEY,
                                Batch_id INT,
                                Technology_id INT,
                                Employee_id INT
);

-- Insert data into the Batch_Allocate table
INSERT INTO Batch_Allocate (Batch_id, Technology_id, Employee_id) VALUES (1,1,1);
INSERT INTO Batch_Allocate (Batch_id, Technology_id, Employee_id) VALUES (1,5,2);
INSERT INTO Batch_Allocate (Batch_id, Technology_id, Employee_id) VALUES (1,1,3);
INSERT INTO Batch_Allocate (Batch_id, Technology_id, Employee_id) VALUES (1,3,4);
INSERT INTO Batch_Allocate (Batch_id, Technology_id, Employee_id) VALUES (1,4,5);
INSERT INTO Batch_Allocate (Batch_id, Technology_id, Employee_id) VALUES (1,2,6);

-- Create the Assement_Mark table
CREATE TABLE Assement_Mark (
                               slno INT AUTO_INCREMENT PRIMARY KEY,
                               empid INT,
                               mark INT
);