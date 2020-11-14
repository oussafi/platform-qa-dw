# language: fr
Fonctionnalité: Insérer des liens
  En tant qu’ utilisateur
  Je veux publier des liens via le new composer
  Afin de les partager avec mes collaborateur

  Scénario: CAP29-[US-insertLink-01]: insert a link from composer drawer (space case)
    Etant donné Je suis connecté avec l'utilisateur avec les identifiants
      | login    | john   |
      | password | gtngtn |
    Et l'espace 'ShortMessageCAP29' est crée
    Quand je clique sur poster dans l'espace
    Et je saisie une activité 'https://www.exoplatform.com/'
    Et je publie l'activité
    Alors Le lien est affiché avec le preview