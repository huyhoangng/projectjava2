-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Dec 26, 2023 at 02:36 AM
-- Server version: 5.7.24
-- PHP Version: 8.0.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `projectjava2`
--

-- --------------------------------------------------------

--
-- Table structure for table `customerlist`
--

CREATE TABLE `customerlist` (
  `ID` int(5) NOT NULL,
  `FullName` varchar(100) NOT NULL,
  `DOB` date NOT NULL,
  `Address` varchar(500) NOT NULL,
  `Car` varchar(30) NOT NULL,
  `Date Start` date NOT NULL,
  `Days` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customerlist`
--

INSERT INTO `customerlist` (`ID`, `FullName`, `DOB`, `Address`, `Car`, `Date Start`, `Days`) VALUES
(1, 'Nguyễn Việt Hoàng', '2000-08-14', 'Ba Đình, Hà Nội', 'Toyota Camry', '2024-01-01', 5),
(2, 'Huy Hoang', '2000-08-11', 'BTL, Ha Noi', 'Toyota Camrry', '2024-01-01', 4),
(3, 'Đặng Công Thành', '2002-05-12', 'Bắc Ninh', 'Mazda CX5', '2024-02-10', 5),
(4, 'Nguyễn Đức Minh', '2002-03-20', 'Hà Nội', 'Toyota Víos', '2024-01-20', 5),
(5, 'Lê văn Minh', '2001-05-02', 'Tp.HCM', 'Toyota Fortuner', '2024-02-10', 7),
(6, 'Đặng Ngọc Ánh', '2003-04-26', 'Bắc Ninh', 'Hyundai Accent', '2024-02-01', 6),
(7, 'Trần Văn Linh', '2000-10-05', 'Hà Nội', 'Mercedes-Benz E300', '2024-02-01', 6),
(8, 'Kiều Quốc Anh', '2000-05-05', 'Đà Nẵng', 'Kia K5', '2024-02-01', 8),
(9, 'Nguyễn Văn A', '1999-12-05', 'Tp.HCM', 'Mercedes-Benz G63', '2024-05-10', 12),
(10, 'Trần Thị B', '2002-02-10', 'Hà Nội', 'Hyundai Tucson', '2024-03-10', 5),
(11, 'Trần Thị D', '1997-10-05', 'Vũng Tàu', 'Mitsubishi Xpander', '2024-02-10', 10),
(12, 'Nguyễn Văn M', '1999-05-12', 'Đà Nẵng', 'Mazda CX5', '2024-03-15', 5),
(13, 'Trần Thị F', '1999-06-23', 'Tp.Huế', 'Kia K5', '2024-05-15', 12),
(14, 'Nguyễn Thị T', '2000-11-15', 'Hà Nội', 'Huyndai Tucson', '2024-12-10', 20);

-- --------------------------------------------------------

--
-- Table structure for table `donelist`
--

CREATE TABLE `donelist` (
  `ID` int(20) NOT NULL,
  `FullName` varchar(100) NOT NULL,
  `DOB` date NOT NULL,
  `Address` varchar(300) NOT NULL,
  `Car` varchar(50) NOT NULL,
  `Days` int(30) NOT NULL,
  `Note` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `donelist`
--

INSERT INTO `donelist` (`ID`, `FullName`, `DOB`, `Address`, `Car`, `Days`, `Note`) VALUES
(10, 'Nguyễn Văn C', '2000-02-10', 'Hà Nội', 'Toyota Camry', 5, 'Trả xe ngày 2023-12-20.\r\nĐã thanh toán'),
(11, 'Phạm Thị M', '1995-11-20', 'Tp.HCM', 'Kia K5', 8, 'Trả xe ngày 2023-10-30.\r\nĐã thanh toán.\r\nXước bên phụ(thu thêm 200,000đ)'),
(12, 'Trần Thị A', '1999-12-02', 'Hà Giang', 'Hyundai Accent', 10, 'Trả xe ngày 2023-10-10.\r\nĐã thanh toán'),
(13, 'Lê Văn C', '1998-02-12', 'Hải Phòng', 'Hyundai Tucson', 5, 'Trả xe ngày 2023-10-25.\r\nChưa thanh toán'),
(14, 'Trần Thị Lung Linh', '2001-02-12', 'Ninh Bình', 'Mercedes-Benz G63', 5, 'Trả xe ngày 2023-12-30.\r\nĐã thanh toán'),
(15, 'Nguyễn Văn H', '1997-12-25', 'Tp.HCM', 'Toyota Víos', 6, 'Trả xe ngày 2023-08-20.\r\nChưa thanh toán'),
(16, 'Nguyễn Thị D', '2001-10-05', 'Nam Định', 'Mercedes-Benz G63', 5, 'Trả xe ngày 2023-05-10.\r\nĐã thanh toán.\r\nCó xước nhẹ( không thu thêm phí)'),
(17, 'Lê Văn V', '1999-12-05', 'Đà Nẵng', 'Hyundai Accent', 6, 'Trả xe ngày 2023-10-20.\r\nChưa thanh toán.'),
(18, 'Lê Bình T', '2000-10-20', 'Hà Nội', 'Kia Sorento', 8, 'Đã trả xe ngày 2023-12-10'),
(19, 'Mai Lại Đến', '1997-05-20', 'Tp.HCM', 'Porsche Panamera', 6, 'Đã trả xe ngày 2022-12-31.\r\nĐã thanh toán đầy đủ'),
(20, 'Trần Văn C', '1999-02-12', 'Đà Nẵng', 'Toyota Corolla Cross', 12, 'Đã trả xe ngày 2023-05-20\nĐã thanh toán '),
(21, 'Mai Văn K', '1989-01-30', 'Tp.HCM', 'Audi A8', 5, 'Chưa trả xe. \r\nĐã thanh toán 70%'),
(22, 'Trần Văn S', '2001-05-28', 'Tp.HCM', 'Kia K3', 5, 'Chưa trả xe .\nĐã thanh toán 60%'),
(23, 'Đỗ Văn Z', '1990-08-20', 'Hà Nội ', 'Lamborghini Urus', 7, 'Chưa trả xe.\nĐã thanh toán 80%');

-- --------------------------------------------------------

--
-- Table structure for table `ourcar`
--

CREATE TABLE `ourcar` (
  `iDCar` int(11) NOT NULL,
  `nameCar` varchar(100) NOT NULL,
  `status` varchar(300) NOT NULL,
  `color` varchar(100) NOT NULL,
  `seats` int(20) NOT NULL,
  `position` varchar(200) NOT NULL,
  `Price` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ourcar`
--

INSERT INTO `ourcar` (`iDCar`, `nameCar`, `status`, `color`, `seats`, `position`, `Price`) VALUES
(1, 'Toyota Vios', 'Available', 'Grey', 4, 'Hà Nội', 30),
(2, 'Toyota Camry', 'Available', 'Black', 5, 'Hà Nội', 40),
(3, 'Mitsubishi Xpander', 'Invalid', 'Gray', 7, 'TP.HCM', 40),
(4, 'Mazda CX5', 'Available', 'Red', 5, 'Đà Nẵng', 40),
(5, 'Toyota Fortuner', 'Invalid', 'Gray', 7, 'Đà Nẵng', 50),
(6, 'Hyundai Accent', 'Available', 'Red', 5, 'Tp.Hcm', 30),
(7, 'Mercedes-Benz E300', 'Available', 'White', 5, 'Hà Nội', 70),
(8, 'Hyundai Tucson', 'Invalid', 'Black', 5, 'Hà Nội', 40),
(9, 'Kia K5', 'Available', 'White', 5, 'Đà Nẵng', 40),
(10, 'Mercedes-Benz G63', 'Invalid', 'Gray', 5, 'Tp.HCM', 100),
(11, 'Kia K3', 'Invalid', 'Red', 5, 'Tp.HCM', 30),
(12, 'Mazda 6', 'Available', 'White', 5, 'Hà Nội', 40),
(13, 'Mercedes-Benz GLC300', 'Available', 'Black', 5, 'Đà Nẵng', 50),
(14, 'Audi A8', 'Invalid', 'Black', 5, 'Tp.HCM', 60),
(15, 'BMW X7', 'Available', 'Grey', 7, 'Hà Nội', 80),
(16, 'Ford Everest', 'Available', 'Black', 7, 'Hà Nội', 50),
(17, 'Toyota Innova', 'Invalid', 'Grey', 7, 'Tp.HCM', 40),
(18, 'Porsche Panamera', 'Available', 'White', 4, 'Tp.HCM', 80),
(19, 'Lamborghini Urus', 'Invalid', 'Yellow', 4, 'Hà Nội', 100),
(20, 'Toyota Corolla Cross', 'Available', 'Grey', 5, 'Đà Nẵng', 40),
(21, 'Kia Sorento', 'Available', 'White', 7, 'Hà Nội', 40),
(22, 'Honda CR-V', 'Invalid', 'Black', 7, 'Tp.HCM', 40);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customerlist`
--
ALTER TABLE `customerlist`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `donelist`
--
ALTER TABLE `donelist`
  ADD PRIMARY KEY (`ID`);

--
-- Indexes for table `ourcar`
--
ALTER TABLE `ourcar`
  ADD PRIMARY KEY (`iDCar`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `customerlist`
--
ALTER TABLE `customerlist`
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT for table `donelist`
--
ALTER TABLE `donelist`
  MODIFY `ID` int(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=24;

--
-- AUTO_INCREMENT for table `ourcar`
--
ALTER TABLE `ourcar`
  MODIFY `iDCar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
