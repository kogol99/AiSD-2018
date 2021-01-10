package Lista11;

import java.util.ArrayList;
import java.util.Random;

public class Proces {

    private int prawdopodobienstwoZarazeniaChory = 40;
    private int prawdopodobienstwoZarazeniaZdrowy = 40;
    private int prawdopodobienstwoOdkryciaDobrej = 5;
    Graph graph = new Graph();

    public int rozpocznij(){
        int liczbaKrokow = 0;
        graph.addEdge(147,129);
        graph.addEdge(148,129);
        graph.addEdge(149,129);
        graph.addEdge(146,129);
        graph.addEdge(146,130);
        graph.addEdge(130,103);
        graph.addEdge(131,103);
        graph.addEdge(128,127);
        graph.addEdge(127,150);
        graph.addEdge(103,127);
        graph.addEdge(132,103);
        graph.addEdge(47,103);
        graph.addEdge(47,48);
        graph.addEdge(48,105);
        graph.addEdge(105,104);
        graph.addEdge(48,10);
        graph.addEdge(10,11);
        graph.addEdge(50,11);
        graph.addEdge(49,11);
        graph.addEdge(11,2);
        graph.addEdge(2,12);
        graph.addEdge(12,97);
        graph.addEdge(97,98);
        graph.addEdge(133,132);
        graph.addEdge(145,133);
        graph.addEdge(134,133);
        graph.addEdge(144,134);
        graph.addEdge(106,102);
        graph.addEdge(106,101);
        graph.addEdge(134,106);
        graph.addEdge(135,134);
        graph.addEdge(135,107);
        graph.addEdge(108,107);
        graph.addEdge(136,108);
        graph.addEdge(136,137);
        graph.addEdge(137,135);
        graph.addEdge(136,55);
        graph.addEdge(55,109);
        graph.addEdge(143,138);
        graph.addEdge(138,139);
        graph.addEdge(142,139);
        graph.addEdge(139,110);
        graph.addEdge(110,140);
        graph.addEdge(140,54);
        graph.addEdge(141,61);
        graph.addEdge(61,60);
        graph.addEdge(60,65);
        graph.addEdge(65,66);
        graph.addEdge(66,67);
        graph.addEdge(52,54);
        graph.addEdge(54,56);
        graph.addEdge(56,57);
        graph.addEdge(57,101);
        graph.addEdge(44,43);
        graph.addEdge(43,45);
        graph.addEdge(58,43);
        graph.addEdge(58,51);
        graph.addEdge(59,58);
        graph.addEdge(51,42);
        graph.addEdge(54,59);
        graph.addEdge(53,62);
        graph.addEdge(62,64);
        graph.addEdge(64,63);
        graph.addEdge(40,41);
        graph.addEdge(63,41);
        graph.addEdge(63,37);
        graph.addEdge(37,38);
        graph.addEdge(67,38);
        graph.addEdge(38,39);
        graph.addEdge(47,46);
        graph.addEdge(46,1);
        graph.addEdge(1,2);
        graph.addEdge(2,3);
        graph.addEdge(12,15);
        graph.addEdge(99,96);
        graph.addEdge(100,96);
        graph.addEdge(96,13);
        graph.addEdge(13,94);
        graph.addEdge(13,14);
        graph.addEdge(3,14);
        graph.addEdge(3,4);
        graph.addEdge(4,18);
        graph.addEdge(5,4);
        graph.addEdge(1,5);
        graph.addEdge(5,18);
        graph.addEdge(6,1);
        graph.addEdge(6,42);
        graph.addEdge(42,5);
        graph.addEdge(5,19);
        graph.addEdge(42,19);
        graph.addEdge(66,68);
        graph.addEdge(68,70);
        graph.addEdge(70,34);
        graph.addEdge(39,36);
        graph.addEdge(36,34);
        graph.addEdge(34,69);
        graph.addEdge(38,19);
        graph.addEdge(19,20);
        graph.addEdge(19,21);
        graph.addEdge(21,17);
        graph.addEdge(17,18);
        graph.addEdge(20,17);
        graph.addEdge(17,111);
        graph.addEdge(111,22);
        graph.addEdge(35,22);
        graph.addEdge(22,33);
        graph.addEdge(33,71);
        graph.addEdge(73,71);
        graph.addEdge(72,73);
        graph.addEdge(71,74);
        graph.addEdge(74,78);
        graph.addEdge(33,75);
        graph.addEdge(75,77);
        graph.addEdge(77,116);
        graph.addEdge(115,116);
        graph.addEdge(116,114);
        graph.addEdge(114,113);
        graph.addEdge(113,117);
        graph.addEdge(118,119);
        graph.addEdge(76,79);
        graph.addEdge(79,81);
        graph.addEdge(81,119);
        graph.addEdge(119,82);
        graph.addEdge(82,83);
        graph.addEdge(17,32);
        graph.addEdge(32,30);
        graph.addEdge(80,32);
        graph.addEdge(32,76);
        graph.addEdge(76,30);
        graph.addEdge(124,122);
        graph.addEdge(86,120);
        graph.addEdge(122,121);
        graph.addEdge(121,120);
        graph.addEdge(120,118);
        graph.addEdge(16,26);
        graph.addEdge(17,14);
        graph.addEdge(16,14);
        graph.addEdge(14,93);
        graph.addEdge(27,29);
        graph.addEdge(93,92);
        graph.addEdge(93,90);
        graph.addEdge(124,125);
        graph.addEdge(124,126);
        graph.addEdge(124,123);
        graph.addEdge(92,91);
        graph.addEdge(91,124);
        graph.addEdge(124,88);
        graph.addEdge(88,87);
        graph.addEdge(84,29);
        graph.addEdge(29,28);
        graph.addEdge(26,23);
        graph.addEdge(23,112);
        graph.addEdge(112,25);
        graph.addEdge(25,24);
        graph.addEdge(31,84);
        graph.addEdge(84,85);
        graph.addEdge(85,88);
        graph.addEdge(88,89);
        graph.addEdge(89,90);
        graph.addEdge(93,27);
        graph.addEdge(27,95);
        graph.addEdge(95,14);
        graph.setStartPoint(129);
        graph.setStartPoint(11);
        graph.setStartPoint(124);
        graph.setStartPoint(19);
        graph.setStartPoint(32);
        graph.setStartPoint(54);
        System.out.println();
        System.out.println("----------------- Lsita sasiedztwa utworzonego grafu ... -----------------");
        Lista_sasiedztwa lista = new Lista_sasiedztwa(graph);
        System.out.println();
        System.out.println("----------------- Proces zarazania ... -----------------");
        System.out.println("---------- procent zdrowych | procent chorych ----------");
        while(!graph.sprawdzCzyZdroweWszystkie()){
            liczbaKrokow++;
            System.out.println("Krok " + liczbaKrokow + ": ");
            zainfekuj();
            //System.out.println("Po nowych cohorobach:");
            //lista.wypisz_Liste();
            zdrowiej();
            //System.out.println("Po nowych zdrowych:");
            //lista.wypisz_Liste();
            sprawdzProcenty();
        }
        return liczbaKrokow;
    }

