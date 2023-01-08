-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : dim. 08 jan. 2023 à 13:17
-- Version du serveur : 5.7.36
-- Version de PHP : 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `emailapp`
--

-- --------------------------------------------------------

--
-- Structure de la table `emails`
--

DROP TABLE IF EXISTS `emails`;
CREATE TABLE IF NOT EXISTS `emails` (
  `idE` int(11) NOT NULL AUTO_INCREMENT,
  `objet` varchar(100) NOT NULL,
  `contenu` text NOT NULL,
  `date` date NOT NULL,
  `envoyea` int(11) NOT NULL,
  `envoyepar` int(11) NOT NULL,
  PRIMARY KEY (`idE`),
  KEY `envoyepar` (`envoyepar`) USING BTREE,
  KEY `envoyea` (`envoyea`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `emails`
--

INSERT INTO `emails` (`idE`, `objet`, `contenu`, `date`, `envoyea`, `envoyepar`) VALUES
(1, 'objet', 'contenu', '2023-01-02', 1, 1),
(3, 'qddqd', 'dqddq', '2023-01-03', 1, 1),
(6, 'sa', 'azza', '2023-01-03', 1, 1),
(7, 'azzaza', 'zazaza', '2023-01-03', 1, 1),
(8, 'sqskdd', 'kqsdkls', '2023-01-03', 1, 1),
(9, 'demande', 'blablabla', '2023-01-08', 1, 1),
(10, '2sd2d', 's2ds2d', '2023-01-08', 1, 1),
(11, 'ff', 'fff', '2023-01-08', 2, 1),
(12, 'za', 'za', '2023-01-08', 2, 2),
(13, 'aaz', 'zaza', '2023-01-08', 1, 2);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `idU` int(11) NOT NULL AUTO_INCREMENT,
  `nomcomplet` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `mdp` varchar(50) NOT NULL,
  PRIMARY KEY (`idU`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`idU`, `nomcomplet`, `email`, `mdp`) VALUES
(1, 'wassimmriri', 'wass@sss.fff', '123456'),
(2, 'az', 'za', 'za');

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `emails`
--
ALTER TABLE `emails`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`envoyea`) REFERENCES `users` (`idU`),
  ADD CONSTRAINT `fk2` FOREIGN KEY (`envoyepar`) REFERENCES `users` (`idU`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
