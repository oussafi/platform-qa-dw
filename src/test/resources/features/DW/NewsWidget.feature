Feature: Vérifications du news Widget
  En tant qu’ utilisateur
  Je veux vérifier news Widget dans la page d'acceuil
  Afin de le valider

  @Pending @Wait_Until_fixing_Bug
  Scenario: US3.14[FRONT/BACK]:News widget display
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'CAPwidget' est crée
    And je clique sur poster dans l'espace
    And je clique sur 'écrire un article'
    And j'ajoute un article avec les données suivants
      | Titre   | ArticleTitreCAPwidget   |
      | Contenu | ArticleContenuCAPwidget |
    And L'article est affiché dans l'activity stream de l'espace
    And je clique sur le titre de l'article dans l'activity stream
    And je clique sur 'Pin un article'
    And je confirme
    When je navigue vers la page d'acceuil
    Then les news sont affiché dans le widget
