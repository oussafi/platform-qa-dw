Feature: Recherche deq articles
  En tant qu’ utilisateur
  Je veux chercher des news
  Afin de les partager avec mes collaborateur

  Scenario: CAP56 - [US-NewsBloc-06] : "Space Member" 5th View - with search bar (search article by title)
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'CAP56' est crée
    When je clique sur poster dans l'espace
    And je clique sur 'écrire un article'
    And j'ajoute un article avec les données suivants
      | Titre   | ArticleTitreCAP56   |
      | Contenu | ArticleContenuCAP56 |
    And je navigue vers la page actualité
    And je je cherche l'article 'ArticleTitreCAP56'
    Then l'article recherché est affiché
    When je je cherche l'article 'wrongName'
    Then aucun article trouvé

  Scenario: CAP57 - [US-NewsBloc-06] : "Space Member" 5th View - with search bar (search article by creation user)
    Given Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    And l'espace 'CAP57' est crée
    When je clique sur poster dans l'espace
    And je clique sur 'écrire un article'
    And j'ajoute un article avec les données suivants
      | Titre   | ArticleTitreCAP57   |
      | Contenu | ArticleContenuCAP57 |
    And je navigue vers la page actualité
    And je je cherche l'article 'john'
    Then l'article recherché est affiché
    When je je cherche l'article 'wrongName'
    Then aucun article trouvé
