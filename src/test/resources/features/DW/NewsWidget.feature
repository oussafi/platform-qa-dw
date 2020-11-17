# language: fr
Fonctionnalité: Vérifications du news Widget
  En tant qu’ utilisateur
  Je veux vérifier news Widget dans la page d'acceuil
  Afin de le valider

  @Pending @Wait_Until_fixing_Bug
  Scénario: US3.14[FRONT/BACK]:News widget display
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'CAPwidget' est crée
    Et je clique sur poster dans l'espace
    Et je clique sur 'écrire un article'
    Et j'ajoute un article avec les données suivants
      | Titre   | ArticleTitreCAPwidget   |
      | Contenu | ArticleContenuCAPwidget |
    Et L'article est affiché dans l'activity stream de l'espace
    Et je clique sur le titre de l'article dans l'activity stream
    Et je clique sur 'Pin un article'
    Et je confirme
    Quand je navigue vers la page d'acceuil
    Alors les news sont affiché dans le widget
