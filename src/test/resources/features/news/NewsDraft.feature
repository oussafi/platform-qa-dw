Feature: Création des draft
  En tant qu’ utilisateur
  Je veux sauvgarder le brouillon de mes articles
  Afin de reprendre leurs écritures

  Scenario: CAP20 - [US-NewsDraft-02] : check the drawer "Your Drafts"
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'CAP20' est crée
    When je clique sur poster dans l'espace
    And je clique sur 'écrire un article'
    And je saisie les données de l'article
      | Titre   | ArticleTitreCAP20   |
      | Résumé  | ArticleRésuméCAP20  |
      | Contenu | ArticleContenuCAP20 |
    And je clique sur 'Brouillons'
    Then Les détails du brouillons sont affichés

  Scenario: CAP21 - [US-NewsDraft-02] : Resume draft
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'CAP21' est crée
    When je clique sur poster dans l'espace
    And je clique sur 'écrire un article'
    And je saisie les données de l'article
      | Titre   | ArticleTitreCAP21   |
      | Résumé  | ArticleRésuméCAP21  |
      | Contenu | ArticleContenuCAP21 |
    And je clique sur 'Brouillons'
    And je clique sur 'resume'
    Then La formulaire ajouter un article est affichée