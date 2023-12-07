import java.util.*;
public class Queen {

        private int n;
        private Formule formule = new Formule(new ArrayList<>());

        public Queen(int nb) {
            this.n = nb;
        }

        /**
         * Retourne les clauses du problème des dames.
         */
        public Formule getDamesFormule() {
            damesSurAuMoinsUneCase();
            damesSurAuPlusUneLigne();
            damesSurAuPlusUneColonne();
            auPlusUneDameSurAntiDiag();
            auPlusUneDameSurDiag();
            return formule;
        }

        /**
         * Génère les clauses pour la condition : une dame sur au moins une case.
         */
        public void damesSurAuMoinsUneCase() {
            for (int i = 1; i <= n; i++) { // --
                Clause dameSurAuMoinsUneLigne = new Clause(new ArrayList<>());
                for (int k = 0; k < n; k++) { // |
                    dameSurAuMoinsUneLigne.insert(new Literal(2 * (i + k * n) - 1));
                }
                formule.insert(dameSurAuMoinsUneLigne);
            }
        }

        /**
         * Génère les clauses pour la condition : une dame sur au plus une ligne.
         */
        public void damesSurAuPlusUneLigne() {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        Clause dameSurAuPlusUneLigne = new Clause(new ArrayList<>());
                        dameSurAuPlusUneLigne.insert(new Literal(2 * (i + j * n)));
                        dameSurAuPlusUneLigne.insert(new Literal(2 * (i + k * n)));
                        formule.insert(dameSurAuPlusUneLigne);
                    }
                }
            }
        }

        /**
         * Génère les clauses pour la condition : une dame sur au plus une colonne.
         */
        public void damesSurAuPlusUneColonne() {
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j < n - 1; j++) {
                    for (int k = j + 1; k < n; k++) {
                        Clause dameSurAuPlusUneColonne = new Clause(new ArrayList<>());
                        dameSurAuPlusUneColonne.insert(new Literal(2 * ((i - 1) * n + 1 + j)));
                        dameSurAuPlusUneColonne.insert(new Literal(2 * ((i - 1) * n + 1 + k)));
                        formule.insert(dameSurAuPlusUneColonne);
                    }
                }
            }
        }

        /**
         * Génère les clauses pour la condition : une dame au plus par diagonale.
         */
        public void auPlusUneDameSurDiag() {
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n - i; j++) {
                    for (int k = j + 1; k <= n - i; k++) {
                        Clause diagCroiss = new Clause(new ArrayList<>());
                        diagCroiss.insert(new Literal(2 * (n * (n - 1) + 1 - (i - 1) * n - j * (n - 1))));
                        diagCroiss.insert(new Literal(2 * (n * (n - 1) + 1 - (i - 1) * n - k * (n - 1))));
                        formule.insert(diagCroiss);
                        if (i != 1) {
                            Clause diagDecroiss =  new Clause(new ArrayList<>());
                            diagDecroiss.insert(new Literal(2 * (n * (n - 1) + i - j * (n - 1))));
                            diagDecroiss.insert(new Literal(2 * (n * (n - 1) + i - k * (n - 1))));
                            formule.insert(diagDecroiss);
                        }
                    }
                }
            }
        }

        /**
         * Génère les clauses pour la condition : une dame au plus par anti-diagonale.
         */
        public void auPlusUneDameSurAntiDiag() {
            for (int i = 0; i < n - 1; i++) {
                for (int j = 0; j < n - i; j++) {
                    for (int k = j + 1; k < n - i; k++) {
                        Clause diagCroiss = new Clause(new ArrayList<>());
                        diagCroiss.insert(new Literal(2 * (i * n + 1 + j * (n + 1))));
                        diagCroiss.insert(new Literal(2 * (i * n + 1 + k * (n + 1))));
                        formule.insert(diagCroiss);
                        if (i != 0) {
                            Clause diagDecroiss = new Clause(new ArrayList<>());
                            diagDecroiss.insert(new Literal(2 * (i + 1 + j * (n + 1))));
                            diagDecroiss.insert(new Literal(2 * (i + 1 + k * (n + 1))));
                            formule.insert(diagDecroiss);
                        }
                    }
                }
            }
        }
    }

