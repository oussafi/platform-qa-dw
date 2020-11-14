# language: fr
Fonctionnalité: Publication des activités
  En tant qu’ utilisateur
  Je veux publier des activité
  Afin de les partager avec mes collaborateur

  Scénario: CAP03 - [US-ShortMessage-01]: post a short message from drawer
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'ShortMessageCAP03' est crée
    Quand je clique sur poster dans l'espace
    Et je saisie une activité 'activité CAP03'
    Et je publie l'activité
    Alors l'activité 'activité CAP03' est affiché dans l'activity stream

  Scénario:CAP63 - [US-ShortMessage-02 ]:check the display "Switch to an article" link when exceeds 1300 characters (redactor case)
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'ShortMessageCAP63' est crée
    Quand je clique sur poster dans l'espace
    Et je saisie une activité plus de 1300 caractères
    Alors Un lien qui permet de basculer vers un article est affiché

  Scénario:CAP64 - [US-ShortMessage-02 ]: when user click on "Switch to an article",he is redirected to a new tab (redactor case)
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'ShortMessageCAP64' est crée
    Quand je clique sur poster dans l'espace
    Et je saisie une activité plus de 1300 caractères
    Et je clique sur basculer vers un article
    Alors La formulaire ajouter un article est affichée
    Et l'article est affiché avec le bon contenu

  Scénario:CAP86 - [US-ShortMessage-03]: check that attachments are displayed when user switch to "write an article" Form
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'ShortMessageCAP86' est crée
    Quand je clique sur poster dans l'espace
    Et je saisie une activité plus de 1300 caractères
    Et j'atache le fichier 'text.txt'
    Et je clique sur basculer vers un article
    Alors La formulaire ajouter un article est affichée
    Et l'article est affiché avec le bon contenu
    Et le fichier attaché est affiché