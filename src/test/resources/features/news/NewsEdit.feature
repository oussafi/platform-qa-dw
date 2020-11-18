Feature: Modification des news
  En tant qu’ utilisateur
  Je veux modifier des news
  Afin de les partager avec mes collaborateur


  Scenario: CAP26 - [US-EditNews-01]: check that the button "update" disabled by default
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'CAP26' est crée
    And je clique sur poster dans l'espace
    And je clique sur 'écrire un article'
    And j'ajoute un article avec les données suivants
      | Titre   | ArticleTitreCAP26   |
      | Contenu | ArticleContenuCAP26 |
    And L'article est affiché dans l'activity stream de l'espace
    When je clique sur le titre de l'article dans l'activity stream
    And je clique sur 'edit'
    Then La page 'modifier un article' est affichée
    And le button est désactivé par défaut

  Scenario: CAP27 - [US-EditNews-01]: update News
  Etant donné Je suis connecté avec l'utilisateur avec les identifiants
  | login    | john   |
  | password | gtngtn |
    And l'espace 'CAP27' est crée
    And je clique sur poster dans l'espace
    And je clique sur 'écrire un article'
    And j'ajoute un article avec les données suivants
      | Titre   | ArticleTitreCAP27   |
      | Contenu | ArticleContenuCAP27 |
    And L'article est affiché dans l'activity stream de l'espace
    When je clique sur le titre de l'article dans l'activity stream
    And je clique sur 'edit'
    And je modifie l'article contenant une image <cap02.png>
      | Contenu | ArticleContenuCAP27Edit |
      | Titre   | ArticleTitreCAP27Edit   |
    Then l'article modifié est affiché avec l'image ajoutée