    private void zainfekuj(){
        ArrayList<Edge> allEdgeArray = graph.getAllEdges();
        ArrayList<Vertex> allChoreVertexArray = graph.getListaChorych();
        int edgeAmmount = graph.getEdgeAmmount();

        for(Vertex vertex: allChoreVertexArray){
            for(int j=0; j<edgeAmmount; j++){
                if(allEdgeArray.get(j).getSource().getValue() == vertex.getValue()){
                    if(allEdgeArray.get(j).getDestination().getCondition()==1){  // czy jest zdrowy
                        // jesli pierwszy chory a drugi zdrowy to pomijamy
                    }
                    if(allEdgeArray.get(j).getDestination().getCondition()==0){  // czy jest neutralny
                        if(czyBdZdrowyOdChorego()){
                            allEdgeArray.get(j).getDestination().setCondition(1);
                        } else {
                            if(czyBdChory()){
                                allEdgeArray.get(j).getDestination().setCondition(2);
                            }
                        }
                        allEdgeArray.get(j).getDestination().setInfected(true);
                    }
                }
            }
        }
    }

    private void zdrowiej(){
        ArrayList<Edge> allEdgeArray = graph.getAllEdges();
        ArrayList<Vertex> allZdroweVertexArray = graph.getListaZdrowych();
        int edgeAmmount = graph.getEdgeAmmount();

        for(Vertex vertex: allZdroweVertexArray){
            for(int j=0; j<edgeAmmount; j++){
                if(allEdgeArray.get(j).getSource().getValue() == vertex.getValue()){
                    if(allEdgeArray.get(j).getDestination().getCondition()==2){
                        if(czyBdZdrowy()){
                            allEdgeArray.get(j).getDestination().setCondition(1);
                        }
                    }
                    if(allEdgeArray.get(j).getDestination().getCondition()==0){
                        allEdgeArray.get(j).getDestination().setCondition(1);  // jesli pierwszy zdrowy a drugi neutralny to drugiego robimy zdrowego
                        allEdgeArray.get(j).getDestination().setInfected(true);
                    }
                }
            }

        }
    }

    private boolean czyBdZdrowyOdChorego(){
        Random rand = new Random();
        int randomInt = rand.nextInt(99)+1;
        if(randomInt<prawdopodobienstwoOdkryciaDobrej){
            return true;
        }
        return false;
    }

    private boolean czyBdChory(){
        Random rand = new Random();
        int randomInt = rand.nextInt(99)+1;
        if(randomInt<prawdopodobienstwoZarazeniaChory){
            return true;
        }
        return false;
    }

    private boolean czyBdZdrowy(){
        Random rand = new Random();
        int randomInt = rand.nextInt(99)+1;
        if(randomInt<prawdopodobienstwoZarazeniaZdrowy){
            return true;
        }
        return false;
    }

    private void sprawdzProcenty(){
        ArrayList<Vertex> vertexArrayList = graph.getAllVertex();
        double liczbaZdrowych=0;
        double liczbaChorych=0;
        for(Vertex vertex: vertexArrayList){
            if(vertex.getCondition()==1){
                liczbaZdrowych++;
            }
            if(vertex.getCondition()==2){
                liczbaChorych++;
            }
        }
        System.out.printf("%.2f", liczbaZdrowych/vertexArrayList.size()*100);
        System.out.print(" | ");
        System.out.printf("%.2f", liczbaChorych/vertexArrayList.size()*100);
        System.out.println();
        System.out.println();
    }
}
