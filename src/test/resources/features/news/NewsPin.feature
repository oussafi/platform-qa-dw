# language: fr
Fonctionnalité: épingler les articles
  En tant qu’ utilisateur
  Je veux épingler des news
  Afin de les partager avec mes collaborateur

  Scénario:CAP31 - [US-PinHome-03]: Pin article from News details
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'CAP31' est crée
    Et je clique sur poster dans l'espace
    Et je clique sur 'écrire un article'
    Et j'ajoute un article avec les données suivants
      | Titre   | ArticleTitreCAP31   |
      | Contenu | ArticleContenuCAP31 |
    Et L'article est affiché dans l'activity stream de l'espace
    Quand je clique sur le titre de l'article dans l'activity stream
    Et je clique sur 'Pin un article'
    Alors un message de confirmation est affiché 'Cet article sera épinglé sur la page d’accueil et rendu visible à tous. Confirmez-vous cette action?'
    Et un button 'Confirmer' est affiché
    Et un button 'Annuler' est affiché
