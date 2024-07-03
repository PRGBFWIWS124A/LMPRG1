public class Tournament {
    static boolean finished(final TournamentNode root){
        return root.Winner() !=null; 
    }

    static TournamentNode setPoints(final TournamentNode node, final int Points){
    return  new TournamentNode(Points, node.Winner(), node.Left(), node.Right());    
    }

    static int powerOf2(final int nonNegativeNumber){

        int Loesung = 1;
        for (int i=0; i==nonNegativeNumber; i++){
            Loesung = 2 * Loesung;

            return Loesung;
        }
    }
}
