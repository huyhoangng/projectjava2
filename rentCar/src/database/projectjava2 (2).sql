-- phpMyAdmin SQL Dump
-- version 5.1.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: Jan 17, 2024 at 02:18 PM
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
  `fullName` varchar(100) NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(500) NOT NULL,
  `iDCar` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customerlist`
--

INSERT INTO `customerlist` (`ID`, `fullName`, `dob`, `address`, `iDCar`) VALUES
(1, 'Nguyễn Việt Hoàng', '2000-08-14', 'Ba Đình, Hà Nội', 1),
(2, 'Huy Hoang', '2000-08-11', 'BTL, Ha Noi', 2),
(3, 'Đặng Công Thành', '2002-05-12', 'Bắc Ninh', 3),
(4, 'Nguyễn Đức Minh', '2002-03-20', 'Hà Nội', 4),
(5, 'Lê văn Minh', '2001-05-02', 'Tp.HCM', 5),
(6, 'Đặng Ngọc Ánh', '2003-04-26', 'Bắc Ninh', 6),
(7, 'Trần Văn Linh', '2000-10-05', 'Hà Nội', 7),
(8, 'Kiều Quốc Anh', '2000-05-05', 'Đà Nẵng', 8),
(9, 'Nguyễn Văn A', '1999-12-05', 'Tp.HCM', 9),
(10, 'Trần Thị B', '2002-02-10', 'Hà Nội', 10),
(11, 'Trần Thị D', '1997-10-05', 'Vũng Tàu', 11),
(12, 'Nguyễn Văn M', '1999-05-12', 'Đà Nẵng', 12),
(13, 'Trần Thị F', '1999-06-23', 'Tp.Huế', 13),
(14, 'Nguyễn Thị T', '2000-11-15', 'Hà Nội', 14),
(15, 'DSAfszdgezsgrzg', '2000-01-03', 'ZSDgazsfdrgzsg', NULL),
(16, 'ădawd', '2024-01-03', 'ădawda', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `orders`
--

CREATE TABLE `orders` (
  `fullName` text NOT NULL,
  `dob` date NOT NULL,
  `address` varchar(300) NOT NULL,
  `nameCar` varchar(100) NOT NULL,
  `days` int(20) NOT NULL,
  `totalPrice` text NOT NULL,
  `iDCar` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `orders`
--

INSERT INTO `orders` (`fullName`, `dob`, `address`, `nameCar`, `days`, `totalPrice`, `iDCar`) VALUES
('A', '2000-11-08', 'Hn', 'Vios', 5, '1000', 1);

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
(1, 'Toyota', 'Available', 'Grey', 4, 'Hà Nội', 30),
(2, 'Toyota Camry', 'Available', 'Black', 5, 'Hà Nội', 40),
(3, 'Mitsubishi Xpander', 'Invalid', 'Gray', 6, 'TP.HCM', 40),
(4, 'Mazda CX5', 'Available', 'Red', 5, 'Đà Nẵng', 40),
(5, 'Toyota Fortuner', 'Invalid', 'Gray', 7, 'Đà Nẵng', 50),
(6, 'Hyundai Accent', 'Available', 'Red', 5, 'Tp.Hcm', 30),
(7, 'Mercedes', 'Available', 'White', 5, 'hcm', 70),
(8, 'Hyundai Tucson', 'Invalid', 'Black', 5, 'Hà Nội', 40),
(9, 'Kia K5', 'Available', 'White', 5, 'Đà Nẵng', 40),
(10, 'Mercedes-Benz G63', 'Invalid', 'Gray', 5, 'Tp.HCM', 100),
(11, 'Kia K3', 'Invalid', 'Red', 5, 'Tp.HCM', 30),
(12, 'Mazda 6', 'Available', 'White', 5, 'Hà Nội', 40),
(13, 'Mercedes-Benz GLC300', 'Available', 'Black', 5, 'Đà Nẵng', 50),
(14, 'Camry', 'Invalid', 'Black', 5, 'Tp.HCM', 60),
(17, 'Toyota Innova', 'Invalid', 'Grey', 7, 'Tp.HCM', 40),
(18, 'Porsche Panamera', 'Available', 'White', 4, 'Tp.HCM', 80),
(19, 'Lamborghini Urus', 'Invalid', 'Yellow', 4, 'Hà Nội', 100),
(20, 'Toyota Corolla Cross', 'Available', 'Grey', 5, 'Đà Nẵng', 40),
(21, 'Kia Sorento', 'Available', 'White', 7, 'Hà Nội', 40),
(22, 'Honda CR-V', 'Invalid', 'Black', 7, 'Tp.HCM', 40),
(26, 'Dream', 'avalable', 'white', 2, 'HN', 100),
(27, 'Winner X', 'Avalable', 'Black', 2, 'HN', 110),
(28, 'adwda', 'adawd', 'black', 2, 'awdwd', 1000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `customerlist`
--
ALTER TABLE `customerlist`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `iDCar` (`iDCar`);

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
  MODIFY `ID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- AUTO_INCREMENT for table `ourcar`
--
ALTER TABLE `ourcar`
  MODIFY `iDCar` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customerlist`
--
ALTER TABLE `customerlist`
  ADD CONSTRAINT `customerlist_ibfk_1` FOREIGN KEY (`iDCar`) REFERENCES `ourcar` (`iDCar`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
