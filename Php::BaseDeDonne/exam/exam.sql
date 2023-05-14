-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : jeu. 22 déc. 2022 à 21:35
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `exam`
--

-- --------------------------------------------------------

--
-- Structure de la table `Enfants`
--

CREATE TABLE `Enfants` (
  `id` int(11) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `prenom` varchar(200) NOT NULL,
  `pays` varchar(200) NOT NULL,
  `ville` varchar(200) NOT NULL,
  `codepostal` varchar(200) NOT NULL,
  `age` int(11) NOT NULL,
  `cadeau` varchar(200) NOT NULL,
  `niveaudesagesse` int(11) NOT NULL,
  `username` varchar(200) NOT NULL,
  `pass` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `Enfants`
--

INSERT INTO `Enfants` (`id`, `nom`, `prenom`, `pays`, `ville`, `codepostal`, `age`, `cadeau`, `niveaudesagesse`, `username`, `pass`) VALUES
(3, 'o', 'o', 'o', 'o', 'o', 8, 'o', 8, 'ala', 'ala'),
(4, 'b', 'b', 'b', 'b', 'b', 9, 'b', 9, 'mouna', 'mouna');

-- --------------------------------------------------------

--
-- Structure de la table `pereNoel`
--

CREATE TABLE `pereNoel` (
  `id` int(11) NOT NULL,
  `nom` varchar(200) NOT NULL,
  `username` varchar(200) NOT NULL,
  `pass` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `pereNoel`
--

INSERT INTO `pereNoel` (`id`, `nom`, `username`, `pass`) VALUES
(1, 'papa', 'papa', 'papa');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `Enfants`
--
ALTER TABLE `Enfants`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `pereNoel`
--
ALTER TABLE `pereNoel`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `Enfants`
--
ALTER TABLE `Enfants`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `pereNoel`
--
ALTER TABLE `pereNoel`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
