-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3308
-- Generation Time: Jan 04, 2024 at 08:05 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `project1_teacher`
--

-- --------------------------------------------------------

--
-- Table structure for table `attendence`
--

CREATE TABLE `attendence` (
  `Id` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `Date` varchar(20) NOT NULL,
  `Present` varchar(20) NOT NULL,
  `NoClassAttend` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `ct`
--

CREATE TABLE `ct` (
  `Id` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `CT1` int(11) NOT NULL,
  `CT2` int(11) NOT NULL,
  `CT3` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ct`
--

INSERT INTO `ct` (`Id`, `Name`, `CT1`, `CT2`, `CT3`) VALUES
(19029, 'shuvon', 20, 18, 15);

-- --------------------------------------------------------

--
-- Table structure for table `result`
--

CREATE TABLE `result` (
  `Id` int(11) NOT NULL,
  `Name` varchar(20) NOT NULL,
  `CT` int(11) NOT NULL,
  `Attendence` int(11) NOT NULL,
  `Total_30` int(11) NOT NULL,
  `Theory` int(11) NOT NULL,
  `Grade` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `result`
--

INSERT INTO `result` (`Id`, `Name`, `CT`, `Attendence`, `Total_30`, `Theory`, `Grade`) VALUES
(19029, 'shuvon', 19, 3, 22, 65, 'A+'),
(19047, 'ruhan', 0, 3, 3, 60, 'B'),
(19029, 'shuvon', 19, 3, 22, 65, 'A+'),
(19047, 'ruhan', 0, 3, 3, 65, 'B+');

-- --------------------------------------------------------

--
-- Table structure for table `student`
--

CREATE TABLE `student` (
  `Name` varchar(20) NOT NULL,
  `Id` int(11) NOT NULL,
  `Dept` varchar(20) NOT NULL,
  `Session` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `student`
--

INSERT INTO `student` (`Name`, `Id`, `Dept`, `Session`) VALUES
('shuvon', 19029, 'cse', '2018-19'),
('ruhan', 19047, 'cse', '2018-19');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
