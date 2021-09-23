-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 15, 2021 at 09:22 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `hsbc_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `amenities`
--

CREATE TABLE `amenities` (
  `amenityId` int(11) NOT NULL,
  `amenityName` varchar(255) NOT NULL,
  `amenityCredit` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `amenities`
--

INSERT INTO `amenities` (`amenityId`, `amenityName`, `amenityCredit`) VALUES
(1, 'Projector', 5),
(2, 'WiFi Connection', 10),
(3, 'Conference Call Facility', 15),
(4, 'Whiteboard', 5),
(5, 'Water Dispenser', 5),
(6, 'TV', 10),
(7, 'Coffee Machine', 10);

-- --------------------------------------------------------

--
-- Table structure for table `booking`
--

CREATE TABLE `booking` (
  `bookingId` int(11) NOT NULL,
  `meetingRoomName` varchar(255) NOT NULL,
  `meetingDate` date NOT NULL,
  `startTime` time NOT NULL,
  `endTime` time NOT NULL,
  `bookedBy` int(11) NOT NULL,
  `meetingType` varchar(255) NOT NULL COMMENT 'Make sure the type is case sensitive..handle that in code',
  `title` varchar(255) DEFAULT NULL,
  `bookingStatus` int(11) NOT NULL DEFAULT 0 COMMENT '0:Active,1:non-active',
  `costOfMeeting` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `feedback`
--

CREATE TABLE `feedback` (
  `feedbackId` int(11) NOT NULL,
  `meetingRoomName` varchar(255) NOT NULL,
  `userId` int(11) NOT NULL,
  `rating` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `meetingroom`
--

CREATE TABLE `meetingroom` (
  `meetingRoomName` varchar(255) NOT NULL,
  `capacity` int(11) NOT NULL,
  `roomStatus` int(11) NOT NULL DEFAULT 0 COMMENT '0:Active,1:Inactive'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `meeting_attenders`
--

CREATE TABLE `meeting_attenders` (
  `id` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `bookingId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `room_amenity`
--

CREATE TABLE `room_amenity` (
  `id` int(11) NOT NULL,
  `meetingRoomName` varchar(255) NOT NULL,
  `amenityId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userId` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `credit` int(11) NOT NULL,
  `role` varchar(255) NOT NULL,
  `active` int(11) NOT NULL DEFAULT 0 COMMENT '0:Active User, 1: Not Active',
  `lastLogin` datetime NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `amenities`
--
ALTER TABLE `amenities`
  ADD PRIMARY KEY (`amenityId`);

--
-- Indexes for table `booking`
--
ALTER TABLE `booking`
  ADD PRIMARY KEY (`bookingId`),
  ADD KEY `meetingRoomName` (`meetingRoomName`),
  ADD KEY `bookedBy` (`bookedBy`);

--
-- Indexes for table `feedback`
--
ALTER TABLE `feedback`
  ADD PRIMARY KEY (`feedbackId`),
  ADD KEY `userId` (`userId`),
  ADD KEY `meetingRoomName` (`meetingRoomName`);

--
-- Indexes for table `meetingroom`
--
ALTER TABLE `meetingroom`
  ADD PRIMARY KEY (`meetingRoomName`);

--
-- Indexes for table `meeting_attenders`
--
ALTER TABLE `meeting_attenders`
  ADD PRIMARY KEY (`id`),
  ADD KEY `bookingId` (`bookingId`),
  ADD KEY `userId` (`userId`);

--
-- Indexes for table `room_amenity`
--
ALTER TABLE `room_amenity`
  ADD PRIMARY KEY (`id`),
  ADD KEY `amenityId` (`amenityId`),
  ADD KEY `meetingRoomName` (`meetingRoomName`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `amenities`
--
ALTER TABLE `amenities`
  MODIFY `amenityId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `booking`
--
ALTER TABLE `booking`
  MODIFY `bookingId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `feedback`
--
ALTER TABLE `feedback`
  MODIFY `feedbackId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `meeting_attenders`
--
ALTER TABLE `meeting_attenders`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `room_amenity`
--
ALTER TABLE `room_amenity`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `booking`
--
ALTER TABLE `booking`
  ADD CONSTRAINT `booking_ibfk_1` FOREIGN KEY (`meetingRoomName`) REFERENCES `meetingroom` (`meetingRoomName`),
  ADD CONSTRAINT `booking_ibfk_2` FOREIGN KEY (`bookedBy`) REFERENCES `users` (`userId`);

--
-- Constraints for table `feedback`
--
ALTER TABLE `feedback`
  ADD CONSTRAINT `feedback_ibfk_1` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`),
  ADD CONSTRAINT `feedback_ibfk_2` FOREIGN KEY (`meetingRoomName`) REFERENCES `meetingroom` (`meetingRoomName`);

--
-- Constraints for table `meeting_attenders`
--
ALTER TABLE `meeting_attenders`
  ADD CONSTRAINT `meeting_attenders_ibfk_1` FOREIGN KEY (`bookingId`) REFERENCES `booking` (`bookingId`),
  ADD CONSTRAINT `meeting_attenders_ibfk_2` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`);

--
-- Constraints for table `room_amenity`
--
ALTER TABLE `room_amenity`
  ADD CONSTRAINT `room_amenity_ibfk_1` FOREIGN KEY (`amenityId`) REFERENCES `amenities` (`amenityId`),
  ADD CONSTRAINT `room_amenity_ibfk_2` FOREIGN KEY (`meetingRoomName`) REFERENCES `meetingroom` (`meetingRoomName`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
