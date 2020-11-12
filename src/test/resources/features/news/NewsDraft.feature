# language: fr
Fonctionnalité: Création des draft
  En tant qu’ utilisateur
  Je veux sauvgarder le brouillon de mes articles
  Afin de reprendre leurs écritures

  Scénario: CAP20 - [US-NewsDraft-02] : check the drawer "Your Drafts"
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'CAP20' est crée
    Quand je clique sur poster dans l'espace
    Et je clique sur 'écrire un article'
    Et je saisie les données de l'article
      | Titre  | ArticleTitreCAP20  |
      | Résumé | ArticleRésuméCAP20 |
      | Contenu | ArticleContenuCAP20 |
    Et je clique sur 'Brouillons'
    Alors Les détails du brouillons sont affichés

  Scénario: CAP21 - [US-NewsDraft-02] : Resume draft
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'CAP21' est crée
    Quand je clique sur poster dans l'espace
    Et je clique sur 'écrire un article'
    Et je saisie les données de l'article
      | Titre  | ArticleTitreCAP21  |
      | Résumé | ArticleRésuméCAP21 |
      | Contenu | ArticleContenuCAP21 |
    Et je clique sur 'Brouillons'
    Et je clique sur 'resume'
    Alors La formulaire ajouter un article est affichée