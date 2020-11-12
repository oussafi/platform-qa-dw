# language: fr
Fonctionnalité: Recherche deq articles
  En tant qu’ utilisateur
  Je veux chercher des news
  Afin de les partager avec mes collaborateur

  Scénario: CAP56 - [US-NewsBloc-06] : "Space Member" 5th View - with search bar (search article by title)
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'CAP56' est crée
    Quand je clique sur poster dans l'espace
    Et je clique sur 'écrire un article'
    Et j'ajoute un article avec les données suivants
      | Titre   | ArticleTitreCAP56   |
      | Contenu | ArticleContenuCAP56 |
    Et je navigue vers la page actualité
    Et je je cherche l'article 'ArticleTitreCAP56'
    Alors l'article recherché est affiché
    Quand je je cherche l'article 'wrongName'
    Alors aucun article trouvé

  Scénario: CAP57 - [US-NewsBloc-06] : "Space Member" 5th View - with search bar (search article by creation user)
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'CAP57' est crée
    Quand je clique sur poster dans l'espace
    Et je clique sur 'écrire un article'
    Et j'ajoute un article avec les données suivants
      | Titre   | ArticleTitreCAP57   |
      | Contenu | ArticleContenuCAP57 |
    Et je navigue vers la page actualité
    Et je je cherche l'article 'john'
    Alors l'article recherché est affiché
    Quand je je cherche l'article 'wrongName'
    Alors aucun article trouvé
