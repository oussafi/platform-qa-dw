Feature: épingler les articles
  En tant qu’ utilisateur
  Je veux épingler des news
  Afin de les partager avec mes collaborateur

  Scenario: CAP31 - [US-PinHome-03]: Pin article from News details
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'CAP31' est crée
    And je clique sur poster dans l'espace
    And je clique sur 'écrire un article'
    And j'ajoute un article avec les données suivants
      | Titre   | ArticleTitreCAP31   |
      | Contenu | ArticleContenuCAP31 |
    And L'article est affiché dans l'activity stream de l'espace
    When je clique sur le titre de l'article dans l'activity stream
    And je clique sur 'Pin un article'
    Then un message de confirmation est affiché 'Cet article sera épinglé sur la page d’accueil et rendu visible à tous. Confirmez-vous cette action?'
    And un button 'Confirmer' est affiché
    And un button 'Annuler' est affiché
