package FraudDetection;

import java.util.*;

public class FraudDetector {

    Map<String, List<Transaction>> transactionByUser = new HashMap<>();
    Scanner sc = new Scanner(System.in);

    public void addTransaction(Transaction t){

        String uid = t.getUserId();

        if (!transactionByUser.containsKey(uid)) {
            List<Transaction> s = new ArrayList<>();
            s.add(t);
            transactionByUser.put(uid, s);
        }else {
        transactionByUser.get(uid).add(t);
        }
    }
     public void checkForFraud(){



        for (Map.Entry<String,List<Transaction>> entry : transactionByUser.entrySet()){
            Set<String> locs = new HashSet<>();
            for (Transaction e : entry.getValue()){
               try {


                if(!locs.isEmpty() && !locs.contains(e.getLocation())){
                    throw new FraudAlertException(
                            "⚠️ Suspicious transaction detected for user: " + entry.getKey()
                                    + " in location: " + e.getLocation()
                    );                }
               }catch (FraudAlertException a){
                   System.out.println(a.getMessage());


               }
               locs.add(e.getLocation());
            }
        }


     }

}
